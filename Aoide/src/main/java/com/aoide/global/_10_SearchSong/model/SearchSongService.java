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
		List<SongVO> searchResult = songDAO.getName(search);
		for (SongVO searchSong : searchResult) {
			if (searchSong.getName().equals(search)) {
				searchResult.add(searchSong);
			}
		}
		return searchResult;
	}
	
	public List<SongVO> getSinger(String search) {
		List<SongVO> searchResult = songDAO.getSinger(search);
		for (SongVO searchSong : searchResult) {
			if (searchSong.getSinger().equals(search)) {
				searchResult.add(searchSong);
			}
		}
		return searchResult;
	}

	public List<AlbumVO> getAlbum(String search) {
		List<AlbumVO> searchResult = albumService.searchAlbum(search);
		List<AlbumVO> newSR = new ArrayList();
		for (AlbumVO searchSong : searchResult) {
			if (searchSong.getName().equals(search)) {
				newSR.add(searchSong);
			}
		}
		return newSR;
	}

}
