package com.tecnides.jsfweb.servicio;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.ComercializadoraDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class servicioComerImpl implements InterfaceComer{

	private static final Logger log = LoggerFactory.getLogger(servicioComerImpl.class);
	
	@Override
	public List<ComercializadoraDTO> consultaComercializadora() {

		Collection<? extends ComercializadoraDTO> listacomer = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listacomer = client
					.path("/restComer/serviceComer/consultaComercializadora")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(ComercializadoraDTO.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getAllAdministradora ", ex);
        }
        return (List<ComercializadoraDTO>) listacomer;
	}

	@Override
	public ResponseDTO<?> altaComercializadora(ComercializadoraDTO administradoraDTO) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restComer/serviceComer/altaComercializadora")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(administradoraDTO, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error metodo altaComercializadora ", ex);
        }
        return responseDto;
	}

}
