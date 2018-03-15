package com.tecnides.jsfweb.servicio;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.MonederoDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioMonederoImpl implements InterfaceMonedero{

	private static final Logger log = LoggerFactory.getLogger(ServicioEmpresaImpl.class);
	
	@Override
	public ResponseDTO<?> altaMonedero(MonederoDTO objMonero) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restMonedero/monero/altaMonedero")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(objMonero, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error Guardar Empresa Rest ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO<?> consultaMonederobyId(MonederoDTO idEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonederoDTO> consultaMonedero() {
		// TODO Auto-generated method stub
		return null;
	}

}
