package com.aoide.global.websocket.codec;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.aoide.global.dataBaseManipulationObjects.JsonConverter;
import com.aoide.global.websocket.track.TrackVO;

public class TrackVOEncoder implements Encoder.Text< TrackVO >
{

	@Override
	public void destroy() 
	{
		
	}

	@Override
	public void init( EndpointConfig config ) 
	{
	
	}

	@Override
	public String encode( TrackVO vo ) throws EncodeException 
	{
		try 
		{
			return JsonConverter.convertToJsonObject( vo ).toString();
		} 
		catch ( Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
