package com.aoide.manager._28_MangeAccusement.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.JdbcAccusementDanmukuDAO;

public class MangeAccusementService {
	
	AccusementDanmukuDAO accusementDanmukuDAO = new JdbcAccusementDanmukuDAO();

	public List<AccusementDanmukuVO> getAllAccusement() {
		
		return accusementDanmukuDAO.getAll();
		
	}

}
