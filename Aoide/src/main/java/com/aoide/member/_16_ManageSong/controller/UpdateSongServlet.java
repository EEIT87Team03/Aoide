package com.aoide.member._16_ManageSong.controller;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aoide.global._00_TestUtil.UploadHelper;
import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/UpdateSongServlet.member")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
										 maxFileSize = 1024 * 1024 * 5 * 5,//限制25MB
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
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		String fileNameExtension = null;
		String contextPath = request.getContextPath();
		
		final Part part = request.getPart("coverFile");
		if(Validator.isEmptyPart(part)){
			
		}else{
			if(!Validator.isImage(part)){
				errorMsg.put("emptyPartMsg", "*只能上傳圖片檔案");
			}else{
				if(!Validator.isPartOverSize(part, 5242880)){
					errorMsg.put("emptyPartMsg", "*圖片檔案上傳請勿超過5MB");
				}else{
//					final String coverFilename = getFileName(part).trim();
//					int index = coverFilename.lastIndexOf('.');
//					String fileNameExtension = coverFilename.substring(index); // get .jpg
					fileNameExtension = UploadHelper.getFileExtention(part);
					System.out.println("圖檔：" + fileNameExtension);
				}
			}
		}
				
//		OutputStream outputStream = null;
//		InputStream inputStream = null;
		
		service = new ListSongService();
		
		String name = request.getParameter("name").trim();
		String singer = request.getParameter("singer").trim();
		String songType = request.getParameter("songType").trim();
		String songLanguage = request.getParameter("songLanguage").trim();
		String introductionFile = request.getParameter("introductionFile").trim();
		String lyricsFile = request.getParameter("lyricsFile").trim();
		
		if (!Validator.isValidString(name)){
			errorMsg.put("emptyNameMsg", "*請輸入歌名");
		}else{
			enteredText.put("name", name);
			enteredText.put("songType", songType);
			enteredText.put("songLanguage", songLanguage);
			enteredText.put("introductionFile", introductionFile);
			enteredText.put("lyricsFile", lyricsFile);
		}
		
		if(!Validator.isValidString(singer)){
			errorMsg.put("emptySingerMsg", "*請輸入演出者");
		}else{
			enteredText.put("singer", singer);
			enteredText.put("songType", songType);
			enteredText.put("songLanguage", songLanguage);
			enteredText.put("introductionFile", introductionFile);
			enteredText.put("lyricsFile", lyricsFile);
		}
		
		if(errorMsg.isEmpty()){
			session = request.getSession();
			song = (SongVO) session.getAttribute("song");
			session.removeAttribute("song");
			
			ServletContext context = request.getServletContext();
			Properties paths = (Properties) context.getAttribute("paths");
			String folderPath = paths.getProperty("coverFolderPath");
			String srcRoot = paths.getProperty("coverSrcRoot");
			if(!Validator.isEmptyPart(part)){
				int id = song.getSongId();
				String newCoverFilename = "Songid" + id + fileNameExtension;
				//String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_cover_files/" + newCoverFilename;
				String path = folderPath + newCoverFilename;
				System.out.println("圖檔path: " + path);
				//String srcPath = "/Aoide/files/song_cover_files/" + newCoverFilename;
				String srcPath = srcRoot + newCoverFilename;
				System.out.println("圖檔DBsrcPath: " + srcPath);
				
				song.setCoverFile(srcPath);
				song.setName(name);
				song.setSinger(singer);
				song.setSongType(songType);
				song.setSongLanguage(songLanguage);
				song.setIntroductionFile(introductionFile);
				song.setLyricsFile(lyricsFile);
				
				System.out.println("coverFile：" + song.getCoverFile());
				System.out.println("name：" + song.getName());
				System.out.println("singer：" + song.getSinger());
				System.out.println("songType：" + song.getSongType());
				System.out.println("songLanguage：" + song.getSongLanguage());
				System.out.println("introductionFile：" + song.getIntroductionFile());
				System.out.println("lyricsFile：" + song.getLyricsFile());
				
				// update song
				service.updateSong(song);	
				
//				try {
//					inputStream = part.getInputStream();// get file inputSteam
//					outputStream = new FileOutputStream(new File(path)); // get FileOutputStream to write inputStrem into the file
//					// write into file
//					byte[] bytes = new byte[1024];
//					int len;
//					while ((len = inputStream.read(bytes)) != -1) {
//						outputStream.write(bytes, 0, len);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					if (inputStream != null) {
//						inputStream.close();
//					}
//					if (outputStream != null) {
//						outputStream.close();
//					}
//				}
				UploadHelper.savePartIntoPath(part, path);
				System.out.println("update song success");
				// get the song from database to check the result of update
				updateSong = service.getSongById(song.getSongId());
				session.setAttribute("updateSong", updateSong);
				response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/EditSongSuccess.jsp");
				return;
			}else{
				song.setName(name);
				song.setSinger(singer);
				song.setSongType(songType);
				song.setSongLanguage(songLanguage);
				song.setIntroductionFile(introductionFile);
				song.setLyricsFile(lyricsFile);
				
				System.out.println("name：" + song.getName());
				System.out.println("singer：" + song.getSinger());
				System.out.println("songType：" + song.getSongType());
				System.out.println("songLanguage：" + song.getSongLanguage());
				System.out.println("introductionFile：" + song.getIntroductionFile());
				System.out.println("lyricsFile：" + song.getLyricsFile());
				
				// update song
				service.updateSong(song);	
				
				// get the song from database to check the result of update
				updateSong = service.getSongById(song.getSongId());
				session.setAttribute("updateSong", updateSong);
				response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/EditSongSuccess.jsp");
				return;
			}
		}else{
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/views/member/_16_ManageSong.view/EditSong.jsp").forward(request, response);
			return;
		}
	}
	
//	private String getFileName(final Part part) {
//		for (String content : part.getHeader("content-disposition").split(";")) {
//			if (content.trim().startsWith("filename")) {
//				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
//			}
//		}
//		return null;
//	}

}
