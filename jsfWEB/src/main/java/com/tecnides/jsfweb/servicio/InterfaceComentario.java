package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.ArregloComentarioDTO;
import com.tecnides.dominio.ComentarioDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceComentario {

	List<ComentarioDTO> consultaComentarios();
	ResponseDTO eliminarComentarios(ArregloComentarioDTO deleteComnetarios);
	
}
