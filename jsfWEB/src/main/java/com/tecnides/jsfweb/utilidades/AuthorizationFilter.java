package com.tecnides.jsfweb.utilidades;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@WebFilter(servletNames = {"Faces Servlet"})
public class AuthorizationFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);
	
	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			
			if (reqURI.indexOf("/capp.com") >= 0
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")
					|| (ses != null && ses.getAttribute("username") != null)){
				chain.doFilter(request, response);
				}else{
				resp.sendRedirect(reqt.getContextPath() + "/capp.com");
			}
		} catch (Exception e) {
			log.error("Error en la Autentificaccion  ", e );
		}
	}

	@Override
	public void destroy() {

	}

}