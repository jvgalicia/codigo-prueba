package com.tecnides.jsfweb.utilidades;

import java.io.File;
import java.net.URL;

public class Constantes {

	
	public static final String urlServicios = Utilidades.ConexionRest() ; 
	public static final String keyAES = "D491060961CCCFF0";
	public static final String ivAES = "795FB94BBD777DB8";
	public static final String stringResource = urlPhant();
	
	public static String urlPhant(){
		URL pathResource = Constantes.class.getResource("/");
		String stringResource = pathResource.getPath();
		stringResource = stringResource.replace("/", File.separator);
		stringResource += "META-INF" + File.separator ; 
		return stringResource;
	}
		
	
}
