package com.aoide.manager._28_MangeAccusement.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.JdbcAccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.member.JdbcMemberDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public class MangeAccusementService {
	
	AccusementDanmukuDAO accusementDanmukuDAO = new JdbcAccusementDanmukuDAO();
	MemberDAO memberDAO = new JdbcMemberDAO(new ConnectionBean().getConnection());

	public List<AccusementDanmukuVO> getAllAccusement() {
		
		return accusementDanmukuDAO.getAll();
		
	}

	public String getAccuseName(Integer accuseId) {
		
		return memberDAO.findByMemberId(accuseId).getAccount();
	}

	public String getAccusedName(Integer accusedId) {
		
		return memberDAO.findByMemberId(accusedId).getAccount();
	}

}
