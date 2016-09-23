package com.aoide.member._12_UpdateFavorite.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class UpdateFavoriteService {
	
	FavoriteDAO favoriteDAO = new JdbcFavoriteDAO();
	FavoriteVO new_favoriteVO = new FavoriteVO();
	SongDAO songDAO = new JdbcSongDAO();


	public void delectFavorite(Integer memberId, Integer songId) {
		
		favoriteDAO.delete(memberId, songId);
		
	}

	public void insertFavorite(Integer memberId, Integer songId) {
		
		new_favoriteVO.setMemberId(memberId);
		new_favoriteVO.setSongId(songId);
		favoriteDAO.insert(new_favoriteVO);
		
	}
	
	public FavoriteVO getFavoritesBySong(Integer songId){

		return new_favoriteVO;

	}
	
	public SongVO insert(Integer favorite_counts){
		SongVO counts = songDAO.findByPrimaryKey(favorite_counts);
		counts.setFavoriteCounts((counts.getFavoriteCounts() + 1));
		songDAO.update(counts);
		return counts;
		
		
	

	}

}
