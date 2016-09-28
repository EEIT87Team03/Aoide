package com.aoide.global.websocket.codec;

import java.util.List;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.aoide.global.dataBaseManipulationObjects.JsonConverter;
import com.aoide.global.websocket.track.TrackVO;

public class TrackListEncoder implements Encoder.Text< List< TrackVO > > 
{

	@Override
	public void destroy() 
	{
		
	}

	@Override
	public void init(EndpointConfig arg0) 
	{

	}

	@Override
	public String encode( List< TrackVO > list ) throws EncodeException 
	{
		try 
		{
			return "[ALL]" + JsonConverter.convertToJsonArray( list ).toString();
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
