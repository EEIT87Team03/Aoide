package com.aoide.member._16_ManageSong.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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

		final Part part = request.getPart("songFile");
		final String songFilename = getFileName(part).trim();
		int index = songFilename.lastIndexOf('.');
		String fileNameExtension = songFilename.substring(index); // get .mp3
		System.out.println("音檔：" + fileNameExtension);

		// final Part part2 = request.getPart("coverFile");
		// final String coverFilename = getFileName(part2).trim();
		// int index2 = coverFilename.lastIndexOf('.');
		// String fileNameExtension2 = coverFilename.substring(index2); // get.jpg
		// System.out.println("圖檔：" + fileNameExtension2);

		OutputStream outputStream = null;
		InputStream inputStream = null;
		// OutputStream outputStream2 = null;
		// InputStream inputStream2 = null;

		UploadSongService service = new UploadSongService();

		// call service to name and tempPath into DB and get the id of the song
		String name = request.getParameter("name");
		String songType = request.getParameter("songType");
		String songLanguage = request.getParameter("songLanguage");
		String introductionFile = request.getParameter("introductionFile");
		String lyricsFile = request.getParameter("lyricsFile");
		Date updateDate = new Date(System.currentTimeMillis());

		SongVO songVO = new SongVO();

		songVO.setSongFile("tempPath");
		songVO.setCoverFile("/Aoide/files/song_cover_files/default.jpg");
		songVO.setName(name);
		songVO.setSongType(songType);
		songVO.setSongLanguage(songLanguage);
		songVO.setMemberId(1);
		songVO.setIntroductionFile(introductionFile);
		songVO.setLyricsFile(lyricsFile);
		songVO.setUpdateDate(updateDate);

		int id = service.insertUploadSong(songVO);
		// make file name and path for storage
		String newSongFilename = "Songid" + id + fileNameExtension;
		String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/song_file/" + newSongFilename;
		System.out.println("音檔path: " + path);

		// String newCoverFilename = "Songid" + id + fileNameExtension2;
		// String path2 ="C:/Aoide/repository/Aoide/src/main/webapp/files/song_cover_files/" + newCoverFilename;
		// System.out.println("圖檔path: " + path2);

		// try to save upload in given path
		try {
			inputStream = part.getInputStream();// get file inputSteam
			outputStream = new FileOutputStream(new File(path)); // get FileOutputStream to write inputStrem into the file
			// inputStream2 = part2.getInputStream();// get file inputSteam
			// outputStream2 = new FileOutputStream(new File(path2)); // get FileOutputStream to write inputStrem into the file
			// write into file
			byte[] bytes = new byte[1024];
			int len;
			while ((len = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, len);
			}
			// while ( (len = inputStream2.read(bytes)) != -1) {
			// outputStream2.write(bytes, 0, len);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
				// inputStream2.close();
			}
			if (outputStream != null) {
				outputStream.close();
				// outputStream2.close();
			}
		}

		// call service to update the path in DB by id
		songVO.setSongId(id);
		String srcPath = "/Aoide/files/song_file/" + newSongFilename;
		songVO.setSongFile(srcPath);
		System.out.println("音檔DBsrcPath: " + srcPath);

		// String srcPath2 = "/Aoide/files/song_cover_files/" +
		// newCoverFilename;
		// songVO.setCoverFile(srcPath2);
		// System.out.println("圖檔DBsrcPath: " + srcPath2);

		service.updatePath(songVO);
		// call service to check the song in DB by id
		songVO = service.checkUpload(id);

		// go to checkUploadResult.jsp
		request.getSession().setAttribute("songVO", songVO);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_16_ManageSong.view/UploadSongSuccess.jsp");
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
