function vaciarCamposNewco() {

	var nombreNewco = document.getElementById("formularioAltaNewco:nombreNewco");
	var newRaSocial = document.getElementById("formularioAltaNewco:newRaSocial");
	var newRfc = document.getElementById("formularioAltaNewco:newRfc");
	var newAdmin = document.getElementById("formularioAltaNewco:newAdmin");

	nombreNewco.value = "";
	newRaSocial.value = "";
	newRfc.value = "";
}

function asignarAdmin(){
	
	var nombreNewco = document.getElementById("asigAminNewco");
	var espacio = document.getElementById("formularioAltaNewco:fieldadmin");
	espacio.style.height = '700px';
	nombreNewco.style.visibility = 'visible'; 
	nombreNewco.style.height = '200px';
	console.log("vicible");
}