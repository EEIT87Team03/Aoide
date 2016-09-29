/**
 * 
 */
var offsetX = 0 , offsetY = 0 ;
var playlist = document.getElementById( "playlist" );
var playlistSpan = document.getElementById( "playlistMenu" );	
var closer = document.getElementById( "closer" );
playlistSpan.onclick = showPlaylist;
closer.onclick = playlistClose;
playlist.ondragstart = dragStartHandler;


function playlistClose() 
{
	playlist.style.display = "none";
};

function showPlaylist()
{
	
	playlist.style.display = "block";
}
function allowDrop( event ) 
{
    event.preventDefault();
    event.dataTransfer.dropEffect = "move";
}

function dragStartHandler( ev ) 
{
	ev.dataTransfer.dropEffect = "move";
	ev.dataTransfer.setData( "text/plain", ev.target.id );
	
//	var tempX = ev.pageX; 
//	var tempY = ev.pageY;
//	
//	var left = document.getElementById( ev.target.id ).style.left || 0;
//	var top = document.getElementById( ev.target.id ).style.top || 0; 
//	
//	if ( left !== 0 )
//	{
//		left = parseFloat( document.getElementById( ev.target.id ).style.left );
//	}
//	if ( top !== 0 )
//	{
//		top = parseFloat( document.getElementById( ev.target.id ).style.top );
//	}
//	
//	offsetX = tempX - left; 
//	offsetY = tempY - top;
//	alert( offsetX + "  " + offsetY );
}

function onDrop( e )
{
	e.preventDefault();
	var tempX = e.pageX; 
	var tempY = e.pageY;
	
	var data = e.dataTransfer.getData( "text" );
	document.getElementById( data ).style.top = tempY - 20 + "px";
	document.getElementById( data ).style.left = tempX - 20 + "px";
}
