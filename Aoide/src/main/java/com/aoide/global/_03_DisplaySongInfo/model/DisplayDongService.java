package com.aoide.global._03_DisplaySongInfo.model;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class DisplayDongService {
	
	SongDAO songDAO  = new JdbcSongDAO();

	public SongVO getSongById(Integer song_id) {
		
		
		return songDAO.findByPrimaryKey(song_id);
	}

}
