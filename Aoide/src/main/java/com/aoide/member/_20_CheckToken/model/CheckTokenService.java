package com.aoide.member._20_CheckToken.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.tokenRecord.JdbcTokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class CheckTokenService {
	
	TokenRecordDAO tokenrecordDAO = new JdbcTokenRecordDAO();

	public List<TokenRecordVO> getAllTokenRecordByMemberId() {
		
		List<TokenRecordVO> tokenrecordVOList= new ArrayList();
		
		
		return null;
	}


}
