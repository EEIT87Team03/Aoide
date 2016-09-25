/**
 * 
 */
var missileLauncher = document.getElementById( "missileLauncher" );
var fireBtn = document.getElementById("fire");
var destructorSpan = document.getElementById( "destructor" );
var launcherSpan = document.getElementById( "launcher" );

destructorSpan.onclick = 
	function() 
	{
		missileLauncher.style.display = "none";
	};
	
launcherSpan.onclick = 
	function() 
	{
		missileLauncher.style.display = "block";
	};