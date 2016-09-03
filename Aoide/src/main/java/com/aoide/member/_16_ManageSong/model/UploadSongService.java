package com.aoide.member._16_ManageSong.model;

import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;

public class UploadSongService {
	SongDAO songDAO = new JdbcSongDAO();
	
	public UploadSongService() {
		
	}
	
	public void insertUploadSong(SongVO songVO){
		songDAO.insert(songVO);
		
	}
}
