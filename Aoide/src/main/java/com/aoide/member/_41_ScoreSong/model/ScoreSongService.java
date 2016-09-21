package com.aoide.member._41_ScoreSong.model;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class ScoreSongService {
	// Fields
	private DataSource ds = null;
	private JdbcTemplate template = null;
	private SpringScoreDAO scoreDAO = null; 
	private JdbcSongDAO songDAO = null;
	
	// Constructors
	public ScoreSongService() {

	}
	public ScoreSongService(DataSource ds) {
		this.ds = ds;
		this.template = new JdbcTemplate(ds);
		this.scoreDAO = new SpringScoreDAO(template);
		this.songDAO = new JdbcSongDAO();
	}
	
	// Methods
	public void scoreSong(ScoreVO score){
		// insert score record
		scoreDAO.insert(score);
		
		// get the avg of the song
		Integer songId = score.getSongId();
		Double avg = Double.parseDouble(scoreDAO.getAverage(songId));
		
		// update song.score
		SongVO song = songDAO.findByPrimaryKey(songId);
		song.setScore(avg);
		songDAO.update(song);
		
	}
	
}
