	function eliminar()
	{
		// Eliminamos toda la base de datos del navegador
		localStorage.clear();
		sessionStorage.clear();
 
	}
	function nobackbutton(){
		   window.location.hash="no-forward-button";
		   window.location.hash="Again-No-forward-button" //chrome
		   window.onhashchange=function(){window.location.hash="no-forward-button";}	
		}