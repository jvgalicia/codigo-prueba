package com.tecnides.jsfweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.ArregloComentarioDTO;
import com.tecnides.dominio.ComentarioDTO;
import com.tecnides.jsfweb.servicio.InterfaceComentario;
import com.tecnides.jsfweb.utilidades.SessionUtils;

@ManagedBean
public class BeanComentarios {
	
	private static final Logger log = LoggerFactory.getLogger(BeanAdministradora.class);
	private String session = SessionUtils.getTipoUsuario();
	@ManagedProperty("#{InterfaceComentario}")
	private InterfaceComentario servicioComentario;
	private List<ComentarioDTO> listaComentario;
	private ComentarioDTO comentarioDto;
	public InterfaceComentario getServicioComentario() {
		return servicioComentario;
	}
	public void setServicioComentario(InterfaceComentario servicioComentario) {
		this.servicioComentario = servicioComentario;
	}
	public List<ComentarioDTO> getListaComentario() {
		return listaComentario;
	}
	public void setListaComentario(List<ComentarioDTO> listaComentario) {
		this.listaComentario = listaComentario;
	}
	public ComentarioDTO getComentarioDto() {
		return comentarioDto;
	}
	public void setComentarioDto(ComentarioDTO comentarioDto) {
		this.comentarioDto = comentarioDto;
	}
	
	public String listaComentarios(){
		
		setListaComentario(getServicioComentario().consultaComentarios());
		return session;
	}

	public String eliminarComentario(ComentarioDTO val){
	    log.info("Eliminar Comentario " + val );
		ArregloComentarioDTO obj = new ArregloComentarioDTO();
		List<ComentarioDTO> newList = new ArrayList<ComentarioDTO>();
		newList.add(val);
		obj.setComentarioDTO(newList);
		getServicioComentario().eliminarComentarios(obj);
		setListaComentario(getServicioComentario().consultaComentarios());
		return "";
	}
}
