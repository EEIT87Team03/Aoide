/**
 * 
 */
var asUri = "ws://localhost:8080/Aoide/play";
var cover = document.getElementById( "cover" );
var audio = document.getElementById( "track" );
var trackName = document.getElementById( "trackName" );
var singer = document.getElementById( "singer" );
var tip = document.getElementById( "tip" ); //need another name
var playbar = document.getElementById( "playbar" );
var toggle =  document.getElementById( "toggle" );
var chart = document.getElementById( "chart" );
var timerID;
var audioSocket;
var audioContext;
var audioSource
var analyser;
var dataArray;

if( window.addEventListener )
{
	window.addEventListener( "load", initial )
}
else
{
	window.attachEvent( "onload", initial )
}

function initial()
{
	for ( var i = 0; i < 256; i++ )
	{
		var divChild = document.createElement( "div" );
		chart.appendChild( divChild );
	}
	
	window.AudioContext = window.AudioContext || window.webkitAudioContext;
	audioContext = new AudioContext();
	audioSource = audioContext.createMediaElementSource( audio );
	analyser = audioContext.createAnalyser();
	audioSource.connect( analyser );
	analyser.connect( audioContext.destination );
	analyser.fftSize = 2048;
	var bufferLength = analyser.frequencyBinCount;
	dataArray = new Uint8Array( bufferLength );
	
	audioSocket = new WebSocket( asUri );
	audioSocket.onmessage = onMessage;
	audioSocket.onclose = onClose();
	audio.onended = onEnded;
	toggle.onclick = onToggle;
}

function onMessage( event )
{	
	var message = event.data;
	
	if ( audio.paused )
	{
		if ( message.indexOf( "[INIT_TIME]" ) == 0 )
		{
			var time = parseInt( message.slice( 12, message.length ) );
			audio.currentTime = time;
			audio.play();
			start();
		}
		else
		{
			var track = JSON.parse( message );
			cover.src = track.coverFile;
			trackName.innerHTML = track.name + " - "; 
			singer.innerHTML = track.singer;
			audio.src = track.songFile;
			audio.volume = 0.09;
			
		}
	}
}

function onClose( event )
{
	console.log( "Websocket closed connection..." );
}

function start()
{
	updateChart();
	timerID = setInterval( updateChart, 15 );
	tip.innerHTML = "Now Playing";
	onToggle();
}

function stop()
{
	clearInterval( timerID );
	tip.innerHTML = "";
}

function onEnded( event )
{
	audioSocket.send( "[NEXT]" );
	stop();
}

function onToggle( event )
{
	var str = toggle.textContent;	
	
	if ( str === "▲" )
	{
		toggle.innerHTML = "&#9660";
		playbar.style.display = "block";
	}
	else if ( str === "▼" )
	{
		toggle.innerHTML = "&#9650";
		playbar.style.display = "none";
	}
}

function updateChart() 
{	
    analyser.getByteFrequencyData( dataArray );
    for( var j = 0; j < 256; j++ )
    {
      chart.childNodes[ j ].style.height = dataArray[ j ] * 0.2 + "px";
      chart.childNodes[ j ].style.background = "rgba( " + ( 255 - j ) + "," + j + ", " + j * 2 + ", 1 )";
    }
 }