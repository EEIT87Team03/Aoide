package com.aoide.member._12_UpdateFavorite.model;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;

public class UpdateFavoriteService {
	
	FavoriteDAO favoriteDAO = new JdbcFavoriteDAO();
	FavoriteVO new_favoriteVO = new FavoriteVO();

	public void delectFavorite(Integer memberId, Integer songId) {
		
		favoriteDAO.delete(memberId, songId);
		
	}

	public void insertFavorite(Integer memberId, Integer songId) {
		
		new_favoriteVO.setMemberId(memberId);
		new_favoriteVO.setSongId(songId);
		favoriteDAO.insert(new_favoriteVO);
		
	}

}
