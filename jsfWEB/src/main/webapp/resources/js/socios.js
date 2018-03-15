function agregar(){
	document.cookie = "username=John Doe";
	var lasCookies = document.cookie;
	console.log("Valor de cookie = " + lasCookies );
}


function vaciarCampos() {

	var socNombre = document.getElementById("formularioEmpleado:socNombre");
	var socPaterno = document.getElementById("formularioEmpleado:socPaterno");
	var socMaterno = document.getElementById("formularioEmpleado:socMaterno");
	var socEmail = document.getElementById("formularioEmpleado:socEmail");
	var socNumero = document.getElementById("formularioEmpleado:socNumero");

	socNombre.value = "";
	socPaterno.value = "";
	socMaterno.value = "";
	socEmail.value = "";
	socNumero.value = "";
}


function validarContrasenia (){
	
	var pass = document.getElementById("bodySocio:socContra");
	var passCorfim = document.getElementById("bodySocio:socContraVAlida");
	
	if (pass.value == passCorfim.value ) {
		console.log("Contraseñas iguales");
	}else{
		console.log("Constraseña Inconrrecta");
	}
	
}

function tamanioPas(){
	
	var pass = document.getElementById("bodySocio:socContra").value;
	tamanioPass = pass.length;
	
	if (tamanioPass < 10) {
		console.log("Contraseña corta ****");
		
	document.querySelector('.mensajeError').innerHTML = "Contrasenia Corta ";
		    
	}else{
		console.log("Contraseña correta");
	}
	
}


