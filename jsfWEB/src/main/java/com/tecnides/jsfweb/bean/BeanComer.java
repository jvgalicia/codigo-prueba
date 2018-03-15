package com.tecnides.jsfweb.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.dominio.ComercializadoraDTO;
import com.tecnides.dominio.MonederoDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;
import com.tecnides.jsfweb.servicio.InterfaceComer;
import com.tecnides.jsfweb.servicio.InterfaceMonedero;
import com.tecnides.jsfweb.utilidades.SessionUtils;

@ManagedBean
public class BeanComer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String session = SessionUtils.getTipoUsuario();
	private static final Logger log = LoggerFactory.getLogger(BeanAdministradora.class);
	private UploadedFile file;
	private ComercializadoraDTO comercializadora;
	private List<ComercializadoraDTO> listaComer;
	@ManagedProperty("#{InterfaceComer}")
	private InterfaceComer servicesComer;
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;
	@ManagedProperty("#{interfaceMonedero}")
	private InterfaceMonedero servicioMondero;
	private Map<Integer,String> catAdministradora = new HashMap<Integer,String>();
	private ResponseDTO resposeDTO;
	private MonederoDTO monederoDTO;
	
	public ResponseDTO getResposeDTO() {
		return resposeDTO;
	}

	public void setResposeDTO(ResponseDTO resposeDTO) {
		this.resposeDTO = resposeDTO;
	}
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<ComercializadoraDTO> getListaComer() {
		return listaComer;
	}

	public void setListaComer(List<ComercializadoraDTO> listaComer) {
		this.listaComer = listaComer;
	}

	public ComercializadoraDTO getComercializadora() {
		return comercializadora;
	}

	public void setComercializadora(ComercializadoraDTO comercializadora) {
		this.comercializadora = comercializadora;
	}

	public InterfaceComer getServicesComer() {
		return servicesComer;
	}

	public void setServicesComer(InterfaceComer servicesComer) {
		this.servicesComer = servicesComer;
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

	public MonederoDTO getMonederoDTO() {
		return monederoDTO;
	}

	public void setMonederoDTO(MonederoDTO monederoDTO) {
		this.monederoDTO = monederoDTO;
	}


	public InterfaceMonedero getServicioMondero() {
		return servicioMondero;
	}

	public void setServicioMondero(InterfaceMonedero servicioMondero) {
		this.servicioMondero = servicioMondero;
	}

	public String listaComercializadora() {
		setListaComer(getServicesComer().consultaComercializadora());
		return session;
	}

	@PostConstruct
	public void iniciaBean() {
		comercializadora = new ComercializadoraDTO();
		monederoDTO = new MonederoDTO();
	}

	public String altaComercializadora(){

		log.info(" nombre archvio " + getFile().getFileName());
		if (file != null) {
			log.info(" nombre archvio " + file.getFileName());
			log.info("archvio " );
			InputStream in;
			try {
				in = file.getInputstream();
				int read = 0;
				byte[] bytes = new byte[1024];
				
				while ((read = in.read(bytes)) != -1) {
					log.info("valor " + read );
					log.info("valor bytes " + bytes);
					comercializadora.setComLog(bytes);
				}
				in.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return "";
	}
	public String agregarComercializadora(){
		comercializadora.setComId(0);
		resposeDTO = servicesComer.altaComercializadora(comercializadora);
		return "";
	}
	public String bajaComercializadora(){
		comercializadora.setComStatus("Baja");
		resposeDTO = servicesComer.altaComercializadora(comercializadora);
		return "";
	}
	public String editarComercializadora(){
		comercializadora.setComStatus("Activo");
		resposeDTO = servicesComer.altaComercializadora(comercializadora);
		return "";
	}
	public void catAdministradora() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatAdministradora();
		catAdministradora  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 catAdministradora.put((int) valor.getId(),valor.getValor());
		}
         setCatAdministradora(catAdministradora);
         
		} catch (Exception e) {
			log.error("Tipo de error catAdministradora", e);
		}
    }
	public String paginaAgregarComer(){
		catAdministradora();
		
		return session;
	}
	public String paginaEditarComer(ComercializadoraDTO obj){
		setComercializadora(obj);
		catAdministradora();
		
		return session;
	}
	
	public String GuardarMondero(){
		monederoDTO.setMonederoDonacionId(0);
		monederoDTO.setIdComercializadora(comercializadora.getComId());
		resposeDTO = servicioMondero.altaMonedero(monederoDTO);
		log.info("metodo Guardar mondero ");
		return ""; 
	}

}
