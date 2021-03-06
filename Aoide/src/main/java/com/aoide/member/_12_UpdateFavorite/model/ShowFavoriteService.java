package com.aoide.member._12_UpdateFavorite.model;

import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class ShowFavoriteService {
	
	// Constructors
	FavoriteDAO favoriteDAO = new JdbcFavoriteDAO();
	SongDAO songDAO = new JdbcSongDAO();
	
	// Methods
	public List<FavoriteVO> getFavoriteById(Integer memberId) {
		return favoriteDAO.finByMemberId(memberId);
	}
	public String getSongNameBySongId(Integer songId) {
		SongVO songVO = songDAO.findByPrimaryKey(songId);
		return songVO.getName();
	}
    public String getSinger(Integer songId) {
		SongVO songVO = songDAO.findByPrimaryKey(songId);
		return songVO.getSinger();
	}
    public List<SongVO> getFavoriteSongs(Integer memberId){
    	return favoriteDAO.getFavoriteSongs(memberId);
    }
	
	
	
	
	
	
	
	/*
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
	
	*/

	
	
}
