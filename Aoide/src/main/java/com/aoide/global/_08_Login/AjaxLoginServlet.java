package com.aoide.global._08_Login;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._40_UseToken.model.UseTokenService;


@WebServlet("/AjaxLoginServlet")
public class AjaxLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// Fields
	WebApplicationContext context = null;
	
	// Methods
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get account, password
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter( "account" ).trim();
		String password = request.getParameter( "password" ).trim();
		
		// call service get member bean
		MemberService ms = new MemberService();
		MemberVO memberBean = ms.getMemberBean( account );
		
		// generate respond content and put member in session
		String loginState = null;
		String picturePath = null;
		if( (memberBean != null) && password.equals( memberBean.getPassword()) ){
			
			// update member login date and login count
			memberBean = ms.getMemberBean(account);
			memberBean.setLastLoginDate( new Timestamp(System.currentTimeMillis() ) );
			memberBean.setLoginCount( (memberBean.getLoginCount()+1) );
			
			// update member token
			long lastLoginMillis = memberBean.getLastLoginDate().getTime();
			long currentLoginMillis = System.currentTimeMillis();
			if( (currentLoginMillis-lastLoginMillis) >= (24*60*60*1000L) ){
				 // call service giving token to the member
				 UseTokenService service = new UseTokenService((DataSource)context.getBean("dataSource"));
				 service.getToken(memberBean, 10);
				 memberBean.setTokenTotal( memberBean.getTokenTotal().add( (BigDecimal.valueOf(10)) ) );
			}	 
			ms.updateMemberData(memberBean);
			
			// set login data for views
			request.getSession().setAttribute( "member", memberBean );
			loginState = "loginSuccess";
			picturePath = "data:image/*;base64," + memberBean.getPicture();
		} else {
			loginState = "loginFail";
			picturePath = null;
		}
		
		JSONObject loginJson = new JSONObject();
		loginJson.put("loginState", loginState);
		loginJson.put("pictureSource", picturePath);
		loginJson.toJSONString();
		
		// generate respond
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(loginJson.toJSONString());
		
	}

}
