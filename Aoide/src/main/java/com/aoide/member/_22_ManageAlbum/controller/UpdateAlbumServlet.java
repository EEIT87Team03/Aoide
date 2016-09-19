package com.aoide.member._22_ManageAlbum.controller;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.IOException;
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
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/UpdateAlbumServlet")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024,
							 maxFileSize = 1024 * 1024 * 5 * 5,//限制25MB
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
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		String fileNameExtension = null;
		String contextPath = request.getContextPath();
		
		final Part part = request.getPart("coverFile");
		if(Validator.isEmptyPart(part)){
			
		}else{
			if(!Validator.isImage(part)){
				errorMsg.put("emptyPartMsg", "只能上傳圖片檔案");
			}else{
				if(!Validator.isPartOverSize(part, 5242880)){
					errorMsg.put("emptyPartMsg", "圖片檔案上傳請勿超過5MB");
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
		
		service = new ListAlbumService();
		
		String name = request.getParameter("name").trim();
		String artist = request.getParameter("artist").trim();
		String introductionFile = request.getParameter("introductionFile").trim();
		
		if (!Validator.isValidString(name)){
			errorMsg.put("emptyNameMsg", "請輸入專輯名稱");
		}else{
			enteredText.put("name", name);
			enteredText.put("introductionFile", introductionFile);
		}
		
		if(!Validator.isValidString(artist)){
			errorMsg.put("emptyArtistMsg", "請輸入演出者");
		}else{
			enteredText.put("artist", artist);
			enteredText.put("introductionFile", introductionFile);
		}
		
		if(errorMsg.isEmpty()){
			session = request.getSession();
			album = (AlbumVO) session.getAttribute("album");
			session.removeAttribute("album");
			
			ServletContext context = request.getServletContext();
			Properties paths = (Properties) context.getAttribute("paths");
			String folderPath = paths.getProperty("albumFolderPath");
			String srcRoot = paths.getProperty("albumFolderPath");
			if(!Validator.isEmptyPart(part)){
				int id = album.getAlbumId();
				String newCoverFilename = "Albumid" + id + fileNameExtension;
				//String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/album_cover_files/" + newCoverFilename;
				String path = folderPath + newCoverFilename;
				System.out.println("圖檔path: " + path);
				//String srcPath = "/Aoide/files/album_cover_files/" + newCoverFilename;
				String srcPath = srcRoot + newCoverFilename;
				System.out.println("圖檔DBsrcPath: " + srcPath);
				
				album.setCoverFilePath(srcPath);
				album.setName(name);
				album.setArtist(artist);
				album.setIntroductionFilePath(introductionFile);
				
				System.out.println("coverFile：" + album.getCoverFilePath());
				System.out.println("name：" + album.getName());
				System.out.println("artist：" + album.getArtist());
				System.out.println("introductionFile：" + album.getIntroductionFilePath());
				
				// update album
				service.updateAlbum(album);	
				
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
				// get the song from database to check the result of update
				updateAlbum = service.getAlbumById(album.getAlbumId());
				List<SongVO> songS = (List<SongVO>) session.getAttribute("mySongList");
				session.setAttribute("mySongList", songS);
				session.setAttribute("updateAlbum", updateAlbum);
				response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/EditAlbumSuccess.jsp");
				return;
			}else{
				int id = album.getAlbumId();
				
				album.setName(name);
				album.setArtist(artist);
				album.setIntroductionFilePath(introductionFile);
				
				System.out.println("name：" + album.getName());
				System.out.println("artist：" + album.getArtist());
				System.out.println("introductionFile：" + album.getIntroductionFilePath());
				
				// update album
				service.updateAlbum(album);	
				
				// get the song from database to check the result of update
				updateAlbum = service.getAlbumById(album.getAlbumId());
				List<SongVO> songS = (List<SongVO>) session.getAttribute("mySongList");
				session.setAttribute("mySongList", songS);
				session.setAttribute("updateAlbum", updateAlbum);
				response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/EditAlbumSuccess.jsp");
				return;
			}
		}else{
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/views/member/_22_ManageAlbum.view/EditAlbum.jsp").forward(request, response);
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
