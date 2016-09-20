package com.aoide.member._99_TestUpload.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aoide.global._00_TestUtil.UploadHelper;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._99_TestUpload.model.UploadService;


@WebServlet("/TestUploadServlet")
@MultipartConfig(location="C:\\tmp", fileSizeThreshold=1024*1024,
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class TestUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//upload limit in Tomcat  http://stackoverflow.com/questions/2947683/httprequest-maximum-allowable-size-in-tomcat
		//reference   https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
		
		//前端抓值
	    final Part part = request.getPart("songFile");
	    
	    // get file size and content type
	    /*
	    System.out.println("type: " + part.getContentType()); // audio/mp3 image/jpeg
	    System.out.println("size: " + part.getSize()); // byte
	    System.out.println("isAudio: " + Validator.isAudio(part));
	    System.out.println("isImage: " + Validator.isImage(part));
	    System.out.println("isEmptyPart: " + Validator.isEmptyPart(part));
	    */
	    String fileNameExtension = UploadHelper.getFileExtention(part);
	    UploadService service = new UploadService();
		// call service to save name and tempPath into DB and get the id of the song
	    String name = request.getParameter("name");
	    SongVO song = new SongVO();
	    
	    song.setName(name);
	    song.setSinger("test 0912");
	    
	    System.out.println("Singer: " + song.getSinger());
	    
	    
	    song.setSongFile("tempPath");
	    int id = service.saveUpload(song); // dao.insert(vo)
		// make file name and path for storage
	    
	    /*-----------------get path form context---------------*/
		ServletContext context = request.getServletContext();
		Properties paths = (Properties) context.getAttribute("paths");
		String folderPath = paths.getProperty("songFolderPath");
		String srcRoot = paths.getProperty("songFolderPath");
		/*-----------------------------------------------------*/
		
		
	    String newFileName = "Songid" + id + fileNameExtension;
	    
	    
	    String path = folderPath + newFileName;
	    
	    System.out.println(path);

	    
	    // try to save upload in given path
	    UploadHelper.savePartIntoPath(part, path);
		// call service to update the path in DB by id
	    song.setSongId(id);

	    String  srcPath = srcRoot + newFileName; 

	    song.setSongFile(srcPath);
	    song.setAlbumId(1);
	    service.updatePath(song); //service.insert(adVO)
		// call service to check the song in DB by id
	    song = service.checkUpload(id);
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    // go to DisplayResultServlet
	    request.getSession().setAttribute("song", song);
	    request.getRequestDispatcher("/DisplayResultServlet").forward(request, response);
	    return;
	  
	}

}
