package com.aoide.member._19_DepositTocken.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;
import com.aoide.member._18_Donation.model.DonationService;
import com.aoide.member._19_DepositTocken.model.DepositTokenService;

@WebServlet("/DepositToken.member")
public class DepositTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 從SESSION獲取MemberVO物件並取得贊助者ID;
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		Integer sponsor_id = memberVO.getMemberId();
		// 儲值時recipient_id=0;為官方帳號
		Integer recipient_id = 0;
		// 從JSP來的值，儲值金額
		String cash_volume = (String) request.getSession().getAttribute("cash_volume");

		if (!Validator.isNumbers(cash_volume)) {
			String cash_volumeError = "請輸入一個正確的數字";
			request.getSession().setAttribute("cash_volumeError", cash_volumeError);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_19_DepositToken.view/StartDepositTokenTemplate.jsp");

		} else {
			Integer int_cash_volume = Integer.valueOf(cash_volume);

			// 經過商業邏輯所得到的值:儲值多少現金會獲得多少點數，暫定為1:1
			Integer token_volume = int_cash_volume;
			// TYPE 儲值時為0
			Integer type = 0;

			// 製作一個新的VO物件
			CashRecordVO new_CashRecordVO = new CashRecordVO();
			// 將贊助者ID、被贊助者ID、贊助金額、獲得點數、TYPE加入新的VO物件
			new_CashRecordVO.setSponsorId(sponsor_id);
			new_CashRecordVO.setRecipientId(recipient_id);
			new_CashRecordVO.setCashVolume(int_cash_volume);
			new_CashRecordVO.setTokenVolume(token_volume);
			new_CashRecordVO.setType(type);
			
			//呼叫Service新增一筆CashRecord並獲取回傳的ID
			Integer insert_id = new DepositTokenService().insertNewCashRecord(new_CashRecordVO);
			/*System.out.println("此次交易紀錄的ID:" + insert_id);*/
			
			//製作一個新的Token_RecordVO物件
			TokenRecordVO new_TokenRecordVO = new TokenRecordVO();
			// 將贊助者ID、被贊助者ID、贊助金額、獲得點數、TYPE加入新的VO物件
			
			//呼叫Service新增一筆
			
			
			//用回傳的ID查詢該筆紀錄
			CashRecordVO cashRecordVO = new DepositTokenService().getCashRecordById(insert_id);
			request.getSession().setAttribute("cashRecordVO", cashRecordVO);
			
			//將當前Session中的MemberVO物件的TokenTotal更新
			BigDecimal new_TokenTotal = memberVO.getTokenTotal().add(new BigDecimal(token_volume));
			memberVO.setTokenTotal(new_TokenTotal);
			System.out.println("Token:" + memberVO.getTokenTotal());
			
			new DepositTokenService().updateMemberVO(memberVO);
			request.getSession().setAttribute("member", memberVO);
			
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_19_DepositToken.view/ShowDepositRecordTemplate.jsp");

			/*System.out.println(cashRecordVO.getCashRecordId());*/
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
