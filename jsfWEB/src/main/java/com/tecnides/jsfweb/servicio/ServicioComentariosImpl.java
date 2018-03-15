package com.tecnides.jsfweb.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.tecnides.dominio.ArregloComentarioDTO;
import com.tecnides.dominio.ComentarioDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioComentariosImpl implements InterfaceComentario {

	private static final Logger log = LoggerFactory.getLogger(ServicioComentariosImpl.class);
	
	@Override
	public List<ComentarioDTO> consultaComentarios() {
		Collection<? extends ComentarioDTO> listaCatalogo = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaCatalogo = client
					.path("/restComentarios/serviceComentarios/consultaComentarios")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(ComentarioDTO.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getTipoUsuario ", ex);
        }
        return (List<ComentarioDTO>) listaCatalogo;
	}

	@Override
	public ResponseDTO eliminarComentarios(ArregloComentarioDTO deleteComnetarios) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restComentarios/serviceComentarios/eliminarComentarios")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.put(deleteComnetarios,ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error metodo eliminarComentarios ", ex);
        }
        return responseDto;
	}

}
