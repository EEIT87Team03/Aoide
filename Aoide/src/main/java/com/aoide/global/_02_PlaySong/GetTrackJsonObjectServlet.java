package com.aoide.global._02_PlaySong;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.JsonConverter;
import com.aoide.global.websocket.track.TrackService;
import com.aoide.global.websocket.track.TrackVO;

@WebServlet("/GetTrack")
public class GetTrackJsonObjectServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public GetTrackJsonObjectServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		JsonObject jo = null;
		TrackService ts = new TrackService();
		try
		{
			int id = Integer.parseInt( request.getParameter( "songId" ) );
			
			TrackVO vo = ts.getTrackBean( id );
			jo = JsonConverter.convertToJsonObject( vo );
		}
		catch ( Exception e ) 
		{
			e.printStackTrace();
		} 
		JsonWriter jw = Json.createWriter( response.getWriter() );
		jw.writeObject( jo );
	}

	
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
