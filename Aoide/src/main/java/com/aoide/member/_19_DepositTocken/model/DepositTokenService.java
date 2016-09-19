package com.aoide.member._19_DepositTocken.model;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.JdbcCashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class DepositTokenService {
	
	CashRecordDAO cashRecordDAO = new JdbcCashRecordDAO();
	MemberService memberService = new MemberService();

	public Integer insertNewCashRecord(CashRecordVO new_CashRecordVO) {
		
		return cashRecordDAO.insert(new_CashRecordVO);
	}

	public CashRecordVO getCashRecordById(Integer insert_id) {
		
		return cashRecordDAO.findByPrimaryKey(insert_id);
	}

	public void updateMemberVO(MemberVO memberVO) {
		
		memberService.updateMemberData(memberVO);
		
	}

}
