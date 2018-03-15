package com.tecnides.jsfweb.reportes;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.ReporteTransacciones;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DatasourceTransaccion implements JRDataSource {
	private static final Logger log = LoggerFactory.getLogger(DatasourceTransaccion.class);
	private List<ReporteTransacciones> reporte = new ArrayList<ReporteTransacciones>();
	private int indiceParticipanteActual = -1;
	
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;
		String signo = "$";
		
		if ("administradora".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getAdmNombre();
		} else if ("empresa".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getEmpresaNombre();
		} else if ("sucursal".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getSucursalNombre();
		} else if ("transacciones".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getNumeroTransaccione();
		}else if ("monedero".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getNumMonederoEmitido();
		}
		else if ("fallidas".equals(arg0.getName())) {	
			valor = reporte.get(indiceParticipanteActual).getNumeroFallidas();
		}else if ("tiket".equals(arg0.getName())) {	
			valor = reporte.get(indiceParticipanteActual).getTiketPromedio();
		}


		return valor;
	}

	@Override
	public boolean next() throws JRException {
		return ++indiceParticipanteActual < reporte.size();
	}
	
	public void addReporteTransaccion(ReporteTransacciones repoTrans) {
		this.reporte.add(repoTrans);
	}

}
