package com.aoide.manager._25_EditAdds.controller;

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
import com.aoide.global.dataBaseManipulationObjects.ad.AdService;
import com.aoide.global.dataBaseManipulationObjects.ad.AdVO;

@WebServlet("/InsertAdds")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class InsertAdds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		final Part part = request.getPart("AdImage");
		final String coverFilename = getFileName(part).trim();
		int index = coverFilename.lastIndexOf('.');
		String fileNameExtension = coverFilename.substring(index); // get.jpg
		System.out.println("圖檔：" + fileNameExtension);

//		OutputStream outputStream = null;
//		InputStream inputStream = null;

		AdService service = new AdService();

		AdVO adVO = new AdVO();
		adVO.setAdImg("tempPath");

		int id = service.insert(adVO);

		String newSongFilename = "Songid" + id + fileNameExtension;

		/*-----------------get path form context---------------*/
		ServletContext context = request.getServletContext();
		Properties paths = (Properties) context.getAttribute("paths");
		String folderPath = paths.getProperty("adImgFolderPath");
		String srcRoot = paths.getProperty("adImgSrcRoot");
		/*-----------------------------------------------------*/

		String path = folderPath + newSongFilename;
		System.out.println("圖檔path: " + path);

		UploadHelper.savePartIntoPath(part, path);

		adVO.setSongId(id);
		String srcPath = srcRoot + newSongFilename;
		adVO.setAdImg(srcPath);
		System.out.println("圖檔DBsrcPath:" + srcPath);

		service.update(adVO);
		// call service to check the song in DB by id
		adVO = service.findByPrimaryKey(id);

		request.getSession().setAttribute("adVO", adVO);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath
				+ "/_25_EditAd.view/UploadEditAdDisplay.jsp");
	}
	
	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
