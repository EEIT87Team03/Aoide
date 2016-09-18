package com.aoide.global.websocket;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.websocket.track.TrackVO;

public class Playlist 
{
	private static List< TrackVO > list = new ArrayList<>();
	private int trackLength;
	
	public Playlist()
	{
		
	}
	
	public boolean add( TrackVO vo)
	{
		return list.add( vo );
	}
	
	public boolean remove( TrackVO vo )
	{
		return list.remove( vo );
	}
	
	public TrackVO remove( int index )
	{
		return list.remove( index );
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
}
