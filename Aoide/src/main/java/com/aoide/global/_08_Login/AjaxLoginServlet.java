package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/AjaxLoginServlet")
public class AjaxLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get account, password
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter( "account" ).trim();
		String password = request.getParameter( "password" ).trim();
		
		// call service get member bean
		MemberService ms = new MemberService();
		MemberVO memberBean = ms.getMemberBean( account );
		
		// generate respond content and put member in session
		String loginState = null;
		if( (memberBean != null) && password.equals( memberBean.getPassword()) ){
			request.getSession().setAttribute( "member", memberBean );
			loginState = "loginSuccess";
		}else{
			loginState = "loginFail";
		}
		
		// generate respond
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().write(loginState);
		
	}

}
