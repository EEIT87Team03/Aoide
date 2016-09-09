package com.aoide.member._16_ManageSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class ListSongService {
	SongDAO songDAO = new JdbcSongDAO();
	
	public ListSongService(){
		
	}
	
	public List<SongVO> getMySong() {
		List<SongVO> mySongResult = new ArrayList();
		for (SongVO mySong : songDAO.getAll()) {
			if (mySong.getMemberId() == 1) {
				mySongResult.add(mySong);
			}
		}
		return mySongResult;
	}

}