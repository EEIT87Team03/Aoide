package com.aoide.global._08_Login;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._40_UseToken.model.UseTokenService;



@WebServlet("/Login")
public class LoginAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Fields
	WebApplicationContext context = null;
	
	// Methods
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
												throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter( "account" );
		String password = request.getParameter( "password" );
		// check input is empty or not
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		if(!Validator.isValidAccount(account)){
			errorMsg.put("accountError", "Please enter valid account");
		}else{
			enteredText.put("account", account);
		}
		if(!Validator.isValidString(password)){
			errorMsg.put("passwordError", "Please enter valid password");
		}
		// if error go to home.jsp
		if (!errorMsg.isEmpty()){
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			return;
		}else{
			// check the account and password correct or not
			MemberService ms = new MemberService();
			MemberVO memberBean = ms.getMemberBean( account );
			if ( ( memberBean != null ) && password.equals( memberBean.getPassword() ) )
			{
				// if login success update login time go to target url
				//System.out.println("Last login date before login: " + memberBean.getLastLoginDate());
				long lastLoginMillis = memberBean.getLastLoginDate().getTime();
				long currentLoginMillis = System.currentTimeMillis();
				// get 10 token reward per day if login
				if( (currentLoginMillis-lastLoginMillis) >= (24*60*60*1000L) ){
					 // call service giving token to the member
					 UseTokenService service = new UseTokenService((DataSource)context.getBean("dataSource"));
					 service.getToken(memberBean, 10);
					 
					 System.out.println("add 10 token");
					 
				}
				memberBean.setLastLoginDate( new Timestamp(System.currentTimeMillis() ) );
				ms.updateMemberData(memberBean);
				memberBean = ms.getMemberBean(account);
				// System.out.println("Last login date after login: " + memberBean.getLastLoginDate());
				request.getSession().setAttribute( "member", memberBean );
				response.sendRedirect( request.getContextPath() + "/index.jsp" );
			}else{
				// if login fail go to home.jsp
				if (memberBean == null){
					errorMsg.put("accountError", "Please enter correct account");
				}else{
					enteredText.put("account", account);
				}
				if (memberBean != null){
					errorMsg.put("passwordError", "Please enter correct password");
				}
				request.setAttribute("errorMsg", errorMsg);
				request.setAttribute("enteredText", enteredText);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
				return;
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException 
	{
		doGet( request, response );
	}

}
