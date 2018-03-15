package com.tecnides.jsfweb.servicio;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

@Service
public class ServicioReporteImpl implements InterfaceReporte{

	private static final Logger log = LoggerFactory.getLogger(ServicioReporteImpl.class);
	
	@Override
	public ResponseDTO<?> reporteVentas(String fechainicio, String fechaFin, long idAdministradora, long idComercializadora,
			long idEmpresa, String montoMenor, String montoMayor) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restReportes/servicioReportes/ReporteVentas/"+fechainicio+"/"+fechaFin+"/"+idAdministradora+"/"
							+idComercializadora+"/"+idEmpresa+"/"+montoMenor+"/"+montoMayor)
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.get(ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error reporteVentas ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO<?> reporteTransaccion(String fechainicio, String fechaFin, long idAdministradora,
			long idComercializadora, long idEmpresa, String montoMenor, String montoMayor) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restReportes/servicioReportes/ReporteTransacciones/"+fechainicio+"/"+fechaFin+"/"+idAdministradora+"/"
							+idComercializadora+"/"+idEmpresa+"/"+montoMenor+"/"+montoMayor)
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.get(ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error reporteTransaccion ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO<?> reporteListaNegra(String fechainicio, String fechaFin, long idAdministradora,
			String montoMenor, String montoMayor) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restReportes/servicioReportes/ReporteListaNegra/"+fechainicio+"/"+fechaFin+"/"+idAdministradora+"/"
							+montoMenor+"/"+montoMayor)
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.get(ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Rest Error reporteListaNegra ", ex);
        }
        return responseDto;
	}

}
