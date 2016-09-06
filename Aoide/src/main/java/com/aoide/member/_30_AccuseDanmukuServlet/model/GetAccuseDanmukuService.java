package com.aoide.member._30_AccuseDanmukuServlet.model;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.JdbcAccusementDanmukuDAO;

public class GetAccuseDanmukuService {
	
	AccusementDanmukuDAO accusementDanmukuDAO = new JdbcAccusementDanmukuDAO();

	public AccusementDanmukuVO GetAccusementDanmukuByPK(Integer accusement_danmuku_id) {
		
		return accusementDanmukuDAO.findByPrimaryKey(accusement_danmuku_id);
		
	}

}
