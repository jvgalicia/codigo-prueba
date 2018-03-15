package com.tecnides.jsfweb.servicio;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.AdministradoraDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioAdministradoraImpl implements InterfaceAdministradora {

	private static final Logger log = LoggerFactory.getLogger(ServicioAdministradoraImpl.class);
	
	@Override
	public ResponseDTO crearAdministradora(AdministradoraDTO obj) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restAdministradoras/serviceAdministradora/altaAdministradora")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(obj, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error Guardar Administradora ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO consultaByIDAdmin(long idAdmin) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restAdministradoras/serviceAdministradora/consultaAdminbyID")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(idAdmin, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error consultaByIDAdmin ", ex);
        }
        return responseDto;
	}

	@Override
	public List<AdministradoraDTO> getAllAdministradora() {

		Collection<? extends AdministradoraDTO> listaAdministradora = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaAdministradora = client
					.path("/restAdministradoras/serviceAdministradora/consultaAdministradoras")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(AdministradoraDTO.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getAllAdministradora ", ex);
        }
        return (List<AdministradoraDTO>) listaAdministradora;
	}

}
