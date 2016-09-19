package com.aoide.member._40_UseToken.model;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class MemberDAO {
	// Fields
	private static final String UPDATE_STMT = 
			"UPDATE member SET "
			+ "[password] = ?, [name] = ?, [email] = ?, [register_state] = ?, [login_count] = ?, [last_login_date] = ?, "
			+ "[token_total] = ?, [introduction_file_path] = ?, [class_type] = ?, [ban_state] = ?, [bank_info] = ?, [picture] = ? "
			+ "WHERE [account] = ?";
	private JdbcTemplate template = null;
	
	// Construtors
	public MemberDAO() {
		
	}
	public MemberDAO(JdbcTemplate template) {
		this.template = template;
	}

	// Methods
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void update(MemberVO vo){
		
		template.update(UPDATE_STMT, new Object[] { 
				vo.getPassword(),
				vo.getName(),
				vo.getEmail(),
				vo.getRegisterState(),
				vo.getLoginCount(),
				vo.getLastLoginDate(),
				vo.getTokenTotal(),
				vo.getIntroductionFilePath(),
				vo.getClassType(),
				vo.getBanState(),
				vo.getBankInfo(),
				vo.getPicture(),
				vo.getAccount()
		});
	}
	/*
			"UPDATE member SET "
			+ "[password] = ?, [name] = ?, [email] = ?, [register_state] = ?, [login_count] = ?, [last_login_date] = ?, "
			+ "[token_total] = ?, [introduction_file_path] = ?, [class_type] = ?, [ban_state] = ?, [bank_info] = ?, [picture] = ? "
			+ "WHERE [account] = ?";
	 */
	



	
}
