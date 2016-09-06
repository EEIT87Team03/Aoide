package com.aoide.member._30_AccuseDanmuku.model;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.JdbcAccusementDanmukuDAO;

public class SaveAccuseDanmukuService {
	
	AccusementDanmukuDAO accusementDanmukuDAO = new JdbcAccusementDanmukuDAO();

	public Integer InsertNewAccusementDanmuku(AccusementDanmukuVO accusementDanmukuVO) {
		
		Integer accusement_danmuku_id = accusementDanmukuDAO.insert(accusementDanmukuVO);
		
		// TODO Auto-generated method stub
		return accusement_danmuku_id;
	}

}
