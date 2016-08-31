package com.aoide.member._12_UpdateFavorite.model;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class UpdateFavoriteService {
	// Fields
	FavoriteDAO favoriteDAO = null;
	SongDAO songDAO = null;
	
	// Constructors
	public UpdateFavoriteService(){
		this.favoriteDAO = new FavoriteDAO();
		this.songDAO = new SongDAO();
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
