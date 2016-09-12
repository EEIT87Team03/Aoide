package com.aoide.member._99_TestUpload.model;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class UploadService {
	// Fields
	private TestUploadDAO dao1 = null;
	private JdbcSongDAO dao2 = null;
	// Constructors

	public UploadService() {
		this.dao1 = new TestUploadDAO();
		this.dao2 = new JdbcSongDAO();
	}
	// Methods
	public Integer saveUpload(SongVO song){
		return dao2.insert(song);
	}
	
	public void updatePath(SongVO song){
		dao2.update(song);
	}
	
	public SongVO checkUpload(Integer id){
		return dao2.findByPrimaryKey(id);
	}
	
}
