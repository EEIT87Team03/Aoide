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
var ranger = document.getElementById( "ranger" );
var volumeIcon = document.getElementById( "volumeIcon" );
var controlIcon = document.getElementById( "controlIcon" );
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
	
	audioSocketInitialize();
	toggle.onclick = onToggle;
	ranger.onchange = onVolumeChange;
	controlIcon.onclick = control;
	volumeIcon.onclick = volumeMuted;
}

function audioSocketInitialize()
{
	audioSocket = new WebSocket( asUri );
	audioSocket.onopen = onOpen;
	audioSocket.onmessage = onMessage;
	audioSocket.onclose = onClose;
	audio.onended = onEnded;
}
function onOpen()
{
	tip.innerHTML = "Connecting...";
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
function onEnded( event )
{
	audioSocket.send( "[NEXT]" );
	stop();
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
	controlIcon.src = "views/dist/img/playbar/pause.png";
	if ( playbar.style.display == "none" )
	{
		onToggle();
	}
}

function stop()
{
	clearInterval( timerID );
	tip.innerHTML = "Waiting...";
	controlIcon.src = "views/dist/img/playbar/play.png";
}

function control()
{
	if ( audio.paused )
	{
		audioSocketInitialize();
	}
	else
	{
		audio.pause();
		audioSocket.close();
		stop();
	}
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

function onVolumeChange( event ) 
{
	var volume = event.target.value;
	audio.volume = volume;
	volumeChangeHelper( volume )
}

function volumeChangeHelper( value )
{
	if ( value == 0 )
	{
		volumeIcon.src = "views/dist/img/playbar/volume_none.png";
	}
	else if ( value > 0.5 )
	{
		volumeIcon.src = "views/dist/img/playbar/volume_high.png";
	}
	else
	{
		volumeIcon.src = "views/dist/img/playbar/volume_low.png";
	}
}

function volumeMuted()
{
	audio.muted = !audio.muted;
	if ( audio.muted )
	{
		volumeChangeHelper( 0 );
	}
	else
	{
		volumeChangeHelper( audio.volume );
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