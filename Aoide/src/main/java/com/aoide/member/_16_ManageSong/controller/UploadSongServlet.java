package com.aoide.member._16_ManageSong.controller;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.IOException;
import java.sql.Date;
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
import javax.servlet.http.Part;

import com.aoide.global._00_TestUtil.UploadHelper;
import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.UploadSongService;

@WebServlet("/UploadSongServlet")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
										 maxFileSize = 1024 * 1024 * 5	* 5,//限制25MB
										 maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		String fileNameExtension = null;
		String fileNameExtension2 =null;
		String contextPath = request.getContextPath();

		final Part part = request.getPart("songFile");
		if(Validator.isEmptyPart(part)){
			errorMsg.put("emptyPartMsg", "請選擇歌曲");
		}else{
			if(!Validator.isAudio(part)){
				errorMsg.put("emptyPartMsg", "只能上傳音樂檔案");
			}else{
				if(!Validator.isPartOverSize(part, 26214400)){
					errorMsg.put("emptyPartMsg", "音樂檔案上傳請勿超過25MB");
				}else{
					//final String songFilename = getFileName(part).trim();
					//int index = songFilename.lastIndexOf('.');
					//String fileNameExtension = songFilename.substring(index); // get .mp3
					fileNameExtension = UploadHelper.getFileExtention(part);
					System.out.println("音檔：" + fileNameExtension);
				}
			}
		}

		final Part part2 = request.getPart("coverFile");
		if(Validator.isEmptyPart(part2)){
			
		}else{
			if(!Validator.isImage(part2)){
				errorMsg.put("emptyPart2Msg", "只能上傳圖片檔案");
			}else{
				if(!Validator.isPartOverSize(part2, 5242880)){
					errorMsg.put("emptyPart2Msg", "圖片檔案上傳請勿超過5MB");
				}else{
					// final String coverFilename = getFileName(part2).trim();
					// int index2 = coverFilename.lastIndexOf('.');
					// String fileNameExtension2 = coverFilename.substring(index2); // get.jpg
					fileNameExtension2 = UploadHelper.getFileExtention(part2);
					System.out.println("圖檔：" + fileNameExtension2);
				}
			}
		}

		//OutputStream outputStream = null;
		//InputStream inputStream = null;
		// OutputStream outputStream2 = null;
		// InputStream inputStream2 = null;

		UploadSongService service = new UploadSongService();

		// call service to name and tempPath into DB and get the id of the song
		String songType = request.getParameter("songType");
		String songLanguage = request.getParameter("songLanguage");
		String introductionFile = request.getParameter("introductionFile");
		String lyricsFile = request.getParameter("lyricsFile");
		
		String name = request.getParameter("name");
		if(!Validator.isValidString(name)){
			errorMsg.put("emptyNameMsg", "請輸入歌名");
		}else{
			enteredText.put("name", name);
			enteredText.put("songType", songType);
			enteredText.put("songLanguage", songLanguage);
			enteredText.put("introductionFile", introductionFile);
			enteredText.put("lyricsFile", lyricsFile);
		}
		
		String singer = request.getParameter("singer");
		if(!Validator.isValidString(singer)){
			errorMsg.put("emptySingerMsg", "請輸入出演者");
		}else{
			enteredText.put("singer", singer);
			enteredText.put("songType", songType);
			enteredText.put("songLanguage", songLanguage);
			enteredText.put("introductionFile", introductionFile);
			enteredText.put("lyricsFile", lyricsFile);
		}
		
		if(errorMsg.isEmpty()){
			Date updateDate = new Date(System.currentTimeMillis());
			SongVO song = new SongVO();
			if(!Validator.isEmptyPart(part2)){
				song.setSongFile("tempPath");
				song.setCoverFile("/Aoide/files/song_cover_files/default.jpg");
				song.setName(name);
				song.setSinger(singer);
				song.setSongType(songType);
				song.setSongLanguage(songLanguage);
				//改會員時看這裡
				song.setMemberId(1);
				//改會員時看這裡
				song.setIntroductionFile(introductionFile);
				song.setLyricsFile(lyricsFile);
				song.setUpdateDate(updateDate);

				int id = service.insertUploadSong(song);
				
				//song
				ServletContext context = request.getServletContext();
				Properties paths = (Properties) context.getAttribute("paths");
				String folderPath = paths.getProperty("songFolderPath");
				String srcRoot = paths.getProperty("songFolderPath");
				
				//cover
				ServletContext context2 = request.getServletContext();
				Properties paths2 = (Properties) context2.getAttribute("paths");
				String folderPath2 = paths2.getProperty("coverFolderPath");
				String srcRoot2 = paths2.getProperty("coverFolderPath");
				
				// make file name and path for storage
				String newSongFilename = "Songid" + id + fileNameExtension;
				//String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_file/" + newSongFilename;
				String path = folderPath + newSongFilename;
				System.out.println("音檔path: " + path);

				String newCoverFilename = "Songid" + id + fileNameExtension2;
				// String path2 ="C:/Aoide/repository/Aoide/src/main/webapp/files/song_cover_files/" + newCoverFilename;
				String path2 = folderPath2 + newCoverFilename;
				System.out.println("圖檔path: " + path2);

				// try to save upload in given path
//				try {
//					inputStream = part.getInputStream();// get file inputSteam
//					outputStream = new FileOutputStream(new File(path)); // get FileOutputStream to write inputStrem into the file
//					inputStream2 = part2.getInputStream();// get file inputSteam
//					outputStream2 = new FileOutputStream(new File(path2)); // get FileOutputStream to write inputStrem into the file
//					// write into file
//					byte[] bytes = new byte[1024];
//					int len;
//					while ((len = inputStream.read(bytes)) != -1) {
//						outputStream.write(bytes, 0, len);
//					}
//					while ( (len = inputStream2.read(bytes)) != -1) {
//					outputStream2.write(bytes, 0, len);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					if (inputStream != null) {
//						inputStream.close();
//						inputStream2.close();
//					}
//					if (outputStream != null) {
//						outputStream.close();
//						outputStream2.close();
//					}
//				}
				UploadHelper.savePartIntoPath(part, path);
				UploadHelper.savePartIntoPath(part2, path2);

				// call service to update the path in DB by id
				song.setSongId(id);
				//String srcPath = "/Aoide/files/song_file/" + newSongFilename;
				String srcPath = srcRoot + newSongFilename;
				song.setSongFile(srcPath);
				System.out.println("音檔DBsrcPath: " + srcPath);

				// String srcPath2 = "/Aoide/files/song_cover_files/" + newCoverFilename;
				String srcPath2 = srcRoot2 + newCoverFilename;
				song.setCoverFile(srcPath2);
				System.out.println("圖檔DBsrcPath: " + srcPath2);

				service.updatePath(song);
				// call service to check the song in DB by id
				song = service.checkUpload(id);

				// go to checkUploadResult.jsp
				request.getSession().setAttribute("song", song);
				response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/UploadSongSuccess.jsp");
				return;
			}else{
				song.setSongFile("tempPath");
				song.setCoverFile("/Aoide/files/song_cover_files/default.jpg");
				song.setName(name);
				song.setSinger(singer);
				song.setSongType(songType);
				song.setSongLanguage(songLanguage);
				//改會員時看這裡
				song.setMemberId(1);
				//改會員時看這裡
				song.setIntroductionFile(introductionFile);
				song.setLyricsFile(lyricsFile);
				song.setUpdateDate(updateDate);

				int id = service.insertUploadSong(song);
				
				//song
				ServletContext context = request.getServletContext();
				Properties paths = (Properties) context.getAttribute("paths");
				String folderPath = paths.getProperty("songFolderPath");
				String srcRoot = paths.getProperty("songFolderPath");
				
				// make file name and path for storage
				String newSongFilename = "Songid" + id + fileNameExtension;
				//String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_file/" + newSongFilename;
				String path = folderPath + newSongFilename;
				System.out.println("音檔path: " + path);

				UploadHelper.savePartIntoPath(part, path);

				// call service to update the path in DB by id
				song.setSongId(id);
				//String srcPath = "/Aoide/files/song_file/" + newSongFilename;
				String srcPath = srcRoot + newSongFilename;
				song.setSongFile(srcPath);
				System.out.println("音檔DBsrcPath: " + srcPath);

				service.updatePath(song);
				// call service to check the song in DB by id
				song = service.checkUpload(id);

				// go to checkUploadResult.jsp
				request.getSession().setAttribute("song", song);
				response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/UploadSongSuccess.jsp");
				return;
			}
		}else{
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/views/member/_16_ManageSong.view/UploadSong.jsp").forward(request, response);
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
