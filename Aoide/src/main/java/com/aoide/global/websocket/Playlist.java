package com.aoide.global.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.aoide.global.websocket.track.TrackVO;

public class Playlist 
{
	private static List< TrackVO > list = new ArrayList<>();
	private TrackVO currentPlayingTrack;
	private int currentPlayingTrackLength;
	private int currentPlayingTrackMaxLength;
	private Timer timer;
	
	public Playlist()
	{
		
	}
	
	public int getTrackLength( int index )
	{
		String[] length = list.get( index ).getLength().split( ":" );
		int seconds = Integer.parseInt( length[ 0 ] ) * 60 * 60 +
					  Integer.parseInt( length[ 1 ] ) * 60 +
					  Integer.parseInt( length[ 2 ] );
		
		return seconds;
	}				
	
	public boolean add( TrackVO vo)
	{
		boolean result = list.add( vo );
		if ( list.size() == 1 )
		{
			timer = new Timer();
			currentPlayingTrack = vo;
			currentPlayingTrackMaxLength = getTrackLength( 0 );
			timer.scheduleAtFixedRate( new UpdatePlayingTrackInfo() , 0, 1000 );
		}
			
		return result;
	}
	
	public TrackVO remove( int index )
	{
		TrackVO vo = list.remove( index );
		if ( list.size() == 0)
		{
			currentPlayingTrack = null;
			currentPlayingTrackLength = 0;
			currentPlayingTrackMaxLength = 0;
			timer.cancel();
		}
		
		return vo;
	}
	
	public int size()
	{
		return list.size();
	}
	
	public TrackVO get( int index )
	{
		return list.get( index );
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for ( int i = 0; i < list.size(); i ++ )
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
			if ( list.size() >= 1 )
			{
				if ( ++currentPlayingTrackLength >= currentPlayingTrackMaxLength )
				{
					list.remove( 0 );
					if ( list.size() != 0 )
					{
						currentPlayingTrack = list.get( 0 );
						currentPlayingTrackLength = 0;
						currentPlayingTrackMaxLength = getTrackLength( 0 );
					}
					
				}
				
			}
			
		}
	}
}
