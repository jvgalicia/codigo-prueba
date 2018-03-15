/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnides.jsfweb.servicio;

import com.tecnides.dominio.ResponseDTO;
import com.tecnides.dominio.UsuarioDTO;
import com.tecnides.jsfweb.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 *
 * @author ocvillegas
 */
@Service
public class ServicioUsuarioImpl implements InterfaceUsuario{

	private static final Logger log = LoggerFactory.getLogger(ServicioUsuarioImpl.class);

	@Override
	public ResponseDTO validarUsuario(UsuarioDTO objUsuario) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {

        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restUsuario/serviceUsuario/validaUsuario")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(objUsuario, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Error en validar Empleado ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO crearUsuario(UsuarioDTO obj) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
    		System.out.println("esta en el metodo crear" + responseDto.getMsg()+"55");
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restUsuario/serviceUsuario/altaUsuario")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(obj, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Error en validar Empleado ", ex);
        }
        return responseDto;
	}

	@Override
	public ResponseDTO consultaByID(UsuarioDTO obj) {
		ResponseDTO responseDto = new ResponseDTO ();
    	try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
    		responseDto = client
					.path("/restUsuario/serviceUsuario/consultaUserbyId")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.post(obj, ResponseDTO.class);
        	
        	
            
        } catch (Exception ex) {
        	log.error("Error en validar Empleado ", ex);
        }
        return responseDto;
	}

	@Override
	public List<UsuarioDTO> consultaUsuarios() {
		
		Collection<? extends UsuarioDTO> listaUsuarios = null;
		 
		try {
        	WebClient client = WebClient
					.create(Utilidades.ConexionRest());
    		
        	listaUsuarios = client
					.path("/restUsuario/serviceUsuario/consultaUsuarios")
					.type(MediaType.APPLICATION_XML)
					.accept(MediaType.APPLICATION_XML)
					.getCollection(UsuarioDTO.class);
        	
        	return (List<UsuarioDTO>) listaUsuarios;
        } catch (Exception ex) {
        	log.error("Error en consultaUsuarios ", ex);
        }
        return  (List<UsuarioDTO>) listaUsuarios;
	}

	
    
}
