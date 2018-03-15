/**
 * 
 * 
 */
function confirmar () {
	/*	var seguro=	confirm('Realmaente deseas cerrar cesión')
if (seguro == true) {
	location.href="administradoras/listaAdministradora.xhtml";
    
} else {
    
}++++++*/
	location.href="administradoras/listaAdministradora.xhtml";
}
function nombre(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Administradoras";
}
function nombrenewco(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "NEWCO";
}
function nombreempre(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Empresas";
}
function nombreuser(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Usuarios";
}
function nombrereportes(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Reportes";
}
function nombrecomentarios(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Comentarios";
}
function nombreConfi(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Configuración";
}
function nombreComer(){
	var titulo = document.getElementById("Titulo");
    titulo.innerHTML = "Comercializadora";
}
function seleccion(){
	
	var x = document.getElementById("formularioBienvenido:linkadmin");
	 x.style.background='rgb(50, 60, 60)';
  x.style.color='white';
  /* x.style.fontSize=11;
	x.setAttribute("style", "background-color: green");*/
}
function seleccionComer(){
	
	var x = document.getElementById("formularioBienvenido:linkcomer");
	 x.style.background='rgb(50, 60, 60)';
    x.style.color='white'; 
  /* x.style.fontSize=11;
	x.setAttribute("style", "background-color: green");*/
}
function color1(){
	
	var x = document.getElementById("formularioBienvenido:linkempre");
	 x.style.background='rgb(50, 60, 60)';
     x.style.color='white'; 
}
function color2(){
	
	var y = document.getElementById("formularioBienvenido:linkuser");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");	 
}
function colortransacciones(){
	
	var y = document.getElementById("formularioBienvenido:linktransacciones");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");	 
}
function colorventas(){
	
	var y = document.getElementById("formularioBienvenido:linkventas");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");	 
}
function colorcomentarios(){
	
	var y = document.getElementById("formularioBienvenido:linkcomentarios");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");	 
}
function color5(){
	
	var y = document.getElementById("formularioBienvenido:linkventas");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");	 
}
function color3(){
	
	var y = document.getElementById("reporte");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");    
}
function color4(){
	
	var y = document.getElementById("formularioBienvenido:linknewco");
	 y.setAttribute("style", "background-color: rgb(50, 60, 60);color: white;");    
}
function nobackbackbutton(){
	   window.location.hash="no-back-button";
	   window.location.hash="Again-No-back-button" 
	   //window.onhashchange=function(){window.location.hash="";}	
	}
function mostrarguardar (){
	var mostrar = document.getElementById("Exito");
	mostrar.setAttribute("style", "display: inherit");
}
function mensajes (){
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block'
}
function mostarradiobutton (){
    var qaui = document.getElementsByName('hijo');
    var dfe = document.getElementById ("formularioVentas:Fecha");
    console.log("la variable es:"+""+qaui);
    console.log("la otra es:"+dfe);
}
function detalles(){
	var esconde = document.getElementById("detallito");
	esconde.setAttribute("style", "visibility: visible");
}
function muestrafecha(){
	var aqui = document.getElementById("formularioVentas:fecha1");
	var aqui2 = document.getElementById("formularioVentas:fecha2");
	aqui.setAttribute("style","display: inline");
	aqui2.setAttribute("style","display: inline");
}
function muestrafecha2(){
	var aqui = document.getElementById("formularioTransacciones:fecha1");
	var aqui2 = document.getElementById("formularioTransacciones:fecha2");
	aqui.setAttribute("style","display: inline");
	aqui2.setAttribute("style","display: inline");
}