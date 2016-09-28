/**
 * websocket and web audio api
 */
var asUri = "ws://localhost:8080/Aoide/play";
var cover = document.getElementById( "cover" );
var audio = document.getElementById( "track" );
var trackName = document.getElementById( "trackName" );
var singer = document.getElementById( "singer" );
var tip = document.getElementById( "tip" );
var playbar = document.getElementById( "playbar" );
var toggle =  document.getElementById( "toggle" );
var chart = document.getElementById( "chart" );
var ranger = document.getElementById( "ranger" );
var playTime = document.getElementById( "playTime" );
var progressBar = document.getElementById( "progressBar" );
var volumeIcon = document.getElementById( "volumeIcon" );
var controlIcon = document.getElementById( "controlIcon" );

var playlistSpan = document.getElementById( "playlistMenu" );	//playlist component
var closer = document.getElementById( "closer" );
var arrayList = document.getElementById( "list" );
var playlist = document.getElementById( "playlist" );
var playlistFooter = document.getElementById( "playlistFooter" );

var playbarVisible;
var aoideVolume;
var drawChartTimerID;
var trackCounterTimerID;
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
	
	audioSocketInitialize();		//audio websocket 
	
	playbarVisible = false;
	audio.onended = audioEnded;
	toggle.onclick = onToggle;
	ranger.onchange = onVolumeChange;
	controlIcon.onclick = control;
	volumeIcon.onclick = volumeMuted;
	
	playlistSpan.onclick = showPlaylist;		//playlist
	closer.onclick = playlistClose;
	
	aoideVolume = 0.09; //default sound volume
	if ( window[ "localStorage" ] )
	{
		var value = localStorage.getItem( "Aoide_Volumn" );
		if ( value )
		{
			aoideVolume = parseFloat( value );
		}
		else
		{
			localStorage.setItem( "Aoide_Volumn", aoideVolume );
		}
	}
	
}

function audioSocketInitialize()
{
	audioSocket = new WebSocket( asUri );
	audioSocket.onopen = onOpen;
	audioSocket.onmessage = onMessage;
	audioSocket.onerror = onError;
	audioSocket.onclose = onClose;
}
function onOpen()
{
	tip.innerHTML = "Waiting...";
	audioSocket.send( "[ALL]" );
}

function onMessage( event )
{	
	var message = event.data;
	
	if ( audio.paused )
	{
		if ( message.indexOf( "[INIT_TIME]" ) == 0 )
		{
			var time = parseInt( message.split( "[INIT_TIME]" )[ 1 ] );
			audio.currentTime = time;
			start();
		}
		else if ( message.indexOf( "[CURRENT]" ) == 0 )
		{
			var track = JSON.parse( message.split( "[CURRENT]" )[ 1 ] );
			cover.src = track.coverFile;
			trackName.innerHTML = track.name + " - "; 
			singer.innerHTML = track.singer;
			audio.src = track.songFile;
			audio.volume = aoideVolume;
		}
	}
	
	if ( message.indexOf( "[ALL]" ) == 0 )
	{
		var trackArray = JSON.parse( message.split( "[ALL]" )[ 1 ] );

		for ( var i = 0; i < trackArray.length; i++ )
		{

			var coverImg = document.createElement( "img" );
			coverImg.src = trackArray[ i ].coverFile;
			coverImg.style.width = "50px";
			coverImg.style.height = "50px";
				
			var temp = document.createTextNode( trackArray[ i ].name + " - " + trackArray[ i ].singer );
			
			var row = arrayList.insertRow( i );
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			cell1.appendChild( coverImg );
			cell2.appendChild( temp );				
		}
	}
	else if ( message.indexOf( "[NEW]" ) == 0 )
	{
		var newTrack = JSON.parse( message.split( "[NEW]" )[ 1 ] );
		var rows = arrayList.rows.length;
		var newRow = arrayList.insertRow( rows );
		var cell1 = newRow.insertCell( 0 );
		var cell2 = newRow.insertCell( 1 );
		
		var coverImg = document.createElement( "img" );
		coverImg.src = newTrack.coverFile;
		coverImg.style.width = "50px";
		coverImg.style.height = "50px";
		
		var temp = document.createTextNode( newTrack.name + " - " + newTrack.singer );
		cell1.appendChild( coverImg );
		cell2.appendChild( temp );	
	}
	
	if ( arrayList.rows.length > 0 )
	{
		playlistFooter.innerHTML = "On-Demand Tracks";
	}
}

function onError( event )
{
	console.log( "Error occured..." );
	audioSocketInitialize();
}

function onClose( event )
{
	console.log( "Websocket closed connection..." );
	stop();
}

function audioEnded( event )
{
	audioSocket.send( "[NEXT]" );
	end();
}

function start()
{
	audio.play();
	updateChart();
	drawChartTimerID = setInterval( updateChart, 15 );
	
	//updateProgress();
	trackCounterTimerID = setInterval( updateProgress, 1000 );
	
	tip.innerHTML = "Now Playing";
	controlIcon.src = "views/dist/img/playbar/pause.png";
	if ( playbarVisible === false )
	{
		onToggle();
	}
	
}

function end()
{
	trackInfoReset( "Waiting..." );
	controlIcon.src = "views/dist/img/playbar/play.png";
	clearInterval( drawChartTimerID );
	clearInterval( trackCounterTimerID );
	arrayList.deleteRow( 0 );
	if ( arrayList.rows.length == 0 )
	{
		playlistFooter.innerHTML = "None";
	}
}

function stop()
{	
	audio.pause();
	audioSocket.close();
	trackInfoReset( "Stop Connecting..." );
	controlIcon.src = "views/dist/img/playbar/play.png";
	clearInterval( drawChartTimerID );
	clearInterval( trackCounterTimerID );
}

function control()
{
	if ( audio.paused )
	{
		audioSocketInitialize();
	}
	else
	{
		stop();
		resetChart()
	}
}


function trackInfoReset( status )
{
	tip.innerHTML = status;
	trackName.innerHTML = ""; 
	singer.innerHTML = "";
	cover.src = "/Aoide/files/song_cover_files/default.jpg";
	playTime.innerHTML = "00:00 / 00:00"
	progressBar.value = 0;
}

function onToggle( event )
{

	if ( playbarVisible === false )
	{
		playbar.style.display = "block";
		playbarVisible = true;
	}
	else if ( playbarVisible === true )
	{
		playbar.style.display = "none";
		playbarVisible = false;
	}
}

function onVolumeChange( event ) 
{
	var volume = event.target.value;
	audio.volume = volume;
	if ( window[ "localStorage" ] )
	{
		localStorage.setItem( "Aoide_Volumn", volume );
	}
	aoideVolume = volume;
	volumeChangeHelper( volume )
}

function volumeChangeHelper( value )
{
	if ( value == 0 )
	{
		volumeIcon.src = "views/dist/img/playbar/volume_none.png";
	}
	else if ( value >= 0.66 )
	{
		volumeIcon.src = "views/dist/img/playbar/volume_high.png";
	}
	else if ( value >= 0.33 )
	{
		volumeIcon.src = "views/dist/img/playbar/volume_medium.png";
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

function updateProgress()
{
	var current = parseInt( audio.currentTime );
	var total = parseInt( audio.duration );
	
	if ( current <= total )
	{
		var temp1 = new Date( current * 1000 );
		var temp2 = new Date( total * 1000 );
		
		var currentTime = ( temp1.getMinutes() < 10 ? "0" + temp1.getMinutes() : temp1.getMinutes() ) + ":" 
								+ ( temp1.getSeconds() < 10 ? "0" + temp1.getSeconds() : temp1.getSeconds() );
		
		var duration = ( temp2.getMinutes() < 10 ? "0" + temp2.getMinutes() : temp2.getMinutes() ) + ":" 
							 + ( temp2.getSeconds() < 10 ? "0" + temp2.getSeconds() : temp2.getSeconds() );
		
		playTime.innerHTML = currentTime + " / " + duration;
		
		var percent = Math.floor( current / total  * 100 );
		progressBar.value = percent;
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

function resetChart() 
{
	for( var j = 0; j < 256; j++ )
    {
      chart.childNodes[ j ].style.height = dataArray[ j ] * 0 + "px";
      chart.childNodes[ j ].style.background = "rgba( " + ( 255 - j ) + "," + j + ", " + j * 2 + ", 1 )";
    }
}

function playlistClose() 
{
	playlist.style.display = "none";
};

function showPlaylist()
{
	
	playlist.style.display = "block";
}
