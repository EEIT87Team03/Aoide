package com.aoide.member._41_ScoreSong.model;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aoide.member._40_UseToken.model.TokenRecordVO;

public class SpringScoreDAO {
	// Fields
	private static final String INSERT_STMT = "INSERT INTO Score (member_id,song_id,score_value,comment_file) VALUES(?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT member_id,song_id,date,score_value,comment_file FROM Score order by member_id";
	private static final String GET_ONE_STMT = "SELECT member_id,song_id,date,score_value,comment_file FROM Score where member_id=? and song_id=?";
	private static final String GET_AVG_STMT = "SELECT AVG(score_value) FROM score WHERE song_id = ?";
	private JdbcTemplate template = null;
	
	// Constructors
	public SpringScoreDAO() {
		
	}
	public SpringScoreDAO(JdbcTemplate template) {
		this.template = template;
	}

	// Methods
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void insert(ScoreVO vo) {
		template.update(INSERT_STMT, new Object[] { // (member_id,song_id,score_value,comment_file) 
			vo.getMemberId(),
			vo.getSongId(),
			vo.getScoreValue(),
			vo.getComment()
		});
	}
	public String getAverage(Integer songid){
		return (String)template.queryForObject(GET_AVG_STMT, new Object[] { songid }, String.class);
	}
	
}
