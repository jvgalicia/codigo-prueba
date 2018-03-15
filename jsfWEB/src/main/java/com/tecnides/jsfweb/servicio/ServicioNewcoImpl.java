package com.tecnides.jsfweb.servicio;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.NewcoDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioNewcoImpl implements InterfaceNewCo{

	private static final Logger log = LoggerFactory.getLogger(ServicioNewcoImpl.class);
	
	@Override
	public ResponseDTO<?> consultaNewcobyID(long idNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewcoDTO> consultaNewCo() {
		Collection<? extends NewcoDTO> listaNewco = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaNewco = client
					.path("/restNewco/serviceNewco/consultaNewCo")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(NewcoDTO.class);
        	
        } catch (Exception ex) {
        	log.error("Error en consultaNewCo ", ex);
        }
        return (List<NewcoDTO>) listaNewco;
	}

	@Override
	public ResponseDTO<?> altaNewco(NewcoDTO newcoDTO) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restNewco/serviceNewco/altaNewco")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(newcoDTO, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error metodo altaNewco ", ex);
        }
        return responseDto;
	}

}
