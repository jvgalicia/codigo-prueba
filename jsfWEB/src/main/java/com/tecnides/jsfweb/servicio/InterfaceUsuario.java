/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnides.jsfweb.servicio;


import java.util.List;

import com.tecnides.dominio.ResponseDTO;
import com.tecnides.dominio.UsuarioDTO;

/**
 *
 * @author ocvillegas
 */
public interface InterfaceUsuario {
    
	ResponseDTO validarUsuario (UsuarioDTO obj);
     
	ResponseDTO crearUsuario (UsuarioDTO obj);
	
	ResponseDTO consultaByID(UsuarioDTO obj);
	
	List<UsuarioDTO> consultaUsuarios();
	
     
    
     
     
}
