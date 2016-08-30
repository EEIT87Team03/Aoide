package com.aoide.global._00_TestUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

/**
 * Servlet Filter implementation class PretendLogin
 */
@WebFilter(urlPatterns = { "*.member" })
public class PretendLogin implements Filter {

    // Constructor
    public PretendLogin() {

    }

    // Methods
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		MemberVO m = new MemberVO();
		m.setMemberId( 2 );
		m.setAccount( "KKKwhiteBirdBeauty" );
		m.setPassword( "28825252" );
		m.setName( "白鳥美麗" );
		m.setEmail( "fattyCutty@outlook.com" );
		m.setRegisterState( 0 );
		m.setLoginCount( 50 );
		m.setLastLoginDate( Timestamp.valueOf( "2016-08-20 20:37:31.940" ) );
		m.setTokenTotal( new BigDecimal(350) );
		m.setPicture( null );
		m.setIntroductionFilePath( "C:/introduction/file" );
		m.setClassType( 0 );
		m.setBanState( false );
		m.setBankInfo( "fffffffirst bank" );
		
		((HttpServletRequest)request).getSession().setAttribute("loginMember", m);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
