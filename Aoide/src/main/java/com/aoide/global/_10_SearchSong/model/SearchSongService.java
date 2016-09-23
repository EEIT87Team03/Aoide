package com.aoide.global._10_SearchSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class SearchSongService {
	SongDAO songDAO = new JdbcSongDAO();
	AlbumService albumService = new AlbumService();

	public SearchSongService() {

	}

	public List<SongVO> getSongName(String search) {
		List<SongVO> searchResult = new ArrayList();
		for (SongVO searchSong : songDAO.getName(search)) {
			searchResult.add(searchSong);
		}
		return searchResult;
	}
	
	public List<SongVO> getSinger(String search) {
		List<SongVO> searchResult = new ArrayList();
		for (SongVO searchSong : songDAO.getSinger(search)) {
			searchResult.add(searchSong);
		}
		return searchResult;
	}

	public List<AlbumVO> getAlbum(String search) {
		List<AlbumVO> searchResult = new ArrayList();
		for (AlbumVO searchSong : albumService.searchAlbum(search)) {
			searchResult.add(searchSong);
		}
		return searchResult;
	}
	
	public List<SongVO> getSongOne(Integer songId) {
		List<SongVO> OneSong = new ArrayList();
		for (SongVO oneSong : songDAO.findByOther(songId)) {
			OneSong.add(oneSong);
		}
		return OneSong;
	}

}
