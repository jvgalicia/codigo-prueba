package com.tecnides.jsfweb.servicio;

import java.util.List;

import com.tecnides.catalogos.CatalogoIdValor;

public interface InterfaceCatalogos {

	public List<CatalogoIdValor> getTipoUsuario();

	public List<CatalogoIdValor> getCatEmpresas();

	public List<CatalogoIdValor> getCatPeriodicidad();

	public List<CatalogoIdValor> getCatAdministradora();

	public List<CatalogoIdValor> getComercializadora();

	public List<CatalogoIdValor> getAdminByComer(long idcomer);
	
	public List<CatalogoIdValor> getComerByAdmin(long idAdmin);
	
	public List<CatalogoIdValor> getEmpresaByComer(long idComer);

}
