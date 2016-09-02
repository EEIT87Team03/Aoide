package com.aoide.member._20_CheckToken.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.tokenRecord.JdbcTokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class CheckTokenService {
	
	TokenRecordDAO tokenRecordDAO = new JdbcTokenRecordDAO();

	public List<TokenRecordVO> getAllTokenRecordByMemberId(Integer recipientId) {
		
		List<TokenRecordVO> tokenRecordVoList= new ArrayList();
		
		for(TokenRecordVO tokenRecordVO : tokenRecordDAO.findByRecipientId(recipientId)){
			
			tokenRecordVoList.add(tokenRecordVO);
		}
		
		return tokenRecordVoList;
	}


}
