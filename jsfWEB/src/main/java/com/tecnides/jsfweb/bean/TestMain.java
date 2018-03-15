package com.tecnides.jsfweb.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tecnides.jsfweb.utilidades.Utilidades;

public class TestMain {

	public static void main(String[] args) throws Exception {
	
		 String key = "92AE31A79FEEB2A3"; //llave
		 String iv = "0123456789ABCDEF"; // vector de inicialización
		 String cleartext = "hola";
		 System.out.println("Texto encriptado: "+ Utilidades.aesPwdEncrypt(key, iv, cleartext));

		 SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		 String dateInString1 = "09-01-2017 10:20:56";
		 String dateInString2 = "10-01-2017 10:20:56";
		 Date date1 = sdf.parse(dateInString1);
		 Date date2 = sdf.parse(dateInString2);
		 if (date1.compareTo(date2) == 0) {
			System.out.println("Valor 0 : " + date1.compareTo(date2) );
		}else{
			System.out.println("Valor ? : " + date1.compareTo(date2) );
		}
		 
	}

}
