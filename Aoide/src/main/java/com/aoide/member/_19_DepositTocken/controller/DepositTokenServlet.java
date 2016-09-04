package com.aoide.member._19_DepositTocken.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.member._18_Donation.model.DonationService;
import com.aoide.member._19_DepositTocken.model.DepositTokenService;


@WebServlet("/DepositToken")
public class DepositTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從JSP來的值，為儲值者ID
		Integer sponsor_id = 1;
		//儲值時recipient_id=0;為官方帳號
		Integer recipient_id = 0;
		//從JSP來的值:儲值者儲值的金額
		Integer cash_volume = 3752;
		//經過商業邏輯所得到的值:儲值多少現金會獲得多少點數，暫定為1:1
		Integer token_volume = cash_volume;
		//TYPE 儲值時為0
		Integer type = 0;
		
		//製作一個新的VO物件
		CashRecordVO new_CashRecordVO = new CashRecordVO();
		//將贊助者ID、被贊助者ID、贊助金額、獲得點數、TYPE加入新的VO物件
		new_CashRecordVO.setSponsorId(sponsor_id);
		new_CashRecordVO.setRecipientId(recipient_id);
		new_CashRecordVO.setCashVolume(cash_volume);
		new_CashRecordVO.setTokenVolume(token_volume);
		new_CashRecordVO.setType(type);
		
		Integer insert_id = new DepositTokenService().insertNewCashRecord(new_CashRecordVO);
		System.out.println("此次交易紀錄的ID:"+insert_id);
		
		CashRecordVO cashRecordVO =  new DepositTokenService().getCashRecordById(insert_id);
		request.getSession().setAttribute("cashRecordVO", cashRecordVO);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_19_DepositToken.view/ShowDepositRecord.jsp");
		
		System.out.println(cashRecordVO.getCashRecordId());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
