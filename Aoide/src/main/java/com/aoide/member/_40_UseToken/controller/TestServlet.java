package com.aoide.member._40_UseToken.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

import com.aoide.member._40_UseToken.model.MemberDAO;
import com.aoide.member._40_UseToken.model.TokenRecordDAO;
import com.aoide.member._40_UseToken.model.TokenRecordVO;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		TokenRecordVO tokenRecord = new TokenRecordVO();
		tokenRecord.setRecipientId(1); // sponsor_id
		tokenRecord.setTokenVolume(1000000); 
		tokenRecord.setSponsorBalance(0);
		tokenRecord.setRecipienBalance(0);
		
		new TokenRecordDAO(template).insert(tokenRecord);
		
		MemberVO member = new MemberService().getMemberBean("happyPola");
		member.setTokenTotal(BigDecimal.valueOf(55559).movePointLeft(2));
		new MemberDAO(template).update(member);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
