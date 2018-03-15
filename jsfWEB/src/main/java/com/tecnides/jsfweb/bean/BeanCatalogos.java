package com.tecnides.jsfweb.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;



@ManagedBean
public class BeanCatalogos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BeanCatalogos.class);
	private Map<Integer,String> valorID = new HashMap<Integer,String>();
	private Map<Integer,String> CatEmpresa = new HashMap<Integer,String>();
	private Map<Integer,String> CatAdministradora = new HashMap<Integer,String>();
	private Map<Integer,String> CatPeriodisidad = new HashMap<Integer,String>();
	
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;
	
	public InterfaceCatalogos getServicioCatalogos() {
		return servicioCatalogos;
	}
	public void setServicioCatalogos(InterfaceCatalogos servicioCatalogos) {
		this.servicioCatalogos = servicioCatalogos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Map<Integer,String > getValorID() {
		return valorID;
	}
	public void setValorID(Map<Integer,String> valorID) {
		this.valorID = valorID;
	}
	public Map<Integer, String> getCatEmpresa() {
		return CatEmpresa;
	}
	public void setCatEmpresa(Map<Integer, String> catEmpresa) {
		CatEmpresa = catEmpresa;
	}
	public Map<Integer, String> getCatAdministradora() {
		return CatAdministradora;
	}
	public void setCatAdministradora(Map<Integer, String> catAdministradora) {
		CatAdministradora = catAdministradora;
	}
	public Map<Integer, String> getCatPeriodisidad() {
		return CatPeriodisidad;
	}
	public void setCatPeriodisidad(Map<Integer, String> catPeriodisidad) {
		CatPeriodisidad = catPeriodisidad;
	}
	@PostConstruct
	public void catalogos(){
		catEmpresa();
	    catPeriodicidad();
	    catAdminsitradoras();
	    init();
	}
	
    public void init() {
		try {  
	    
		List<CatalogoIdValor> idValor = getServicioCatalogos().getTipoUsuario();
		 valorID  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 valorID.put((int) valor.getId(),valor.getValor());
		}
         setValorID(valorID);
         
		} catch (Exception e) {
			log.info("Tipo de error " + e);
		}
    }
	
    public void catEmpresa() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatEmpresas();
		CatEmpresa  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 CatEmpresa.put((int) valor.getId(),valor.getValor());
		}
         setValorID(CatEmpresa);
         
		} catch (Exception e) {
			log.error("Tipo de error Empresas", e);
		}
    }
    
    public void catPeriodicidad() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatPeriodicidad();
		CatPeriodisidad  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 CatPeriodisidad.put((int) valor.getId(),valor.getValor());
		}
         setValorID(CatPeriodisidad);
         
		} catch (Exception e) {
			log.error("Tipo de error catPeriodicidad", e);
		}
    }
    
    public void catAdminsitradoras() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatAdministradora();
		CatAdministradora  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 CatAdministradora.put((int) valor.getId(),valor.getValor());
		}
         setValorID(CatAdministradora);
         
		} catch (Exception e) {
			log.error("Tipo de error catAdminsitradoras", e);
		}
    }
	

}
