


















package com.aoide.springTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.springTest.dataBaseManipulationObjects.tokenRecord.JdbcTokenRecordDAO;
import com.aoide.springTest.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;
import com.aoide.springTest.modol.UseTockenService;


@WebServlet("/ListTockenRecordServlet")
public class ListTockenRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Fields
	WebApplicationContext context = null;
	
	
	// Methods
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// call service
		UseTockenService service = (UseTockenService) context.getBean("useTockenService");
		
		 String specificToken = service.getClass().getName() + '@' + Integer.toHexString(service.hashCode());
		 System.out.println("specificToken: " + specificToken);
		
		TokenRecordVO tokenRecord = service.findTokenRecordById(1);
		System.out.println("TokenRecordId: " + tokenRecord.getTokenRecordId());
		System.out.println("Date: " + tokenRecord.getDate());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
