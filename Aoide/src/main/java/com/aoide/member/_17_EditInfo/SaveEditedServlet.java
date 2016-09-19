package com.aoide.member._17_EditInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/EditInfoServlet")
public class SaveEditedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in editInfo servlet");
		
		// get the input and check
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String introduction = request.getParameter("introduction");
		
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("introduction: " + introduction);
		
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		if(!Validator.isValidString(name)){
			errorMsg.put("nameError", "Please enter name");
		}
		if(!Validator.isValidString(email)){
			errorMsg.put("emailError", "Please enter email");
		}
//		if(!Validator.isValidString(introduction)){
//			errorMsg.put("introductionError", "Please enter introduction");
//		}
		// if the input empty go to memberInfo.jsp
		if(!errorMsg.isEmpty()){
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("/views/member/_17_EditInfo.view/memberInfo.jsp").forward(request, response);
			return;
		}else{
		// if the input valid call service to update put new memberBean in session
			HttpSession session = request.getSession();
			MemberVO member = (MemberVO) session.getAttribute("member");
			String account = member.getAccount();
			// get member bean from session and update 
			member.setName(name);
			member.setEmail(email);
			member.setIntroductionFilePath(introduction);
			MemberService service = new MemberService();
			
			service.updateMemberData(member);

			// go checkEdited.jsp
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_17_EditInfo.view/checkEdited.jsp");
			return;
		}
	}
}
