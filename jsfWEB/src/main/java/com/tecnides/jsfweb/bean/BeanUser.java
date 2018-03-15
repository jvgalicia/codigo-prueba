/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnides.jsfweb.bean;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.dominio.UsuarioDTO;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;
import com.tecnides.jsfweb.servicio.InterfaceUsuario;
import com.tecnides.jsfweb.utilidades.Constantes;
import com.tecnides.jsfweb.utilidades.SessionUtils;
import com.tecnides.jsfweb.utilidades.Utilidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ocvillegas
 */
@ManagedBean
public class BeanUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(BeanUser.class);
	private ResponseDTO resposeDTO;
	private UsuarioDTO usuarios;
	private List<UsuarioDTO> listaUsuarios;
	@ManagedProperty("#{servicioUsuarioInj}")
	private InterfaceUsuario servicioUser;
	private  String nombreUser;
	private  String apellidoUSer;
	private  String tipoUser; 
	private boolean checboxlogin;
	private Date currentDate;
	private String minumero;
	private String alerta;
	private Map<Integer,String> CatEmpresa = new HashMap<Integer,String>();
	private Map<Integer,String> CatTipoUsuario = new HashMap<Integer,String>();
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;
	/*public Date getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		currentDate = getCurrentDate();
	    return currentDate;
	}*/
	
	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public String getMinumero() {
		return minumero;
	}

	public void setMinumero(String minumero) {
		this.minumero = minumero;
	}
	 public void handleKeyEvent() {
		 
		 System.out.println("hola noe primer paso");
		 String numero = getMinumero().toString();
		System.out.println("hola noe");
		 if (validar(numero)) {
			log.info("es numero ok");
			System.out.println("bien"+numero);
		}else{
			log.info("no es numero");
			System.out.println("mal"+numero);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Ingrese solo Números"));		}		
		 		 
	    }
	

	public boolean validar(String numero){
		 try {
			 log.info("Convertir numero");
			 Double.parseDouble(numero);
			 return true;
		} catch (Exception e) {
			log.error("Numero", e);
			return false;
		}
		 
	 }
    //de aqui pa arriba;
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ResponseDTO getResposeDTO() {
		return resposeDTO;
	}

	public void setResposeDTO(ResponseDTO resposeDTO) {
		this.resposeDTO = resposeDTO;
	}

	public UsuarioDTO getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuarioDTO usuarios) {
		this.usuarios = usuarios;
	}

	public InterfaceUsuario getServicioUser() {
		return servicioUser;
	}

	public void setServicioUser(InterfaceUsuario servicioUser) {
		this.servicioUser = servicioUser;
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public String getApellidoUSer() {
		return apellidoUSer;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public void setApellidoUSer(String apellidoUSer) {
		this.apellidoUSer = apellidoUSer;
	}

	public Map<Integer, String> getCatEmpresa() {
		return CatEmpresa;
	}

	public void setCatEmpresa(Map<Integer, String> catEmpresa) {
		CatEmpresa = catEmpresa;
	}

	public InterfaceCatalogos getServicioCatalogos() {
		return servicioCatalogos;
	}

	public void setServicioCatalogos(InterfaceCatalogos servicioCatalogos) {
		this.servicioCatalogos = servicioCatalogos;
	}

	public Map<Integer, String> getCatTipoUsuario() {
		return CatTipoUsuario;
	}

	public void setCatTipoUsuario(Map<Integer, String> catTipoUsuario) {
		CatTipoUsuario = catTipoUsuario;
	}

	public String validarUsuario() {
		try {
			usuarios.setPassword(Utilidades.aesPwdEncrypt(Constantes.keyAES,Constantes.ivAES, usuarios.getPassword()));
			resposeDTO = getServicioUser().validarUsuario(usuarios);
			if (resposeDTO.getResult()) {		
				List<UsuarioDTO> valoresRest = (List<UsuarioDTO>) resposeDTO.getObjDTO();
				HttpSession session = SessionUtils.getSession();
				UsuarioDTO nativos = null;
				for(UsuarioDTO valores : valoresRest){
					nativos = new UsuarioDTO();
					nativos.setUsuario(valores.getUsuario());
					nativos.setNombre(valores.getNombre());
					nativos.setApellidomaterno(valores.getApellidomaterno());
					nativos.setApellidopaterno(valores.getApellidopaterno());
					nativos.setTipoUsuarioString(valores.getTipoUsuarioString());
				}
				usuarios = nativos;
				session.setAttribute("username", nativos.getUsuario());
				session.setAttribute("nombre", nativos.getNombre());
				session.setAttribute("apellido", nativos.getApellidopaterno());
				session.setAttribute("tipoUser", nativos.getTipoUsuarioString());
				setNombreUser(SessionUtils.getNombre());
				setApellidoUSer(SessionUtils.getApellido());
				log.info("VAlor Session ****** " + nativos.getTipoUsuarioString());
				return "admin";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Ingrese las credenciasles correctas", "Usuario o contraseña incorrecta"));
				return "capp";
			}

		} catch (Exception e) {
			log.error("Error de msg BeanUser= " + e);
			return "capp";
		}

	}

	public String editar() throws Exception {
		/*++++++++++++++++++++++++++++++*/
		usuarios.setPassword(Utilidades.aesPwdEncrypt(Constantes.keyAES,Constantes.ivAES, usuarios.getPassword()));

		resposeDTO = getServicioUser().crearUsuario(usuarios);		
		//System.out.println(" msn ************* " + resposeDTO.getMsg());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", resposeDTO.getMsg()));
		/*++++++++++++++++++++++++++++++*/
		
		log.info("entra el metodo " );
		
		return "";
	}

	public String eliminar() {
		usuarios.setStatus("Inactivo");
		resposeDTO = getServicioUser().crearUsuario(usuarios);
		return "";
	}

	public String agregar() throws Exception {
		usuarios.setIdUsuario(0);
		usuarios.setPassword(Utilidades.aesPwdEncrypt(Constantes.keyAES,Constantes.ivAES, usuarios.getPassword()));
		resposeDTO = getServicioUser().crearUsuario(usuarios);
		return "";
	}
	
	public String paginaAgregar(){
		catEmpresa();
		catTipoUsuario();
		return SessionUtils.getTipoUsuario();
	}
	public String paginaEditar(UsuarioDTO obj){
		setUsuarios(obj);
		catEmpresa();
		catTipoUsuario();
		return SessionUtils.getTipoUsuario();
	}
	
	public String listaUsuario(){
				
		setListaUsuarios(getServicioUser().consultaUsuarios());
		
		return SessionUtils.getTipoUsuario();
	}

	public boolean isChecboxlogin() {
		
		checkboxmessage();
		return checboxlogin;
	}

	public void setChecboxlogin(boolean checboxlogin) {
		this.checboxlogin = checboxlogin;
	}

    public void checkboxmessage() {
        String chkmess = checboxlogin ? "yes" : "no";
      
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(chkmess));
    }
    @PostConstruct
    public void newDate(){
    	
    	Date fecha = new Date();
    	setCurrentDate(fecha);
    	
    }
    public void catEmpresa() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getCatEmpresas();
		CatEmpresa  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 CatEmpresa.put((int) valor.getId(),valor.getValor());
		}
         setCatEmpresa(CatEmpresa);
         
		} catch (Exception e) {
			log.error("Tipo de error Empresas", e);
		}
    }
    public void catTipoUsuario() {
		try {     
		List<CatalogoIdValor> idValor = getServicioCatalogos().getTipoUsuario();
		CatTipoUsuario  = new HashMap<Integer,String>();
         for (CatalogoIdValor valor: idValor ) {        	
        	 CatTipoUsuario.put((int) valor.getId(),valor.getValor());
		}
         setCatTipoUsuario(CatTipoUsuario);
         
		} catch (Exception e) {
			log.error("Tipo de error Empresas", e);
		}
    }
}
