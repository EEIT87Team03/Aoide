package com.aoide.member._40_UseToken.model;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class UseTokenService {
	// Fields
	private DataSource dataSource = null;
	private JdbcTemplate template = null;
	private MemberDAO memberDAO = null;
	private TokenRecordDAO tokenRecordDAO = null;
	
	// Constructors
	public UseTokenService() {
	}
	public UseTokenService(DataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberDAO = new MemberDAO(template);
		tokenRecordDAO = new TokenRecordDAO(template);
	}
	
	// Methods
	@Transactional(transactionManager="transactionManager")
	public void useToken(MemberVO member,int tokenVolume ) {
		// insert tokenRecord
		TokenRecordVO tokenRecord = new TokenRecordVO();
		tokenRecord.setRecipientId(member.getMemberId()); // sponsor_id
		tokenRecord.setTokenVolume(tokenVolume); 
		tokenRecord.setsponsorBalance(0);
		tokenRecord.setRecipienBalance(0);
		tokenRecordDAO.insert(tokenRecord);
		
		
		// update member tokenTotal
		member.setTokenTotal(BigDecimal.valueOf(tokenVolume));
		member.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		memberDAO.update(member);
	}
	
}
