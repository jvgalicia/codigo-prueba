package com.tecnides.jsfweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.dominio.NewcoAdminDTO;
import com.tecnides.dominio.NewcoDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;
import com.tecnides.jsfweb.servicio.InterfaceNewCo;
import com.tecnides.jsfweb.utilidades.SessionUtils;

@ManagedBean
public class BeanNewCo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(BeanNewCo.class);
	private Map<Integer, String> CatAdministradora = new HashMap<Integer, String>();
	private String session = SessionUtils.getTipoUsuario();
	private List<NewcoDTO> listaNewco;
	private List<NewcoAdminDTO> listanewcoAdmin;
	private NewcoAdminDTO newcoAdminDTO;
	private NewcoDTO newcoDTO;
	private ResponseDTO resposeDTO;
	@ManagedProperty("#{InterfaceNewCo}")
	private InterfaceNewCo servicioNewco;
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;

	public List<NewcoDTO> getListaNewco() {
		return listaNewco;
	}

	public void setListaNewco(List<NewcoDTO> listaNewco) {
		this.listaNewco = listaNewco;
	}

	public NewcoDTO getNewcoDTO() {
		return newcoDTO;
	}

	public void setNewcoDTO(NewcoDTO newcoDTO) {
		this.newcoDTO = newcoDTO;
	}

	public ResponseDTO getResposeDTO() {
		return resposeDTO;
	}

	public void setResposeDTO(ResponseDTO resposeDTO) {
		this.resposeDTO = resposeDTO;
	}

	public InterfaceNewCo getServicioNewco() {
		return servicioNewco;
	}

	public void setServicioNewco(InterfaceNewCo servicioNewco) {
		this.servicioNewco = servicioNewco;
	}

	public Map<Integer, String> getCatAdministradora() {
		return CatAdministradora;
	}

	public void setCatAdministradora(Map<Integer, String> catAdministradora) {
		CatAdministradora = catAdministradora;
	}

	public InterfaceCatalogos getServicioCatalogos() {
		return servicioCatalogos;
	}

	public void setServicioCatalogos(InterfaceCatalogos servicioCatalogos) {
		this.servicioCatalogos = servicioCatalogos;
	}

	public List<NewcoAdminDTO> getlistanewcoAdmin() {
		return listanewcoAdmin;
	}

	public void setlistanewcoAdmin(List<NewcoAdminDTO> newcoAdmin) {
		this.listanewcoAdmin = newcoAdmin;
	}

	public NewcoAdminDTO getNewcoAdminDTO() {
		return newcoAdminDTO;
	}

	public void setNewcoAdminDTO(NewcoAdminDTO newcoAdminDTO) {
		this.newcoAdminDTO = newcoAdminDTO;
	}

	public String listaNewco() {
		setListaNewco(getServicioNewco().consultaNewCo());
		ResponseDTO nuevoDTO = new ResponseDTO();
		nuevoDTO.setMsg("");
		resposeDTO = nuevoDTO;

		return session;
	}

	public String agregarNewco() {

		return session;
	}

	public String altaNewco() {
		newcoDTO.setAdministradoras(getlistanewcoAdmin());
		resposeDTO = servicioNewco.altaNewco(newcoDTO);
		return "";
	}
	public String editarNewco() {
		newcoDTO.setAdministradoras(getlistanewcoAdmin());
		resposeDTO = servicioNewco.altaNewco(newcoDTO);
		return "";
	}

	public String eliminarNewco() {
		
		newcoDTO.setNewStatus("Baja");
		log.info("valor id eliminar " + newcoDTO.getNewId());
		resposeDTO = servicioNewco.altaNewco(newcoDTO);
		return "";
	}
	
	public void catAdminsitradoras() {
		try {
			List<CatalogoIdValor> idValor = getServicioCatalogos().getCatAdministradora();
			CatAdministradora = new HashMap<Integer, String>();
			for (CatalogoIdValor valor : idValor) {
				CatAdministradora.put((int) valor.getId(), valor.getValor());
			}

			setCatAdministradora(CatAdministradora);
		} catch (Exception e) {
			log.error("Tipo de error catAdminsitradoras", e);
		}
	}

	@PostConstruct
	public void iniciar() {
		catAdminsitradoras();
		newcoDTO = new NewcoDTO();
		newcoAdminDTO = new NewcoAdminDTO();
		listanewcoAdmin = new ArrayList<NewcoAdminDTO>();
		newcoAdminDTO.setIdNead(0);
		listanewcoAdmin.add(newcoAdminDTO);
		setlistanewcoAdmin(listanewcoAdmin);
	}

	public void asignarNewco() {
		NewcoAdminDTO agrega;
		int count=0;
		int incremet =  getlistanewcoAdmin().size();
		if(incremet >= count){
			agrega =new NewcoAdminDTO();
			agrega.setIdNead(count);
			agrega.setCreditoadmin("");
			agrega.setPartiporcentual("");
			agrega.setidAdministradora(0);
			listanewcoAdmin.add(agrega);
			setlistanewcoAdmin(listanewcoAdmin);
			count++;
			
			
		}	


	}

	public void eliminarRegistro(NewcoAdminDTO id) {
		listanewcoAdmin.remove(id);
		setlistanewcoAdmin(listanewcoAdmin);
	}
}
