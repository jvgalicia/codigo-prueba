package com.tecnides.jsfweb.utilidades;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = getSession();
		return session.getAttribute("username").toString();
	}
	public static String getNombre() {
		HttpSession session = getSession();
		return session.getAttribute("nombre").toString();
	}
	public static String getApellido() {
		HttpSession session = getSession();
		return session.getAttribute("apellido").toString();
	}

	public static String getTipoUsuario(){
		HttpSession session = getSession();
		return session.getAttribute("tipoUser").toString();
	}
	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}

}
