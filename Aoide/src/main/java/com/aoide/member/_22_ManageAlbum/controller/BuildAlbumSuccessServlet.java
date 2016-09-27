package com.aoide.member._22_ManageAlbum.controller;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;
import com.aoide.member._22_ManageAlbum.model.BuildAlbumService;

@WebServlet("/BuildAlbumSuccessServlet.member")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
										 maxFileSize = 1024 * 1024	* 5 * 5,//限制25MB
										 maxRequestSize = 1024 * 1024 * 5 * 5)
public class BuildAlbumSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		String fileNameExtension = null;
		String contextPath = request.getContextPath();
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		Integer memberId = member.getMemberId();

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
//					String fileNameExtension = coverFilename.substring(index); // get.jpg
					fileNameExtension = UploadHelper.getFileExtention(part);
					System.out.println("圖檔：" + fileNameExtension);
				}
			}
		}
		
//		OutputStream outputStream = null;
//		InputStream inputStream = null;

		BuildAlbumService service = new BuildAlbumService();

		// call service to name and tempPath into DB and get the id of the album
		String introductionFile = request.getParameter("introductionFile");
		
		String name = request.getParameter("name");
		if(!Validator.isValidString(name)){
			errorMsg.put("emptyNameMsg", "*請輸入專輯名稱");
		}else{
			enteredText.put("name", name);
			enteredText.put("introductionFile", introductionFile);
		}
		
		String artist = request.getParameter("artist");
		if(!Validator.isValidString(artist)){
			errorMsg.put("emptyArtistMsg", "*請輸入演出者");
		}else{
			enteredText.put("artist", artist);
			enteredText.put("introductionFile", introductionFile);
		}

		if(errorMsg.isEmpty()){
			Date updateDate = new Date(System.currentTimeMillis());
			AlbumVO album = new AlbumVO();
			if(!Validator.isEmptyPart(part)){
				//改會員時看這裡
				album.setMemberId(memberId);
				//改會員時看這裡
				album.setCoverFilePath("tempPath");
				album.setName(name);
				album.setArtist(artist);
				album.setIntroductionFilePath(introductionFile);
				album.setUpdateDate(updateDate);

				int id = service.insertBuildAlbum(album);
				
				//album
				ServletContext context = request.getServletContext();
				Properties paths = (Properties) context.getAttribute("paths");
				String folderPath = paths.getProperty("albumFolderPath");
				String srcRoot = paths.getProperty("albumSrcRoot");
				
				// make file name and path for storage
				String newCoverFilename = "Albumid" + id + fileNameExtension;
				//String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/album_cover_files/" + newCoverFilename;
				String path = folderPath + newCoverFilename;
				System.out.println("圖檔path: " + path);

				// try to save upload in given path
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

				// call service to update the path in DB by id
				album.setAlbumId(id);
				//String srcPath = "/Aoide/files/album_cover_files/" + newCoverFilename;
				String srcPath = srcRoot + newCoverFilename;
				album.setCoverFilePath(srcPath);
				System.out.println("圖檔DBsrcPath: " + srcPath);

				service.updatePath(album);
				// call service to check the album in DB by id
				album = service.checkUpload(id);
				
				String[] songId = request.getParameterValues("check");
				HttpSession session = request.getSession();
				List<SongVO> songS = (List<SongVO>) session.getAttribute("mySongList");
				List<SongVO> upSongS = new ArrayList();
				ListSongService lss = new ListSongService();
				for(String s : songId){
					int i = Integer.valueOf(s).intValue();
					for(SongVO song : songS){
						if(i == song.getSongId()){
							System.out.println("songId：" + song.getSongId() + "，更新albumId：" + id);
							song.setAlbumId(id);
							lss.updateSong(song);
							upSongS.add(song);
						}
					}
				}
				// go to checkUploadResult.jsp
				request.getSession().setAttribute("upSongS", upSongS);
				request.getSession().setAttribute("album", album);
				response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/BuildAlbumSuccess.jsp");
				return;
			}else{
				//改會員時看這裡
				album.setMemberId(memberId);
				//改會員時看這裡
				album.setCoverFilePath("/Aoide/files/song_cover_files/default.jpg");
				album.setName(name);
				album.setArtist(artist);
				album.setIntroductionFilePath(introductionFile);
				album.setUpdateDate(updateDate);

				int id = service.insertBuildAlbum(album);
				
				// call service to update the path in DB by id
				album.setAlbumId(id);
				service.updatePath(album);
				// call service to check the album in DB by id
				album = service.checkUpload(id);
				
				String[] songId = request.getParameterValues("check");
				HttpSession session = request.getSession();
				List<SongVO> songS = (List<SongVO>) session.getAttribute("mySongList");
				List<SongVO> upSongS = new ArrayList();
				ListSongService lss = new ListSongService();
				for(String s : songId){
					int i = Integer.valueOf(s).intValue();
					for(SongVO song : songS){
						if(i == song.getSongId()){
							System.out.println("songId：" + song.getSongId() + "，更新albumId：" + id);
							song.setAlbumId(id);
							lss.updateSong(song);
							upSongS.add(song);
						}
					}
				}
				// go to checkUploadResult.jsp
				request.getSession().setAttribute("upSongS", upSongS);
				request.getSession().setAttribute("album", album);
				response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/BuildAlbumSuccess.jsp");
				return;
			}
		}else{
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/views/member/_22_ManageAlbum.view/BuildAlbum.jsp").forward(request, response);
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
