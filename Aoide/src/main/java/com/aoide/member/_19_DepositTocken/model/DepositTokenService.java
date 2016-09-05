package com.aoide.member._19_DepositTocken.model;

import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.CashRecordVO;
import com.aoide.global.dataBaseManipulationObjects.cashRecord.JdbcCashRecordDAO;

public class DepositTokenService {
	
	CashRecordDAO cashRecordDAO = new JdbcCashRecordDAO();

	public Integer insertNewCashRecord(CashRecordVO new_CashRecordVO) {
		
		return cashRecordDAO.insert(new_CashRecordVO);
	}

	public CashRecordVO getCashRecordById(Integer insert_id) {
		
		return cashRecordDAO.findByPrimaryKey(insert_id);
	}

}
