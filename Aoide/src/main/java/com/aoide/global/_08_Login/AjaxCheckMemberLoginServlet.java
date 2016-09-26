package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/AjaxCheckMemberLoginServlet")
public class AjaxCheckMemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		String isLogin = null;
		if ( member != null ) {
			isLogin = "true";
		} else {
			isLogin = "false";
		}
		
		// generate json obj
		JSONObject loginJson = new JSONObject();
		loginJson.put("isLogin", isLogin);
		
		// generate json response
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(loginJson.toJSONString());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
