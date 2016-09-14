package com.aoide.member._22_ManageAlbum.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;
import com.aoide.member._22_ManageAlbum.model.BuildAlbumService;

@WebServlet("/BuildAlbumSuccessServlet")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
										 maxFileSize = 1024 * 1024	* 5,//限制5MB
										 maxRequestSize = 1024 * 1024 * 5 * 5)
public class BuildAlbumSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		final Part part = request.getPart("coverFile");
		final String coverFilename = getFileName(part).trim();
		int index = coverFilename.lastIndexOf('.');
		String fileNameExtension = coverFilename.substring(index); // get.jpg
		System.out.println("圖檔：" + fileNameExtension);

		OutputStream outputStream = null;
		InputStream inputStream = null;

		BuildAlbumService service = new BuildAlbumService();

		// call service to name and tempPath into DB and get the id of the album
		String name = request.getParameter("name");
		String artist = request.getParameter("artist");
		String introductionFile = request.getParameter("introductionFile");
		Date updateDate = new Date(System.currentTimeMillis());

		AlbumVO albumVO = new AlbumVO();
		
		albumVO.setMemberId(1);
		albumVO.setCoverFilePath("tempPath");
		albumVO.setName(name);
		albumVO.setArtist(artist);
		albumVO.setIntroductionFilePath(introductionFile);
		albumVO.setUpdateDate(updateDate);

		int id = service.insertBuildAlbum(albumVO);
		// make file name and path for storage
		String newCoverFilename = "Albumid" + id + fileNameExtension;
		String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/album_cover_files/" + newCoverFilename;
		System.out.println("圖檔path: " + path);

		// try to save upload in given path
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

		// call service to update the path in DB by id
		albumVO.setAlbumId(id);
		String srcPath = "/Aoide/files/album_cover_files/" + newCoverFilename;
		albumVO.setCoverFilePath(srcPath);
		System.out.println("圖檔DBsrcPath: " + srcPath);

		service.updatePath(albumVO);
		// call service to check the album in DB by id
		albumVO = service.checkUpload(id);

		// go to checkUploadResult.jsp
		request.getSession().setAttribute("albumVO", albumVO);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/BuildAlbumSuccess.jsp");
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
