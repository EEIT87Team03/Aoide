package com.aoide.global._10_SearchSong.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class SearchSongService {
	SongDAO songDAO = new JdbcSongDAO();

	public SearchSongService() {

	}

	public List<SongVO> getSongName(String search) {
		List<SongVO> searchResult = songDAO.getName(search);
		for (SongVO searchSong : searchResult) {
			if (searchSong.getName() == search) {
				searchResult.add(searchSong);
			}
		}
		return searchResult;
	}
	
	public List<SongVO> getSinger(String search) {
		List<SongVO> searchResult = songDAO.getSinger(search);
		for (SongVO searchSong : searchResult) {
			if (searchSong.getSinger() == search) {
				searchResult.add(searchSong);
			}
		}
		return searchResult;
	}

}
