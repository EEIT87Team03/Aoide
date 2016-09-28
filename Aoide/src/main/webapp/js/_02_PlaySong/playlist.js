/**
 * 
 */

var playlist = document.getElementById( "playlist" );
var playlistSpan = document.getElementById( "playlistMenu" );	
var closer = document.getElementById( "closer" );
playlistSpan.onclick = showPlaylist;
closer.onclick = playlistClose;
//playlist.


function playlistClose() 
{
	playlist.style.display = "none";
};

function showPlaylist()
{
	
	playlist.style.display = "block";
}

function dragStartHandler(ev) 
{
	// Set the drag effect to copy
	ev.dataTransfer.dropEffect = "move";
}
