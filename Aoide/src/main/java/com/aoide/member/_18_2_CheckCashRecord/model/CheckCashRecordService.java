package com.aoide.member._18_2_CheckCashRecord.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.JdbcCashRecordDAO;

public class CheckCashRecordService {
	
	CashRecordDAO cashRecordDAO = new JdbcCashRecordDAO();

	public List<CashRecordVO> getAllCashRecord(Integer id) {
		
		
		return cashRecordDAO.findById(id);
	}

}
