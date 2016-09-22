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

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

/**
 * Servlet Filter implementation class PretendLogin
 */
@WebFilter(urlPatterns = { "*.member" , "/_17_EditInfo.view/editInfo.jsp"})
public class PretendLogin implements Filter {

    // Constructor
    public PretendLogin() {

    }

    // Methods
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println(req.getRequestURL());
		
		req.getSession().setAttribute("member", new MemberService().getMemberBean("whiteBirdBeauty"));
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
