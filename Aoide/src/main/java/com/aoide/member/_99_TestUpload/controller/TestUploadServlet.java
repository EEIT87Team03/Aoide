package com.aoide.member._99_TestUpload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._99_TestUpload.model.UploadService;


@WebServlet("/TestUploadServlet")
@MultipartConfig(location="C:\\tmp", fileSizeThreshold=1024*1024,
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class TestUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//upload limit in Tomcat  http://stackoverflow.com/questions/2947683/httprequest-maximum-allowable-size-in-tomcat
		//reference   https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
		
	    final Part part = request.getPart("songFile");
	    final String fileName = getFileName(part).trim();
	    int index = fileName.lastIndexOf('.');
	    String fileNameExtension = fileName.substring(index); // get .mp3
	    
	    System.out.println(fileNameExtension);
	    
	    OutputStream outputStream = null;
	    InputStream inputStream = null;
	    
	    UploadService service = new UploadService();

		// call service to name and tempPath into DB and get the id of the song
	    String name = request.getParameter("name");
	    SongVO song = new SongVO();
	    song.setMemberId(1);
	    song.setName(name);
	    song.setSongFile("tempPath");
	    int id = service.saveUpload(song); 
		// make file name and path for storage
	    String newFileName = "Songid" + id + fileNameExtension;
	    String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_file/" + newFileName;
	    
	    System.out.println("path1: " + path);
	    
	    // try to save upload in given path
	    try {
		    inputStream = part.getInputStream();// get file inputSteam
		    outputStream = new FileOutputStream(new File(path)); // get FileOutputStream to write inputStrem into the file
		    // write into file
		    byte[] bytes = new byte[1024];
		    int len;
		    while ( (len = inputStream.read(bytes))  != -1) {
		    	outputStream.write(bytes, 0, len);
		    }
		 } catch(IOException e){
			 e.printStackTrace();
		 } finally {
	         if (inputStream != null) {
	        	 inputStream.close();
	         }
	         if (outputStream != null) {
	        	 outputStream.close();
	         }
	     }

		// call service to update the path in DB by id
	    song.setSongId(id);
	    String  srcPath = "/files/song_file/" + newFileName;
	    song.setSongFile(srcPath);
	    
	    System.out.println("srcPath: " + srcPath);
	    
	    song.setAlbumId(1);
	    service.updatePath(song);
		// call service to check the song in DB by id
	    song = service.checkUpload(id);
	    
	    // go to checkUploadResult.jsp
	    request.getSession().setAttribute("song", song);
	    String contextPath = request.getContextPath();
	    response.sendRedirect(contextPath + "/_99_TestUpload.view/checkUploadResult.jsp");
	}
	
	
	private String getFileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
