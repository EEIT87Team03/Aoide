package com.aoide.manager._25_EditAdds.controller;

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
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.ad.AdVO;
import com.aoide.manager._25_EditAdds.model.AdService;

@WebServlet("/InsertAdds")
@MultipartConfig(location = "C:\\Aoide", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class InsertAdds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// upload limit in Tomcat
		// http://stackoverflow.com/questions/2947683/httprequest-maximum-allowable-size-in-tomcat
		// reference https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
		request.setCharacterEncoding("UTF-8");
		// 前端抓值
		// fileNameExtension 文件擴展名
		final Part part = request.getPart("AdImage");
		final String coverFilename = getFileName(part).trim();
		int index = coverFilename.lastIndexOf('.');
		String fileNameExtension = coverFilename.substring(index); // get.jpg
		System.out.println("圖檔：" + fileNameExtension);

		OutputStream outputStream = null;
		InputStream inputStream = null;

		AdService service = new AdService();

		AdVO adVO = new AdVO();
		adVO.setAdImg("tempPath");

		int id = service.insert(adVO);

		String newSongFilename = "Songid" + id + fileNameExtension;
		String path = "C:/Aoide/repository/Aoide/src/main/webapp/files/ad_img_files/"
				+ newSongFilename;
		System.out.println("圖檔path: " + path);

		// try to save upload in given path
		try {
			inputStream = part.getInputStream();// get file inputSteam
			outputStream = new FileOutputStream(new File(path));

			// FileOutputStream to write inputStrem into the file
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
				// inputStream2.close();
			}
			if (outputStream != null) {
				outputStream.close();
				// outputStream2.close();
			}
		}

		adVO.setSongId(id);
		String srcPath = "/Aoide/files/files/ad_img_files" + newSongFilename;
		adVO.setAdImg(srcPath);
		System.out.println("圖檔DBsrcPath: " + srcPath);

		service.update(adVO);
		// call service to check the song in DB by id
		adVO = service.findByPrimaryKey(id);

		// go to checkUploadResult.jsp
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
