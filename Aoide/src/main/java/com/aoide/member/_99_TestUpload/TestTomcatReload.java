package com.aoide.member._99_TestUpload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestTomcatReload")
public class TestTomcatReload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start reloading");
		response.sendRedirect("http://localhost:8080/manager/reload?path=/Aoide");
		System.out.println("complet reloading");
		
	}

}
