/**
 * 
 */
var missileLauncher = document.getElementById( "missileLauncher" );
var fireBtn = document.getElementById("fire");
var launcherSpan = document.getElementById( "launcher" );
var destructor = document.getElementById( "destructor" );
	
launcherSpan.onclick = 
	function() 
	{
		missileLauncher.style.display = "block";
	};
	
destructor.onclick = 
	function() 
	{
		missileLauncher.style.display = "none";
	};