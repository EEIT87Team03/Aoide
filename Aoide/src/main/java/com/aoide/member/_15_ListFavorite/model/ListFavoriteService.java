package com.aoide.member._15_ListFavorite.model;


import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class ListFavoriteService {
	
	
	FavoriteDAO favoriteDAO = new JdbcFavoriteDAO();
	SongDAO songDAO = new JdbcSongDAO();

	
	public FavoriteVO findByPrimaryKey(Integer memberId, Integer songId) {
		
		return favoriteDAO.findByPrimaryKey(memberId, songId);
	}
	
	
	public List<FavoriteVO> getFavoritesById(Integer memberId) {
		
		return ((JdbcFavoriteDAO) favoriteDAO).getFavoritesById(memberId);
	}
	

	

	public List<SongVO> getAll(){
       List<SongVO> point = new ArrayList<SongVO>();
			for(SongVO iscore : songDAO.getAll()){
				
				 point.add(iscore);
				}
			return point;

		}
	
	public List<SongVO> getFavoritesSongById(Integer memberId){
		
		return ((JdbcSongDAO) favoriteDAO).getFavoritesSongById(memberId);

	}
	
}
	
	
	

