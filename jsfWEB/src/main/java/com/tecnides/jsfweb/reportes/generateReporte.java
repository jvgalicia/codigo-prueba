package com.tecnides.jsfweb.reportes;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.AdministradoraDTO;
import com.tecnides.dominio.EmpresaDTO;
import com.tecnides.dominio.ReporteListaNegra;
import com.tecnides.dominio.ReporteVenta;
import com.tecnides.dominio.ReporteTransacciones;
import com.tecnides.dominio.ResponseDTO;
import com.tecnides.jsfweb.servicio.ServicioAdministradoraImpl;
import com.tecnides.jsfweb.utilidades.Constantes;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class generateReporte {
	private static final Logger log = LoggerFactory.getLogger(generateReporte.class);
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void ReporteEmpresa(ResponseDTO objeto) throws JRException {

		ReportesDatasource datasource = new ReportesDatasource();

		List<AdministradoraDTO> valoresRest = (List<AdministradoraDTO>)objeto.getObjDTO();
		AdministradoraDTO parametros = null;
		for (AdministradoraDTO nativos : valoresRest) {
			parametros = new AdministradoraDTO();
			parametros.setAdmNombre(nativos.getAdmNombre());
			parametros.setAdmCreditototal(nativos.getAdmCreditototal());
			parametros.setAdmRfc(nativos.getAdmRfc());
			parametros.setAdmRazonsocial(nativos.getAdmRazonsocial());
			List<EmpresaDTO> valoresRestEmpresas = nativos.getEmpresaDTO();
			log.info("Tamaño " + valoresRestEmpresas.size());
			if (valoresRestEmpresas.size() >= 0 || valoresRestEmpresas != null ) {

				for (EmpresaDTO nativosEmpresa : valoresRestEmpresas) {
					datasource.addParticipante(nativosEmpresa);
				}
			}

		}
		
		Map parameters = new HashMap();
	    parameters.put("adminNombre", parametros.getAdmNombre());
	    
		String Url = Constantes.urlPhant();
		Url += File.separator + "reportes" + File.separator + "Administradoras.jasper";
		JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, datasource);

		@SuppressWarnings({ "rawtypes" })
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
				new java.io.File("C:\\Users\\ocvillegas\\Desktop\\jasper\\reporte2PDF.pdf"));
		exporter.exportReport();

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static JasperPrint ReporteVentas(List<ReporteVenta> lista) throws JRException {

		JasperPrint jasperPrint = new JasperPrint();
		DatasourceVentas datasource = new DatasourceVentas();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteVenta nativosEmpresa : lista) {
					datasource.addReporteVentas(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteVentas.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				 jasperPrint = JasperFillManager.fillReport(reporte, parameters, datasource);
			}
			return jasperPrint;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static byte[] ReporteVentasView(List<ReporteVenta> lista) throws JRException {

		byte[] jasperPrint = null;
		DatasourceVentas datasource = new DatasourceVentas();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteVenta nativosEmpresa : lista) {
					datasource.addReporteVentas(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteVentas.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				
				 jasperPrint = JasperRunManager.runReportToPdf(reporte, parameters, datasource);
			}
			return jasperPrint;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static JasperPrint ReporteTransacciones(List<ReporteTransacciones> lista) throws JRException {

		JasperPrint jasperPrint = new JasperPrint();
		DatasourceTransaccion datasource = new DatasourceTransaccion();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteTransacciones nativosEmpresa : lista) {
					datasource.addReporteTransaccion(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteTransacciones.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				 jasperPrint = JasperFillManager.fillReport(reporte, parameters, datasource);
			}
			return jasperPrint;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static byte[] ReporteTransaccionesView(List<ReporteTransacciones> lista) throws JRException {

		byte[] jasperPrint = null;
		DatasourceTransaccion datasource = new DatasourceTransaccion();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteTransacciones nativosEmpresa : lista) {
					datasource.addReporteTransaccion(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteTransacciones.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				
				 jasperPrint = JasperRunManager.runReportToPdf(reporte, parameters, datasource);
			}
			return jasperPrint;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static JasperPrint ReporteBlackList(List<ReporteListaNegra> lista) throws JRException {

		JasperPrint jasperPrint = new JasperPrint();
		DatasourceBlackList datasource = new DatasourceBlackList();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteListaNegra nativosEmpresa : lista) {
					datasource.addReporteTransaccion(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteBlackList.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				return jasperPrint = JasperFillManager.fillReport(reporte, parameters, datasource);
			}
			return null;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static byte[] ReporteBlackListView(List<ReporteListaNegra> lista) throws JRException {

		byte[] jasperPrint = null;
		DatasourceBlackList datasource = new DatasourceBlackList();
			if (lista.size() >= 0 || lista != null ) {

				for (ReporteListaNegra nativosEmpresa : lista) {
					datasource.addReporteTransaccion(nativosEmpresa);;
				}
				Map parameters = new HashMap();
			    parameters.put("filtro", "sin Filtros");
			    
				String Url = Constantes.urlPhant();
				Url += File.separator + "reportes" + File.separator + "ReporteBlackList.jasper";
				JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(Url);
				
				 jasperPrint = JasperRunManager.runReportToPdf(reporte, parameters, datasource);
			}
			return jasperPrint;
	}
}
