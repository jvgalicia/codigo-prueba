function vaciarCamposAdministradoras() {

	var nombreEmpresa = document
			.getElementById("formularioAltaAdmin:nombreEmpresa");
	var rasonSocial = document
			.getElementById("formularioAltaAdmin:admRaSocial");
	var rfc = document.getElementById("formularioAltaAdmin:admRfc");
	var creTotal = document.getElementById("formularioAltaAdmin:credtitoTotal");
	var identificador = document
			.getElementById("formularioAltaAdmin:identificador");
	var deudaDIa = document.getElementById("formularioAltaAdmin:deudaDIA");
	var numEmpresas = document
			.getElementById("formularioAltaAdmin:numeroEmpresa");

	nombreEmpresa.value = "";
	rasonSocial.value = "";
	rfc.value = "";
	creTotal.value = "";
	identificador.value = "";
	deudaDIa.value = "";
	numEmpresas.value = "";
}
function vaciarCamposUsuarios() {

	var nombreUsuario = document.getElementById("formularioEmpleado:usuNombre");
	var Apellidopaterno = document
			.getElementById("formularioEmpleado:socPaterno");
	var Apellidomaterno = document
			.getElementById("formularioEmpleado:socMaterno");
	var Usuario = document.getElementById("formularioEmpleado:usuUsuario");
	var Contrasena = document.getElementById("formularioEmpleado:txtPassword");
	var Telefono = document.getElementById("formularioEmpleado:usuTelefono");

	nombreUsuario.value = "";
	Apellidopaterno.value = "";
	Apellidomaterno.value = "";
	Usuario.value = "";
	Contrasena.value = "";
	Telefono.value = "";

}
function vaciarCamposEmpresas() {

	var nombreEmpresa = document.getElementById("formularioEmpresa:empNombre");
	var razonsocial = document.getElementById("formularioEmpresa:empRaSocial");
	var rfc = document.getElementById("formularioEmpresa:empRfc");
	var administradora = document.getElementById("formularioEmpresa:empAdmin");
	var identificador = document
			.getElementById("formularioEmpresa:empIdentificador");
	var giro = document.getElementById("formularioEmpresa:empGiro");
	var periodicidad = document
			.getElementById("formularioEmpresa:periodicidad");
	var numEmpleado = document
			.getElementById("formularioEmpresa:empNumeroEmpl");
	
	
	nombreEmpresa.value = "";
	razonsocial.value = "";
	rfc.value = "";
	administradora.value = "";
	identificador.value = "";
	giro.value = "";
	periodicidad = "";
	numEmpleado = "";

}


function agregarComer(){
	
	var nombreNewco = document.getElementById("comercializadoraDiv");
	nombreNewco.style.visibility = 'visible'; 
}


function vaciarCamposNewco() {

	var nombreNewco = document.getElementById("formularioAltaNewco:nombreNewco");
	var newRaSocial = document.getElementById("formularioAltaNewco:newRaSocial");
	var newRfc = document.getElementById("formularioAltaNewco:newRfc");
	var newAdmin = document.getElementById("formularioAltaNewco:newAdmin");

	nombreNewco.value = "";
	newRaSocial.value = "";
	newRfc.value = "";
}
function vaciarCamposComer() {

	var nombreComer = document.getElementById("formAltaComer:nombreComer");
	var comRaSocial = document.getElementById("formAltaComer:comerRaSocial");
	var comRfc = document.getElementById("formAltaComer:comRfc");
	var comIdenti = document.getElementById("formAltaComer:indentificadorComer");
	var comAgiro = document.getElementById("formAltaComer:comerGiro");
	
	nombreComer.value = "";
	comRaSocial.value = "";
	comRfc.value = "";
	comIdenti.value = "";
	comAgiro.value = "";
}

function asignarAdmin(){
	
	var nombreNewco = document.getElementById("asigAminNewco");
	var espacio = document.getElementById("formularioAltaNewco:fieldadmin");
	espacio.style.height = '700px';
	nombreNewco.style.visibility = 'visible'; 
	nombreNewco.style.height = '200px';
	console.log("vicible");
}
