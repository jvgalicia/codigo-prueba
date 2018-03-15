package com.tecnides.jsfweb.servicio;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioCatalogoImpl implements InterfaceCatalogos{

	private static final Logger log = LoggerFactory.getLogger(ServicioCatalogoImpl.class);
	@Override
	public List<CatalogoIdValor> getTipoUsuario() {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/tipoUsuario")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getTipoUsuario ", ex);
        }
        return (List<CatalogoIdValor>) listaCatalogo;
	}
	@Override
	public List<CatalogoIdValor> getCatEmpresas() {

		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catEmpresa")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getCatEmpresas", ex);
        }
        return (List<CatalogoIdValor>) listaCatalogo;
	}
	@Override
	public List<CatalogoIdValor> getCatPeriodicidad() {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catPeriodicidadPago")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getCatPeriodicidad ", ex);
        }
        return (List<CatalogoIdValor>) listaCatalogo;
	}
	@Override
	public List<CatalogoIdValor> getCatAdministradora() {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catAdministradoras")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getCatAdministradora ", ex);
        }
        return (List<CatalogoIdValor>) listaCatalogo;
	}
	@Override
	public List<CatalogoIdValor> getComercializadora() {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catComercializadora")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getCatAdministradora ", ex);
        }
        return (List<CatalogoIdValor>) listaCatalogo;
	}
	@Override
	public List<CatalogoIdValor> getAdminByComer(long idcomer) {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catAdminByComer/" + idcomer )
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	 return (List<CatalogoIdValor>) listaCatalogo;
        } catch (Exception ex) {
        	log.error("Error en getAdminByComer ", ex);
        	return null;
        }
       
	}
	@Override
	public List<CatalogoIdValor> getComerByAdmin(long idAdmin) {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catComerByAdmin/" + idAdmin )
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	 return (List<CatalogoIdValor>) listaCatalogo;
        } catch (Exception ex) {
        	log.error("Error en getAdminByComer ", ex);
        	return null;
        }
	}
	@Override
	public List<CatalogoIdValor> getEmpresaByComer(long idComer) {
		Collection<? extends CatalogoIdValor> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restCatalogos/CatalogosServicio/catEmpresaByComer/" + idComer )
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(CatalogoIdValor.class);
        	 return (List<CatalogoIdValor>) listaCatalogo;
        } catch (Exception ex) {
        	log.error("Error en getAdminByComer ", ex);
        	return null;
        }
	}

}
