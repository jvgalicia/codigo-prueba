package com.tecnides.jsfweb.servicio;


import com.tecnides.dominio.ResponseDTO;

public interface InterfaceReporte {

	
	ResponseDTO<?> reporteVentas( String fechainicio,
			 String fechaFin,
			 long idAdministradora,
			 long idComercializadora,
			 long idEmpresa,
			 String montoMenor,
			 String montoMayor);
	
	ResponseDTO<?> reporteTransaccion( String fechainicio,
			 String fechaFin,
			 long idAdministradora,
			 long idComercializadora,
			 long idEmpresa,
			 String montoMenor,
			 String montoMayor);
	
	ResponseDTO<?> reporteListaNegra( String fechainicio,
			 String fechaFin,
			 long idAdministradora,
			 String montoMenor,
			 String montoMayor);
	

	
}
