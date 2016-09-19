package com.aoide.springTest.modol;

import com.aoide.springTest.dataBaseManipulationObjects.tokenRecord.JdbcTokenRecordDAO;
import com.aoide.springTest.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class UseTockenService {
	// Fields
	private JdbcTokenRecordDAO dao =null;

	// Constructors
	public UseTockenService() {

	}
	public UseTockenService(JdbcTokenRecordDAO dao) {
		this.dao = dao;
	}
	
	// Methods
	public TokenRecordVO findTokenRecordById(Integer id){
		return dao.findByPrimaryKey(id);
	}
}
