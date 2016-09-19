package com.aoide.member._15_ListFavorite.model;


import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class ListFavoriteService {
	
	
	FavoriteDAO favoriteDAO = new JdbcFavoriteDAO();
	

	
	public FavoriteVO findByPrimaryKey(Integer memberId, Integer songId) {
		
		return favoriteDAO.findByPrimaryKey(memberId, songId);
	}
	
	

	
	
	
	
	
	

}