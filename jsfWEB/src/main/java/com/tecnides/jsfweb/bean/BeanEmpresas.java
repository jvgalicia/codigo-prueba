package com.tecnides.jsfweb.bean;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.dominio.EmpresaDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;
import com.tecnides.jsfweb.servicio.InterfaceEmpresa;
import com.tecnides.jsfweb.utilidades.SessionUtils;

@ManagedBean
@SessionScoped
public class BeanEmpresas {

	private static final long serialVersionUID = 1L;
	private String session = SessionUtils.getTipoUsuario();
	private static final Logger log = LoggerFactory.getLogger(BeanEmpresas.class);

	
	private ResponseDTO resposeDTO;
	private EmpresaDTO empresa;
	private Map<Integer, String> catAdministradora = new HashMap<Integer, String>();
	private Map<Integer, String> catComercializadora = new HashMap<Integer, String>();
	private Map<Integer, String> periodicidadpago = new HashMap<Integer, String>();
	private List<EmpresaDTO> listaEmpresa;
	@ManagedProperty("#{InterfaceEmpresa}")
	private InterfaceEmpresa servicioEmpresa;
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public ResponseDTO getResposeDTO() {
		return resposeDTO;
	}

	public void setResposeDTO(ResponseDTO resposeDTO) {
		this.resposeDTO = resposeDTO;
	}

	public List<EmpresaDTO> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<EmpresaDTO> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public InterfaceEmpresa getServicioEmpresa() {
		return servicioEmpresa;
	}

	public void setServicioEmpresa(InterfaceEmpresa servicioEmpresa) {
		this.servicioEmpresa = servicioEmpresa;
	}

	public InterfaceCatalogos getServicioCatalogos() {
		return servicioCatalogos;
	}

	public void setServicioCatalogos(InterfaceCatalogos servicioCatalogos) {
		this.servicioCatalogos = servicioCatalogos;
	}

	public Map<Integer, String> getCatAdministradora() {
		return catAdministradora;
	}

	public void setCatAdministradora(Map<Integer, String> catAdministradora) {
		this.catAdministradora = catAdministradora;
	}

	public Map<Integer, String> getCatComercializadora() {
		return catComercializadora;
	}

	public void setCatComercializadora(Map<Integer, String> catComercializadora) {
		this.catComercializadora = catComercializadora;
	}

	public Map<Integer, String> getperiodicidadpago() {
		return periodicidadpago;
	}

	public void setperiodicidadpago(Map<Integer, String> periodicidadpago) {
		periodicidadpago = periodicidadpago;
	}

	public String listaEmpresa() {
		setListaEmpresa(getServicioEmpresa().getAllEmpresas());
		return session;
	}
	public String navAgregarEmpresa(){
		empresa = new EmpresaDTO();
		catAdminsitradoras();
		catComercializadoras();
		catPeriodicidad();
		return session;
	}
	public String guardarEmpresa(){
		empresa.setId(0);
		resposeDTO = getServicioEmpresa().accionEmpresa(empresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", resposeDTO.getMsg()));
		return "";
	}
	public String eliminarEmpresa(){
		empresa.setStatus("Baja");
		resposeDTO = getServicioEmpresa().accionEmpresa(empresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", resposeDTO.getMsg()));
		return "";
	}
	public String editarEmpresa(){
		resposeDTO = getServicioEmpresa().accionEmpresa(empresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", resposeDTO.getMsg()));
		return "";
	}
	@PostConstruct
	public void init() {
		empresa = new EmpresaDTO();
	}
	
	public void catAdminsitradoras() {
		try {
			
			if (catAdministradora != null) {
				List<CatalogoIdValor> idValor = getServicioCatalogos().getCatAdministradora();
				catAdministradora = new HashMap<Integer, String>();
				for (CatalogoIdValor valor : idValor) {
					catAdministradora.put((int) valor.getId(), valor.getValor());
				}

				setCatAdministradora(catAdministradora);
			}else{
				setCatAdministradora(catAdministradora);
			}
			
			
		} catch (Exception e) {
			log.error("Tipo de error catAdminsitradoras", e);
		}
	}
	public void catComercializadoras() {
		try {
			log.info("val 2 ");
			List<CatalogoIdValor> idValor = getServicioCatalogos().getComercializadora();
			catComercializadora = new HashMap<Integer, String>();
			for (CatalogoIdValor valor : idValor) {
				catComercializadora.put((int) valor.getId(), valor.getValor());
			}

			setCatComercializadora(catComercializadora);
		} catch (Exception e) {
			log.error("Tipo de error catComercializadora", e);
		}
	}
	public void adminBycomer(){
		log.info("val 3 ");
		long idComer = empresa.getIdComercializadora();
		List<CatalogoIdValor> idValor = getServicioCatalogos().getComerByAdmin(idComer);
		Map<Integer, String> catAdminbyComer = new HashMap<Integer, String>();
		for (CatalogoIdValor valor : idValor) {
			catAdminbyComer.put((int) valor.getId(), valor.getValor());
		}
		catAdministradora = catAdminbyComer;
	}
	
	public void catPeriodicidad() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatPeriodicidad();
		periodicidadpago  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 periodicidadpago.put((int) valor.getId(),valor.getValor());
		}
         setperiodicidadpago(periodicidadpago);
     
		} catch (Exception e) {
			log.error("Tipo de error catPeriodicidad", e);
		}
    }
	
	

}
