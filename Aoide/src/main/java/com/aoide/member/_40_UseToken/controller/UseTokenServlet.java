package com.aoide.member._40_UseToken.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._40_UseToken.model.UseTokenService;


@WebServlet("/UseTokenServlet.member")
public class UseTokenServlet extends HttpServlet {
	// Fields
	WebApplicationContext context = null;
	private static final long serialVersionUID = 1L;
	
	// Methods
	
	
	
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = null;
		Integer tokenVolume = 61570; // Integer tokenVolume = request.getParameter("tokenVolum");
		
		
		// get member and token volume
		member = (MemberVO) session.getAttribute("member");
		
		System.out.println("TokenTotal Before use: " + member.getTokenTotal());
		
		UseTokenService service = new UseTokenService((DataSource) context.getBean("dataSource"));

		service.useToken(member, tokenVolume);

		MemberVO member2 = new MemberService().getMemberBean(member.getAccount());
		System.out.println("TokenTotal After use: " + member2.getTokenTotal());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
