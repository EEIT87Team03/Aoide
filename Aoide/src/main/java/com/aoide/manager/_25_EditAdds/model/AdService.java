package com.aoide.manager._25_EditAdds.model;

import com.aoide.global.dataBaseManipulationObjects.ad.AdDAO;
import com.aoide.global.dataBaseManipulationObjects.ad.AdVO;
import com.aoide.global.dataBaseManipulationObjects.ad.JdbcAdDAO;

public class AdService {

	// Fields
	AdDAO adDAO = new JdbcAdDAO();

	// Constructors
	private JdbcAdDAO dao = null;

	public AdService() {
		this.dao = new JdbcAdDAO();
	}

	public Integer insert(AdVO adVO) {
		return adDAO.insert(adVO);
	}

	public void update(AdVO adVO) {
		dao.update(adVO);
	}

	public AdVO findByPrimaryKey(Integer song_id) {
		return dao.findByPrimaryKey(song_id);
	}
}
// end class