package com.aoide.global._02_PlaySong;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.Playlist;


@WebServlet("/GetPlaylist")
public class GetPlaylistServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public GetPlaylistServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext context = getServletContext();
		Playlist playlist = ( Playlist ) context.getAttribute( Playlist.class.getName() );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
