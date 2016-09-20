package com.aoide.global.dataBaseManipulationObjects;

import java.util.ArrayList; 
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.aoide.global.listener.PlaylistListener;
import com.aoide.global.websocket.track.TrackVO;

public class Playlist 
{
	private static List< TrackVO > list = new ArrayList<>();
	private List< PlaylistListener > listeners = new ArrayList<>();
	private Timer timer;
	private	volatile TrackVO currentPlayingTrack;
	private volatile int size;
	private int currentPlayingTrackLength;
	private int currentPlayingTrackMaxLength;
	
	public Playlist()
	{
		clear();
		size = 0;
	}
	
	public TrackVO getCurrentPlayingTrack()
	{
		return currentPlayingTrack;
	}
	
	public int getCurrentPlayingTrackLength()
	{
		return currentPlayingTrackLength;
	}
	
	public int getTrackLength( TrackVO vo )
	{
		String[] length = vo.getLength().split( ":" );
		int seconds = Integer.parseInt( length[ 0 ] ) * 60 * 60 +
					  Integer.parseInt( length[ 1 ] ) * 60 +
					  Integer.parseInt( length[ 2 ] );
		
		return seconds;
	}				
	
	public boolean hasNext()
	{
		return currentPlayingTrack != null;
	}
	
	public boolean add( TrackVO vo )
	{	
		boolean result;
		synchronized( list )
		{
			if ( size++ == 0 )
			{	
				timer = new Timer();
				currentPlayingTrack = vo;
				currentPlayingTrackMaxLength = getTrackLength( vo );
				timer.scheduleAtFixedRate( new UpdatePlayingTrackInfo() , 0, 1000 );
			}
			result = list.add( vo );
			System.out.println( "add : " + vo );
		}
		notifyListeners();
		
		return result;
	}
	
	public TrackVO remove( int index )
	{
		if ( --size == 0 )
		{	
			clear();
			timer.cancel();
		}
		TrackVO vo = list.remove( index );
		
		System.out.println( "remove : " + vo );
		return vo;
	}
	
	public void addListener( PlaylistListener listener )
	{
		listeners.add( listener );
		if ( hasNext() )
		{
			listener.listen();
		}
	}
	
	public void removeListener( PlaylistListener listener )
	{
		int i = listeners.indexOf( listener );
		if ( i >= 0 )
		{
			listeners.remove( i );
		}
	}
	
	public void notifyListeners()
	{
		for ( PlaylistListener listener : listeners )
		{
			listener.listen();
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public TrackVO get( int index )
	{
		return list.get( index );
	}
	
	private void clear()
	{
		currentPlayingTrack = null;
		currentPlayingTrackLength = 0;
		currentPlayingTrackMaxLength = 0;
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for ( int i = 0; i < size; i ++ )
		{
			sb.append( list.get( i ) + "\n" );
		}
		return sb.toString();
	}
	
	private class UpdatePlayingTrackInfo extends TimerTask
	{
		@Override
		public void run() 
		{
			if ( ( size >= 1 ) && ( ++currentPlayingTrackLength >= currentPlayingTrackMaxLength ) )
			{
				synchronized( list )
				{
					remove( 0 );
					if ( size > 0 )
					{
						currentPlayingTrack = list.get( 0 );
						currentPlayingTrackLength = 0;
						currentPlayingTrackMaxLength = getTrackLength( list.get( 0 ) );
					}
				}	
			}	
		}
	}
}
