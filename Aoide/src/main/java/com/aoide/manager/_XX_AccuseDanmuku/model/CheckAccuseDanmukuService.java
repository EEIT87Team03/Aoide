package com.aoide.manager._XX_AccuseDanmuku.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.JdbcAccusementDanmukuDAO;

public class CheckAccuseDanmukuService {
	
	AccusementDanmukuDAO accusementDanmukuDAO = new JdbcAccusementDanmukuDAO();

	public List<AccusementDanmukuVO> getAllAccusement() {
		
		return null;
	}

}
