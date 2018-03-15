package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.AdministradoraDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceAdministradora {
	    
	ResponseDTO crearAdministradora (AdministradoraDTO obj);
	
	ResponseDTO consultaByIDAdmin(long idAdmin);
	
	List<AdministradoraDTO> getAllAdministradora ();

}
