package com.tecnides.jsfweb.bean;

import com.tecnides.jsfweb.utilidades.SessionUtils;

public class BeanNavegacion {
	private String session = SessionUtils.getTipoUsuario();
	
	
	public String agregarNewco() {
		return session;
	}

	public String agregarComercializadora() {
		return session;
	}
	public String editarComercializadora() {
		return session;
	}
	public String agregarEmpresa(){
		return session;
	}
	public String editarEmpresa(){
		return session;
	}
	
}
