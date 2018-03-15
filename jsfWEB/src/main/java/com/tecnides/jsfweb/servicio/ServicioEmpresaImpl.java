package com.tecnides.jsfweb.servicio;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.EmpresaDTO;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioEmpresaImpl implements InterfaceEmpresa {
	
	private static final Logger log = LoggerFactory.getLogger(ServicioEmpresaImpl.class);

	@Override
	public List<EmpresaDTO> getAllEmpresas() {
		Collection<? extends EmpresaDTO> listaEmpresa = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaEmpresa = client
					.path("/restEmpresa/serviceEmpresa/consultaEmpresas")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(EmpresaDTO.class);
        	
        } catch (Exception ex) {
        	log.error("Error en getAllEmpresas ", ex);
        }
        return (List<EmpresaDTO>) listaEmpresa;
		
	}

	@Override
	public ResponseDTO accionEmpresa(EmpresaDTO obj) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restEmpresa/serviceEmpresa/altaEmpresa")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(obj, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error Guardar Empresa Rest ", ex);
        }
        return responseDto;
	}

}
