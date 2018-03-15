package com.tecnides.jsfweb.reportes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.ReporteVenta;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DatasourceVentas implements JRDataSource {
	
	private static final Logger log = LoggerFactory.getLogger(DatasourceVentas.class);
	private List<ReporteVenta> reporte = new ArrayList<ReporteVenta>();
	private int indiceParticipanteActual = -1;
	
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;
		String signo = "$";
		
		if ("empleado".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getEmplNombre();
		} else if ("identificador".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getEmplIdentificacion();
		} else if ("administradora".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getAdmNombre();
		} else if ("empresa".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getEmpresaNombre();
		}else if ("sucursal".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getSucursalNombre();
		}
		else if ("monTrasaccion".equals(arg0.getName())) {	
			BigDecimal monoTransaccion = reporte.get(indiceParticipanteActual).getMontoTrasaccion();
			valor = (monoTransaccion != null )?signo+monoTransaccion.toString():" ";
		}else if ("monMonedero".equals(arg0.getName())) {
			BigDecimal monoMonedero = reporte.get(indiceParticipanteActual).getMontoMonedero();
			valor = (monoMonedero != null )?signo+monoMonedero.toString():" ";
		}else if ("monTotal".equals(arg0.getName())) {
			BigDecimal monoTotal = reporte.get(indiceParticipanteActual).getTotal();
			valor = (monoTotal != null )?signo+monoTotal.toString():" ";
			
		}

		return valor;
	}

	@Override
	public boolean next() throws JRException {
		return ++indiceParticipanteActual < reporte.size();
	}
	
	public void addReporteVentas(ReporteVenta repoVentas) {
		this.reporte.add(repoVentas);
	}

}
