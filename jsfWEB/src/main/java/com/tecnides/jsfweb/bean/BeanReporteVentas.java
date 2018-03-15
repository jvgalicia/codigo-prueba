package com.tecnides.jsfweb.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.catalogos.CatalogoIdValor;
import com.tecnides.dominio.ParemetrosDto;
import com.tecnides.dominio.ReporteListaNegra;
import com.tecnides.dominio.ReporteTransacciones;
import com.tecnides.dominio.ReporteVenta;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.reportes.generateReporte;
import com.tecnides.jsfweb.servicio.InterfaceCatalogos;
import com.tecnides.jsfweb.servicio.InterfaceReporte;
import com.tecnides.jsfweb.utilidades.SessionUtils;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
public class BeanReporteVentas {
	private String session = SessionUtils.getTipoUsuario();
	private static final Logger log = LoggerFactory.getLogger(BeanReporteVentas.class);
	private Map<Integer, String> administradora = new HashMap<Integer, String>();
	private Map<Integer, String> comerbyAdmin = new HashMap<Integer, String>();
	private Map<Integer, String> empresaByComer = new HashMap<Integer, String>();
	private List<ReporteVenta> listaReporteDto;
	private List<ReporteTransacciones> listaTransaccionesDTO;
	private List<ReporteListaNegra> listaNegraDTO;
	@ManagedProperty("#{interfaceReporte}")
	private InterfaceReporte servicioReporte;
	@ManagedProperty("#{interfaceCatalogos}")
	private InterfaceCatalogos servicioCatalogos;
	private ParemetrosDto parametros;

	public List<ReporteVenta> getListaReporteDto() {
		return listaReporteDto;
	}

	public void setListaReporteDto(List<ReporteVenta> listaReporteDto) {
		this.listaReporteDto = listaReporteDto;
	}

	public InterfaceReporte getServicioReporte() {
		return servicioReporte;
	}

	public void setServicioReporte(InterfaceReporte servicioReporte) {
		this.servicioReporte = servicioReporte;
	}

	public InterfaceCatalogos getServicioCatalogos() {
		return servicioCatalogos;
	}

	public void setServicioCatalogos(InterfaceCatalogos servicioCatalogos) {
		this.servicioCatalogos = servicioCatalogos;
	}

	public ParemetrosDto getParametros() {
		return parametros;
	}

	public void setParametros(ParemetrosDto parametros) {
		this.parametros = parametros;
	}
	
	public Map<Integer, String> getAdministradora() {
		return administradora;
	}

	public void setAdministradora(Map<Integer, String> administradora) {
		this.administradora = administradora;
	}

	public Map<Integer, String> getComerbyAdmin() {
		return comerbyAdmin;
	}

	public void setComerbyAdmin(Map<Integer, String> comerbyAdmin) {
		this.comerbyAdmin = comerbyAdmin;
	}

	public Map<Integer, String> getEmpresaByComer() {
		return empresaByComer;
	}

	public void setEmpresaByComer(Map<Integer, String> empresaByComer) {
		this.empresaByComer = empresaByComer;
	}

	public List<ReporteTransacciones> getListaTransaccionesDTO() {
		return listaTransaccionesDTO;
	}

	public void setListaTransaccionesDTO(List<ReporteTransacciones> listaTransaccionesDTO) {
		this.listaTransaccionesDTO = listaTransaccionesDTO;
	}

	public List<ReporteListaNegra> getListaNegraDTO() {
		return listaNegraDTO;
	}

	public void setListaNegraDTO(List<ReporteListaNegra> listaNegraDTO) {
		this.listaNegraDTO = listaNegraDTO;
	}

	public String listaReporteVentas() {
		parametros = new ParemetrosDto();
		ResponseDTO valRepo = new ResponseDTO();
		valRepo =  getServicioReporte().reporteVentas("null", "null", getParametros().getIdAdministradora(),
				getParametros().getIdComercializadora(), getParametros().getIdEmpresa(),
				String.valueOf(getParametros().getMonto1()), String.valueOf(getParametros().getMonto2()));
		
		
		setListaReporteDto(valRepo.getObjDTO());
		
		return session;
	}
	
	public String listaReporteTransacciones() {
		parametros = new ParemetrosDto();
		ResponseDTO valRepo = new ResponseDTO();
		valRepo =  getServicioReporte().reporteTransaccion("null", "null", getParametros().getIdAdministradora(),
				getParametros().getIdComercializadora(), getParametros().getIdEmpresa(),
				String.valueOf(getParametros().getMonto1()), String.valueOf(getParametros().getMonto2()));
		
		
		setListaTransaccionesDTO(valRepo.getObjDTO());
		
		return session;
	}
	
	public String listaReporteListaNegra() {
		parametros = new ParemetrosDto();
		ResponseDTO valRepo = new ResponseDTO();
		valRepo =  getServicioReporte().reporteListaNegra("null", "null", getParametros().getIdAdministradora(),
				String.valueOf(getParametros().getMonto1()), String.valueOf(getParametros().getMonto2()));
		
		
		setListaNegraDTO(valRepo.getObjDTO());
		
		return session;
	}
	public void reporteVentasUpdate() {
		
		ResponseDTO valRepo = new ResponseDTO();
			valRepo =  getServicioReporte().reporteVentas("null", "null", getParametros().getIdAdministradora(),
					getParametros().getIdComercializadora(), getParametros().getIdEmpresa(),
					String.valueOf(getParametros().getMonto1()), String.valueOf(getParametros().getMonto2()));
			if (getParametros().getMonto2() == 0) {
				getParametros().setMonto1(0);
			}
			
			setListaReporteDto(valRepo.getObjDTO());
		
	}
public void reporteVentasTransaccionesUpdate() {
		
		ResponseDTO valRepo = new ResponseDTO();
	      log.info("Admministradora =  " + getParametros().getIdAdministradora()  );
	      log.info("comercializadora =  " + getParametros().getIdComercializadora()  );
	      log.info("empresa =  " + getParametros().getIdEmpresa() );
	      log.info("monto1 =  " + getParametros().getMonto1()  );
	      log.info("monto2 =  " + getParametros().getMonto2()  );
			valRepo =  getServicioReporte().reporteTransaccion("null", "null", getParametros().getIdAdministradora(),
					getParametros().getIdComercializadora(), getParametros().getIdEmpresa(),
					String.valueOf(getParametros().getMonto1()), String.valueOf(getParametros().getMonto2()));
			if (getParametros().getMonto2() == 0) {
				getParametros().setMonto1(0);
			}
			
			setListaTransaccionesDTO(valRepo.getObjDTO());
		
	   
	    
		
	}

	@PostConstruct
	public void inicializacion(){
		parametros = new ParemetrosDto();
		listaReporteDto = new ArrayList<ReporteVenta>();
		//listaTransaccionesDTO = new ArrayList<ReporteTransacciones>();
		catAdminsitradoras();
	}
	
	public void catAdminsitradoras() {
		try {
			List<CatalogoIdValor> idValor = getServicioCatalogos().getCatAdministradora();
			administradora = new HashMap<Integer, String>();
			for (CatalogoIdValor valor : idValor) {
				administradora.put((int) valor.getId(), valor.getValor());
			}
			setAdministradora(administradora);
			reporteVentasUpdate();
		} catch (Exception e) {
			log.error("Tipo de error catAdminsitradoras", e);
		}
	}
	
	public void catComerByAdmin(String val) {
		try {
			log.info("Val = " +  val );
			List<CatalogoIdValor> idValor = getServicioCatalogos().getComerByAdmin(getParametros().getIdAdministradora());
			comerbyAdmin = new HashMap<Integer, String>();
			for (CatalogoIdValor valor : idValor) {
				comerbyAdmin.put((int) valor.getId(), valor.getValor());
			}
			setComerbyAdmin(comerbyAdmin);
			switch (val) {
			case "ventas":
				reporteVentasUpdate();
				break;
			case "transaccion":
				reporteVentasTransaccionesUpdate();
				break;
			case "negra":
				log.info("valor negra combo");
				listaReporteListaNegra();
				break;
			}
			
		} catch (Exception e) {
			log.error("Tipo de error catComerByAdmin", e);
		}
	}
	public void catEmpresaByComer(String val) {
		try {
			
			List<CatalogoIdValor> idValor = getServicioCatalogos().getEmpresaByComer(getParametros().getIdComercializadora());
			empresaByComer = new HashMap<Integer, String>();
			for (CatalogoIdValor valor : idValor) {
				empresaByComer.put((int) valor.getId(), valor.getValor());
			}
			setEmpresaByComer(empresaByComer);
			switch (val) {
			case "ventas":
				reporteVentasUpdate();
				break;
			case "transaccion":
				reporteVentasTransaccionesUpdate();
				break;
			}
		} catch (Exception e) {
			log.error("Tipo de error catEmpresaByComer", e);
		}
	}
	
	public void exportReporte(){
		try {
			
			JasperPrint jasperPrint = generateReporte.ReporteVentas(getListaReporteDto());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=reporteVentas.pdf");
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
			
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			log.error("error en exportReporte",e);;
		}
	}
	public void viewReporte(){
		try {
			
			byte[] jasperPrint = generateReporte.ReporteVentasView(getListaReporteDto());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(jasperPrint.length);
			ServletOutputStream stream = response.getOutputStream();
			stream.write(jasperPrint, 0 , jasperPrint.length);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			log.error("error en viewReporte: ",e);
		}
	}
	public void exportReporteTransacciones(){
		try {
			
			JasperPrint jasperPrint = generateReporte.ReporteTransacciones(getListaTransaccionesDTO());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=reporteTransacciones.pdf");
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
			
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			log.error("error en exportReporteTransacciones",e);;
		}
	}
	public void viewReporteTransacciones(){
		try {
			
			byte[] jasperPrint = generateReporte.ReporteTransaccionesView(getListaTransaccionesDTO());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(jasperPrint.length);
			ServletOutputStream stream = response.getOutputStream();
			stream.write(jasperPrint, 0 , jasperPrint.length);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			log.error("error en viewReporteTransacciones: ",e);
		}
	}
	public void exportReporteBlackList(){
		try {
			
			JasperPrint jasperPrint = generateReporte.ReporteBlackList(getListaNegraDTO());
			if (jasperPrint != null) {
				HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.addHeader("Content-disposition","attachment; filename=reporteListaNegra.pdf");
				ServletOutputStream stream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
				
				stream.flush();
				stream.close();
				FacesContext.getCurrentInstance().responseComplete();
			}
			
		} catch (Exception e) {
			log.error("error en exportReporteBlackList",e);;
		}
	}
	public void viewReporteBlackList(){
		try {
			
			byte[] jasperPrint = generateReporte.ReporteBlackListView(getListaNegraDTO());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(jasperPrint.length);
			ServletOutputStream stream = response.getOutputStream();
			stream.write(jasperPrint, 0 , jasperPrint.length);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			log.error("error en viewReporteBlackList: ",e);
		}
	}
	
}
