package com.aoide.member._18_Donation.model;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.JdbcCashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.member.JdbcMemberDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public class DonationService {
	
	CashRecordDAO cashRecordDAO = new JdbcCashRecordDAO();
	MemberDAO memberDAO = new JdbcMemberDAO(new ConnectionBean().getConnection());

	public Integer insertNewCashRecord(CashRecordVO new_CashRecordVO) {
		
		return cashRecordDAO.insert(new_CashRecordVO);
		
	}

	public CashRecordVO getCashRecordById(Integer insert_id) {
		
		return cashRecordDAO.findByPrimaryKey(insert_id);
		
		
		
	}

	public String getAccountById(String recipient_id) {
		
		return memberDAO.findByMemberId(Integer.valueOf(recipient_id)).getAccount();
	}

}
