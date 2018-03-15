package com.tecnides.jsfweb.reportes;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tecnides.dominio.AdministradoraDTO;
import com.tecnides.dominio.EmpresaDTO;

public class ReportesDatasource implements JRDataSource {

	private List<EmpresaDTO> listaEmpresas = new ArrayList<EmpresaDTO>();
	private int indiceParticipanteActual = -1;

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		Object valor = null;

		if ("empresa".equals(arg0.getName())) {
			valor = (listaEmpresas.get(indiceParticipanteActual).getNombre() != null  )?listaEmpresas.get(indiceParticipanteActual).getNombre():" ";
		} else if ("RazonSocial".equals(arg0.getName())) {
			
			valor = (listaEmpresas.get(indiceParticipanteActual).getRazonsocial() != null  )?listaEmpresas.get(indiceParticipanteActual).getRazonsocial():" ";
		} else if ("RFC".equals(arg0.getName())) {
			
			valor = (listaEmpresas.get(indiceParticipanteActual).getRfc() != null )?listaEmpresas.get(indiceParticipanteActual).getRfc():" ";
			
		} else if ("giro".equals(arg0.getName())) {
			
			valor = (listaEmpresas.get(indiceParticipanteActual).getGiro() != null)?listaEmpresas.get(indiceParticipanteActual).getGiro():" ";
		
		}else if ("nuEmpleados".equals(arg0.getName())) {	
			BigDecimal numEmpleado = listaEmpresas.get(indiceParticipanteActual).getNumeroempleado();
			
			valor = (numEmpleado != null )?numEmpleado.intValue():" ";
			
		}else if ("periocidad".equals(arg0.getName())) {
			String periodiCidad =  listaEmpresas.get(indiceParticipanteActual).getPeriodicidadpago().toString();
			valor = (periodiCidad != null )?periodiCidad:" ";
		}

		return valor;
	}

	@Override
	public boolean next() throws JRException {

		return ++indiceParticipanteActual < listaEmpresas.size();

	}

	public void addParticipante(EmpresaDTO administradoras) {
		this.listaEmpresas.add(administradoras);
	}

}
