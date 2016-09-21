package com.aoide.member._40_UseToken.model;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


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
		tokenRecord.setRecipientId(0); // recipient is manager
		tokenRecord.setTokenVolume(tokenVolume);   
		tokenRecord.setSponsorBalance(0);
		tokenRecord.setRecipienBalance(0);
		tokenRecord.setSponsorId( member.getMemberId() );  // sponsor is member
		tokenRecordDAO.insert(tokenRecord);
		
		// update member tokenTotal
		BigDecimal tokenTotal = member.getTokenTotal().subtract( (BigDecimal.valueOf(tokenVolume)) );
		member.setTokenTotal(tokenTotal);
//		member.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		memberDAO.update(member);
	}
	@Transactional(transactionManager="transactionManager")
	public void getToken(MemberVO member,int tokenVolume ) {
		// insert tokenRecord
		TokenRecordVO tokenRecord = new TokenRecordVO();
		tokenRecord.setRecipientId(member.getMemberId()); // recipient is member
		tokenRecord.setTokenVolume(tokenVolume);   
		tokenRecord.setSponsorBalance(0);
		tokenRecord.setRecipienBalance(0);
		tokenRecord.setSponsorId(0);  // sponsor is manager
		tokenRecordDAO.insert(tokenRecord);
		
		// update member tokenTotal
		BigDecimal tokenTotal = member.getTokenTotal().add((BigDecimal.valueOf(tokenVolume)));
		member.setTokenTotal(tokenTotal);
//		member.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		memberDAO.update(member);
	}
	
	
	
}
