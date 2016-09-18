package com.aoide.member._19_DepositTocken.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

@WebServlet("/TurnToInsertCreditCardPageServlet.member")
public class TurnToInsertCreditCardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 從SESSION獲取MemberVO物件並取得贊助者ID;
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		Integer sponsor_id = memberVO.getMemberId();
		// 儲值時recipient_id=0;為官方帳號
		Integer recipient_id = 0;
		// 從JSP來的值，儲值金額
		String cash_volume = request.getParameter("cash_volume");

		if (!Validator.isNumbers(cash_volume)) {
			String cash_volumeError = "請輸入一個正確的數字";
			request.getSession().setAttribute("cash_volumeError", cash_volumeError);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_19_DepositToken.view/StartDepositTokenTemplate.jsp");

		} else {
			
			request.getSession().setAttribute("cash_volume", cash_volume);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_19_DepositToken.view/InsertCreditCardPageTemplate.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
