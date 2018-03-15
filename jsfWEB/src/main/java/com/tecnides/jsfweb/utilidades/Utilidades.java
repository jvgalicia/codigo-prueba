/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnides.jsfweb.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author ocvillegas
 */
public class Utilidades {
	// Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
	private final static String alg = "AES";
	// Definición del modo de cifrado a utilizar
	private final static String cI = "AES/CBC/PKCS5Padding";

	private static final Logger log = LoggerFactory.getLogger(Utilidades.class);

	public static Object getEJBRemote(String nameEJB, String iface) throws Exception {

		Context context;
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		props.put(Context.PROVIDER_URL, "http://localhost:7001");
		try {
			context = new InitialContext(props);
			String lookup = nameEJB + "#" + iface;
			return context.lookup(lookup);
		} catch (Exception e) {
			throw new Exception("No se econtro el EJB  : " + nameEJB);
		}

	}

	public static String ConexionRest() {

		String urlResult = null;
		String urlDefault = "http://localhost:7001/pro_mult_web_back/rest";

		try {
			Properties prop = new Properties();
			URL pathResource = Utilidades.class.getResource("/");
			String stringResource = pathResource.getPath();
			stringResource = stringResource.replace("/", File.separator);
			stringResource += "META-INF" + File.separator + "spring" + File.separator + "variables.properties";

			FileInputStream file = new FileInputStream(stringResource);
			prop.load(file);
			if (prop.getProperty("VAR.HTTPCLIENT.URL.REST") == null
					|| prop.getProperty("VAR.HTTPCLIENT.URL.REST").trim().length() == 0) {

				log.info("Url Local " + urlDefault);
				urlResult = urlDefault;

			} else {

				urlResult = prop.getProperty("VAR.HTTPCLIENT.URL.REST");
			}
			
		} catch (IOException e) {

			log.error("Ocurrio un error al cargar la URL para los servicios REST, se tomará valor por default "
					+ urlDefault, e);
			urlResult = urlDefault;
		}
		return urlResult;

	}

	public static String aesPwdEncrypt(String key, String iv, String cleartext) throws Exception {
		Cipher cipher = Cipher.getInstance(cI);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(cleartext.getBytes());
		return new String(encodeBase64(encrypted));
	}

	public static String aesPwdDecrypt(String key, String iv, String encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance(cI);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		byte[] enc = decodeBase64(encrypted);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
		byte[] decrypted = cipher.doFinal(enc);
		return new String(decrypted);
	}

}
