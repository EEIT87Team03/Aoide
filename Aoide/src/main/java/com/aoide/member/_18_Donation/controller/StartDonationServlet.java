package com.aoide.member._18_Donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.member._18_Donation.model.DonationService;


@WebServlet("/StartDonationServlet")
public class StartDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String recipient_id = "5";
		String recipient_id = request.getParameter("recipient_id");
		String recipient_Account = new DonationService().getAccountById(recipient_id);
		
		request.getSession().setAttribute("recipient_Account", recipient_Account);
		
		
		
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_18_Donation.view/StartDonationPageTemplate.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
