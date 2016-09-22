package com.aoide.manager._25_EditAdds.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ad.AdDAO;
import com.aoide.global.dataBaseManipulationObjects.ad.AdVO;
import com.aoide.global.dataBaseManipulationObjects.ad.JdbcAdDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;

public class AdService {

	// Fields
	AdDAO AdDAO = new JdbcAdDAO();

	// Constructors
	private JdbcAdDAO dao = null;
	
	public List<AdVO> getUnreplyAdVO() {
		List<AdVO> AdList = new ArrayList();
		for (AdVO aAd : AdDAO.getAll()) {
			//${aBullet.bulletId}  
			AdList.add(aAd);

		}// end for
		return AdList;
	}// end getUnreplySuggestions()

	public AdService() {
		this.dao = new JdbcAdDAO();
	}

	public Integer insert(AdVO adVO) {
		return AdDAO.insert(adVO);
	}

	public void update(AdVO adVO) {
		dao.update(adVO);
	}

	public AdVO findByPrimaryKey(Integer song_id) {
		return dao.findByPrimaryKey(song_id);
	}
}
// end class