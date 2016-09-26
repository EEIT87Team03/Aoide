package com.aoide.member._18_Donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

@WebServlet("/TurnToInsertCreditCardPageServletD.member")
public class TurnToInsertCreditCardPageServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 從JSP來的值，儲值金額
		String cash_volume = request.getParameter("cash_volume");

		if (!Validator.isNumbers(cash_volume)) {
			String cash_volumeError = "請輸入一個正確的數字";
			request.getSession().setAttribute("cash_volumeError", cash_volumeError);

//			String contextPath = request.getContextPath();
//			response.sendRedirect(contextPath + "/views/member/_18_Donation.view/StartDonationPageTemplate.jsp");
			request.getRequestDispatcher("/views/member/_18_Donation.view/StartDonationPageTemplate.jsp").forward(request, response);
			return;

		} else {
			
			request.getSession().setAttribute("cash_volume", cash_volume);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_18_Donation.view/InsertCreditCardPageTemplateD.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
