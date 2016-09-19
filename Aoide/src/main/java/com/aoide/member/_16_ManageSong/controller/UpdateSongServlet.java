package com.aoide.member._16_ManageSong.controller;

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

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/UpdateSongServlet")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
										 maxFileSize = 1024 * 1024 * 5,//限制5MB
										 maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		SongVO song = null;
		SongVO updateSong = null;
		ListSongService service = null;
		
		request.setCharacterEncoding("UTF-8");
		
		final Part part = request.getPart("coverFile");
		final String coverFilename = getFileName(part).trim();
		int index = coverFilename.lastIndexOf('.');
		String fileNameExtension = coverFilename.substring(index); // get .jpg
		System.out.println("圖檔：" + fileNameExtension);
		
		OutputStream outputStream = null;
		InputStream inputStream = null;
		
		service = new ListSongService();
		
		String name = request.getParameter("name").trim();
		String singer = request.getParameter("singer").trim();
		String songType = request.getParameter("songType").trim();
		String songLanguage = request.getParameter("songLanguage").trim();
		String introductionFile = request.getParameter("introductionFile").trim();
		String lyricsFile = request.getParameter("lyricsFile").trim();
		
		if (name != null && name.length() != 0){// having content and update
			session = request.getSession();
			song = (SongVO) session.getAttribute("aSong");
			session.removeAttribute("aSong");
			
			int id = song.getSongId();
			String newCoverFilename = "Songid" + id + fileNameExtension;
			String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_cover_files/" + newCoverFilename;
			System.out.println("圖檔path: " + path);
			String srcPath = "/Aoide/files/song_cover_files/" + newCoverFilename;
			System.out.println("圖檔DBsrcPath: " + srcPath);
			
			song.setCoverFile(srcPath);
			song.setName(name);
			song.setSinger(singer);
			song.setSongType(songType);
			song.setSongLanguage(songLanguage);
			song.setIntroductionFile(introductionFile);
			song.setLyricsFile(lyricsFile);
			
			System.out.println("song: " + song);
			System.out.println("song: " + song.getCoverFile());
			System.out.println("song: " + song.getName());
			System.out.println("song: " + song.getSinger());
			System.out.println("song: " + song.getSongType());
			System.out.println("song: " + song.getSongLanguage());
			System.out.println("song: " + song.getIntroductionFile());
			System.out.println("song: " + song.getLyricsFile());
			
			// update song
			service.updateSong(song);	
			
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
			
			System.out.println("update song success");
		}else{// no content
			System.out.println("no input name");
		}
		
		// get the song from database to check the result of update
		updateSong = service.getSongById(song.getSongId());
		session.setAttribute("updateSong", updateSong);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_16_ManageSong.view/editSongSuccess.jsp");
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
