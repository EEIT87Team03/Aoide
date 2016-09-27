package com.aoide.member._19_DepositTocken.model;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.JdbcCashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.JdbcTokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class DepositTokenService {
	
	CashRecordDAO cashRecordDAO = new JdbcCashRecordDAO();
	TokenRecordDAO tokenRecordDAO = new JdbcTokenRecordDAO();
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

	public void insertNewTokenRecord(TokenRecordVO new_TokenRecordVO) {
		
		tokenRecordDAO.insert(new_TokenRecordVO);
		
	}

}
