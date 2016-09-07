package com.aoide.global._00_TestUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

/**
 * Servlet implementation class TestPretendLoginFilter
 */
@WebServlet("/TestPretendLoginFilter.member")
public class TestPretendLoginFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		System.out.println(member.getMemberId());
		System.out.println(member.getAccount());
		System.out.println(member.getTokenTotal());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
