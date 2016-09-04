package com.aoide.member._18_2_CheckCashRecord.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.member._18_2_CheckCashRecord.model.CheckCashRecordService;


@WebServlet("/CheckCashRecordServlet")
public class CheckCashRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//從JSP來的值:查詢者的ID
		Integer id = 2;
		
		//以查詢者的ID對資料庫的cash_record進行查詢
		//只要其ID與 sponsor_id 或 recipiemt_id 相符即回傳資料
		List<CashRecordVO> cashRecordList = new CheckCashRecordService().getAllCashRecord(id);
		
		for(CashRecordVO cashRecordVO : cashRecordList){
			
			System.out.println(cashRecordVO.getCashRecordId());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
