package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.EmpresaDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceEmpresa {
	
	List<EmpresaDTO> getAllEmpresas ();
	ResponseDTO accionEmpresa (EmpresaDTO obj);
}
