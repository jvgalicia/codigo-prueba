package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.MonederoDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceMonedero {

	
	ResponseDTO<?> altaMonedero(MonederoDTO objMonero);
    ResponseDTO<?> consultaMonederobyId(MonederoDTO idEmpleado);
    List<MonederoDTO> consultaMonedero();
}
