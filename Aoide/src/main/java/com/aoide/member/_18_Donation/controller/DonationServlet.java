package com.aoide.member._18_Donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._18_Donation.model.DonationService;


@WebServlet("/DonationServlet.member")
public class DonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從JSP來的值，為贊助者ID
		//Integer sponsor_id = 1;
		//從SESSION來的值，為被贊助者ID
		Integer recipient_id = 2;
		//從JSP來的值，贊助金額
		checkCash_volume(request.getParameter("cash_volume"));
		Integer cash_volume =  Integer.valueOf(request.getParameter("cash_volume"));
		//TYPE 贊助時為1
		Integer type = 1;
		
		//從SESSION獲取MemberVO物件;
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		Integer sponsor_id = memberVO.getMemberId();
		
		
		//製作一個新的VO物件
		CashRecordVO new_CashRecordVO = new CashRecordVO();
		//將贊助者ID、被贊助者ID、贊助金額、TYPE加入新的VO物件
		new_CashRecordVO.setSponsorId(sponsor_id);
		new_CashRecordVO.setRecipientId(recipient_id);
		new_CashRecordVO.setCashVolume(cash_volume);
		new_CashRecordVO.setType(type);
		
		Integer insert_id = new DonationService().insertNewCashRecord(new_CashRecordVO);
		System.out.println("此次交易紀錄的ID:"+insert_id);
		
		CashRecordVO cashRecordVO =  new DonationService().getCashRecordById(insert_id);
		request.getSession().setAttribute("cashRecordVO", cashRecordVO);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_18_Donation.view/ShowDonationRecord.jsp");
		
		System.out.println(cashRecordVO.getCashRecordId());
		
	}

	
	private void checkCash_volume(String cash_volume) {
		
		String re = "/^[0-9]+$/";
		if (re.matches(cash_volume)){
			System.out.println("符合驗證");
		}else{
			System.out.println("符合失敗");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
