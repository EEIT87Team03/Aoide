package com.aoide.member._40_UseToken.model;

import org.springframework.jdbc.core.JdbcTemplate;



public class TokenRecordDAO {
	// Fields
	private static final String INSERT_STMT = new StringBuffer()
			.append("INSERT INTO ")
			.append("token_record")
			.append("(")
			.append("recipient_id,")
			.append("token_volume,")
			.append("sponsor_balance,")
			.append("recipien_balance,")
			.append("sponsor_id")
			.append(") ")
			.append("VALUES(?,?,?,?,?)")
			.toString();
	private JdbcTemplate template = null;

	// Construtors
	public TokenRecordDAO() {
		
	}
	public TokenRecordDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// Methods
	public void insert(TokenRecordVO vo) {
		template.update(INSERT_STMT, new Object[] { 
				vo.getRecipientId(),
				vo.getTokenVolume(), 
				vo.getSponsorBalance(),
				vo.getRecipienBalance(),
				vo.getSponsorId()
		});
	}
	/*
	.append("recipient_id,")
	.append("token_volume,")
	.append("sponsor_balance,")
	.append("recipien_balance")
	*/
	
}
