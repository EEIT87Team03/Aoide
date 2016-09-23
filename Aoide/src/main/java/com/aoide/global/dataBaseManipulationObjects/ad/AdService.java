package com.aoide.global.dataBaseManipulationObjects.ad;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ad.AdDAO;
import com.aoide.global.dataBaseManipulationObjects.ad.AdVO;
import com.aoide.global.dataBaseManipulationObjects.ad.JdbcAdDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;

public class AdService {


	// Constructors
	private AdDAO dao = null;
	

	public AdService() {
		this.dao = new JdbcAdDAO();
	}
	
	public List<AdVO> getAllAdVO() {
		List<AdVO> AdList = new ArrayList();
		for (AdVO aAd : dao.getAll()) {
			//${aBullet.bulletId}  
			AdList.add(aAd);

		}// end for
		return AdList;
	}// end getUnreplySuggestions()
	
	public Integer insert(AdVO adVO) 
	{
		return dao.insert(adVO);
	}

	public void update(AdVO adVO) {
		dao.update(adVO);
	}

	public AdVO findByPrimaryKey(Integer song_id) {
		return dao.findByPrimaryKey(song_id);
	}
}
// end class