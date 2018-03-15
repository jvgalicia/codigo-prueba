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