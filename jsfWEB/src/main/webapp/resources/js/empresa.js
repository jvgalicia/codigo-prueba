function checBoxAsignacion() {
	var $el = $('#admiCheck');

	var chechAdmin = document.getElementById("formularioEmpresa:empAdmin");
	var chechComer = document.getElementById("formularioEmpresa:empComer");

	if ($el.is(':checked')) {
		chechAdmin.style.visibility = 'visible';
		chechComer.style.visibility = 'hidden';
		chechAdmin.value = "";
	} else {
		chechComer.style.visibility = 'visible';
		chechAdmin.style.visibility = 'visible';
		chechAdmin.disabled = true;
	}

}

