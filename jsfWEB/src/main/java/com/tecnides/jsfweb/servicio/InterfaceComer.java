package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.ComercializadoraDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceComer {

	
	List<ComercializadoraDTO> consultaComercializadora();	
	ResponseDTO<?> altaComercializadora(ComercializadoraDTO administradoraDTO);
	
}
