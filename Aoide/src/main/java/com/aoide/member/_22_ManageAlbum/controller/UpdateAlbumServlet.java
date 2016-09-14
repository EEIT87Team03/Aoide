package com.aoide.member._22_ManageAlbum.controller;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/UpdateAlbumServlet")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
							 maxFileSize = 1024 * 1024 * 5,//限制5MB
							 maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		AlbumVO album = null;
		AlbumVO updateAlbum = null;
		ListAlbumService service = null;
		
		request.setCharacterEncoding("UTF-8");
		
		final Part part = request.getPart("coverFile");
		final String coverFilename = getFileName(part).trim();
		int index = coverFilename.lastIndexOf('.');
		String fileNameExtension = coverFilename.substring(index); // get .jpg
		System.out.println("圖檔：" + fileNameExtension);
		
		OutputStream outputStream = null;
		InputStream inputStream = null;
		
		service = new ListAlbumService();
		
		String name = request.getParameter("name").trim();
		String artist = request.getParameter("artist").trim();
		String introductionFile = request.getParameter("introductionFile").trim();
		
		if (name != null && name.length() != 0){// having content and update
			session = request.getSession();
			album = (AlbumVO) session.getAttribute("aAlbum");
			session.removeAttribute("aAlbum");
			
			int id = album.getAlbumId();
			String newCoverFilename = "Albumid" + id + fileNameExtension;
			String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/album_cover_files/" + newCoverFilename;
			System.out.println("圖檔path: " + path);
			String srcPath = "/Aoide/files/album_cover_files/" + newCoverFilename;
			System.out.println("圖檔DBsrcPath: " + srcPath);
			
			album.setCoverFilePath(srcPath);
			album.setName(name);
			album.setArtist(artist);
			album.setIntroductionFilePath(introductionFile);
			
			System.out.println("album: " + album);
			System.out.println("album: " + album.getCoverFilePath());
			System.out.println("album: " + album.getName());
			System.out.println("album: " + album.getArtist());
			System.out.println("album: " + album.getIntroductionFilePath());
			
			// update album
			service.updateAlbum(album);	
			
			try {
				inputStream = part.getInputStream();// get file inputSteam
				outputStream = new FileOutputStream(new File(path)); // get FileOutputStream to write inputStrem into the file
				// write into file
				byte[] bytes = new byte[1024];
				int len;
				while ((len = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}
			
			System.out.println("update album success");
		}else{// no content
			System.out.println("no input name");
		}
		
		// get the song from database to check the result of update
		updateAlbum = service.getAlbumById(album.getAlbumId());
		session.setAttribute("updateAlbum", updateAlbum);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/editAlbumSuccess.jsp");
	}
	
	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
