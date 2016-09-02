package com.aoide.member._12_UpdateFavorite.model;

import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class UpdateFavoriteService {
	// Fields
	JdbcFavoriteDAO favoriteDAO = null;
	JdbcSongDAO songDAO = null;
	
	// Constructors
	public UpdateFavoriteService(){
		this.favoriteDAO = new JdbcFavoriteDAO();
		this.songDAO = new JdbcSongDAO();
	}
	
	// Methods
	public void updateFavoriteList(int memberId, int songId){
		favoriteDAO.insert(new FavoriteVO(memberId, songId));
	}
	
	public void updateSongFavoriteCounts(int songId){
		SongVO song = songDAO.findByPrimaryKey(songId);
		song.setFavoriteCounts((song.getFavoriteCounts() + 1 ));
		songDAO.update(song);
	}
	
}
