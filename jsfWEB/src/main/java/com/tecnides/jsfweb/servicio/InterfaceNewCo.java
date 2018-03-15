package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.dominio.NewcoDTO;
import com.tecnides.dominio.ResponseDTO;

public interface InterfaceNewCo {
	
	ResponseDTO<?> consultaNewcobyID(long idNew);
    List<NewcoDTO> consultaNewCo();
	ResponseDTO<?> altaNewco(NewcoDTO newcoDTO);

}
