package com.tecnides.jsfweb.reportes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnides.dominio.ReporteListaNegra;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DatasourceBlackList implements JRDataSource {
	private static final Logger log = LoggerFactory.getLogger(DatasourceBlackList.class);
	private List<ReporteListaNegra> reporte = new ArrayList<ReporteListaNegra>();
	private int indiceParticipanteActual = -1;
	
	@SuppressWarnings("deprecation")
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;
		String signo = "$";
		
		if ("nomEmpleado".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getNomEmpleado();
		} else if ("identificador".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getEmplIdentificacion();
		} else if ("administradora".equals(arg0.getName())) {
			valor = reporte.get(indiceParticipanteActual).getAdminNombre();
		} else if ("fecha".equals(arg0.getName())) {
			Date format = reporte.get(indiceParticipanteActual).getFechaBaja();
			String newstring = new SimpleDateFormat("dd-MM-yyyy").format(format);
			valor = newstring;
		}else if ("monto".equals(arg0.getName())) {
			BigDecimal monto =  reporte.get(indiceParticipanteActual).getDeuda();			
			valor = signo + monto;
		}


		return valor;
	}

	@Override
	public boolean next() throws JRException {
		return ++indiceParticipanteActual < reporte.size();
	}
	
	public void addReporteTransaccion(ReporteListaNegra repoTrans) {
		this.reporte.add(repoTrans);
	}
}
