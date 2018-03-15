package com.tecnides.jsfweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.AdministradoraDTO;
import com.tecnides.dominio.ComercializadoraDTO;
import com.tecnides.dominio.NewcoAdminDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.reportes.generateReporte;
import com.tecnides.jsfweb.servicio.InterfaceAdministradora;
import com.tecnides.jsfweb.utilidades.SessionUtils;

import net.sf.jasperreports.engine.JRException;

@ManagedBean
@SessionScoped
public class BeanAdministradora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String session = SessionUtils.getTipoUsuario();
	private static final Logger log = LoggerFactory.getLogger(BeanAdministradora.class);

	private ResponseDTO resposeDTO;
	private AdministradoraDTO administradora;
	private List<AdministradoraDTO> listaAdmin;
	private List<ComercializadoraDTO> listaComercializadora;
	@ManagedProperty("#{interfaceAdministradora}")
	private InterfaceAdministradora serviceAdministradora;

	public ResponseDTO getResposeDTO() {
		return resposeDTO;
	}

	public void setResposeDTO(ResponseDTO resposeDTO) {
		this.resposeDTO = resposeDTO;
	}

	public List<AdministradoraDTO> getListaAdmin() {
		return listaAdmin;
	}

	public void setListaAdmin(List<AdministradoraDTO> listaAdmin) {
		this.listaAdmin = listaAdmin;
	}

	public InterfaceAdministradora getServiceAdministradora() {
		return serviceAdministradora;
	}

	public void setServiceAdministradora(InterfaceAdministradora serviceAdministradora) {
		this.serviceAdministradora = serviceAdministradora;
	}

	public AdministradoraDTO getAdministradora() {
		return administradora;
	}

	public void setAdministradora(AdministradoraDTO administradora) {
		this.administradora = administradora;
	}

	public List<ComercializadoraDTO> getListaComercializadora() {
		return listaComercializadora;
	}

	public void setListaComercializadora(List<ComercializadoraDTO> listaComercializadora) {
		this.listaComercializadora = listaComercializadora;
	}

	public String listaAdministradora() {
		log.info("entra listaAdministradora");
		setListaAdmin(getServiceAdministradora().getAllAdministradora());
		ResponseDTO nuevoDTO = new ResponseDTO();
		nuevoDTO.setMsg("");
		resposeDTO = nuevoDTO;
		return session;
	}

	public String editarAdministradora() {
		administradora.setComercializadoraDTO(listaComercializadora);
		resposeDTO = getServiceAdministradora().crearAdministradora(administradora);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", resposeDTO.getMsg()));
		return "";
	}
	
	public String agregarAdministradora() {
		administradora.setAdmId(0);
		administradora.setComercializadoraDTO(listaComercializadora);
		resposeDTO = getServiceAdministradora().crearAdministradora(administradora);
		return "";
	}

	public String bajaAdmin() {
		administradora.setAdmStatus("Baja");
		resposeDTO = getServiceAdministradora().crearAdministradora(administradora);
		return "";
	}

	public String generarReporte() throws JRException {
		ResponseDTO newresposeDTO =  new ResponseDTO ();
		newresposeDTO = getServiceAdministradora().consultaByIDAdmin(administradora.getAdmId());
		
		log.info("Entra al metodo Reporte");
		generateReporte.ReporteEmpresa(newresposeDTO);
		return "";
	}
	
	@PostConstruct
	public void iniciar(){
		administradora = new AdministradoraDTO();
		listaComercializadora = new ArrayList<ComercializadoraDTO>();
	}
	
	public void asignarComer() {
		ComercializadoraDTO agrega;
		int count=0;
		if (getListaComercializadora() != null) {
			int incremet =  getListaComercializadora().size();
		    if(incremet >= count){
			agrega =new ComercializadoraDTO();
			agrega.setComId(count);
			listaComercializadora.add(agrega);
			setListaComercializadora(listaComercializadora);
			administradora.setNumeroComercializadoras(count);
			count++;
		}
		}else{
			listaComercializadora = new ArrayList<ComercializadoraDTO>();
			agrega =new ComercializadoraDTO();
			agrega.setComId(1);
			listaComercializadora.add(agrega);
			setListaComercializadora(listaComercializadora);
			administradora.setNumeroComercializadoras(count);
			count++;
		}
			
			


	}

	public void eliminarRegistro(ComercializadoraDTO id) {
		listaComercializadora.remove(id);
	    setListaComercializadora(listaComercializadora);
	}
	public String paginaEditar(AdministradoraDTO val){
		log.info("valor id editar " + val.getAdmId() );
		ResponseDTO valores = new ResponseDTO();
		valores = getServiceAdministradora().consultaByIDAdmin(val.getAdmId());
		List<AdministradoraDTO> adminsval = (List<AdministradoraDTO>)valores.getObjDTO();
		AdministradoraDTO adminDTO;
		for (AdministradoraDTO valAdmin: adminsval) {
			if (valAdmin.getComercializadoraDTO() != null ) {
				int numeroAdmin =  valAdmin.getComercializadoraDTO().size();
				log.info("numero admin" + numeroAdmin);
				valAdmin.setNumeroComercializadoras(numeroAdmin);
			}
			setAdministradora(valAdmin);
			setListaComercializadora(valAdmin.getComercializadoraDTO());
		}		
		return session;
	}

}
