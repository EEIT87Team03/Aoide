package com.aoide.manager._24_EditBullet.model;


import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;


public class BulletService {

	// Fields
	BulletDAO bulletDAO = new JdbcBulletDAO();

	// Constructors
	public BulletService() {
	}
	
	// Methods
	public List<BulletVO> getUnreplyBulletVO() {
		List<BulletVO> bulletList = new ArrayList();
		for (BulletVO aBullet : bulletDAO.getAll()) {
			//${aBullet.bulletId}  
			bulletList.add(aBullet);

		}// end for
		return bulletList;
	}// end getUnreplySuggestions()

	public void updateBullet(BulletVO bulletVO) {
		bulletDAO.update(bulletVO);
	}

	public BulletVO getBulletById(Integer bulletId) {
		return bulletDAO.findByPrimaryKey(bulletId);
	}
	
}// end class
