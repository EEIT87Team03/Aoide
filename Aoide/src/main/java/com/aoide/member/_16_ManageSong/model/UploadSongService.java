package com.aoide.member._16_ManageSong.model;

import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;

public class UploadSongService {
	SongDAO songDAO = new JdbcSongDAO();
	private JdbcSongDAO dao = null;
	
	public UploadSongService() {
		this.dao = new JdbcSongDAO();
	}
	
	public Integer insertUploadSong(SongVO songVO){
		return songDAO.insert(songVO);
		
	}

	public void updatePath(SongVO song) {
		dao.update(song);
		
	}

	public SongVO checkUpload(Integer id) {
		return dao.findByPrimaryKey(id);
	}
}
