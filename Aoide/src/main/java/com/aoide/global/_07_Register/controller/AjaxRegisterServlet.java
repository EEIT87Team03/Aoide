package com.aoide.global._07_Register.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/AjaxRegisterServlet")
public class AjaxRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get input 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter( "name" ).trim();
		String email = request.getParameter( "email" ).trim();
		String account = request.getParameter( "account" ).trim();
		String password = request.getParameter( "password" ).trim();
		
		System.out.printf("name: %s; email: %s; account: %s; password: %s", name, email, account, password );
		
		// check the input, add error message
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
//		if (!Validator.isValidString(name)){
//			errorMsg.put("nameError", "Please enter name");
//		} else {
//			enteredText.put("name", name);
//		}
//		if (!Validator.isValidEmail(email)){
//			errorMsg.put("emailError", "Please enter valid email");
//		} else {
//			enteredText.put("email", email);
//		}
//		if (!Validator.isValidString(account)){
//			errorMsg.put("accountError", "Please enter valid account");
//		} else {
//			enteredText.put("account", account);
//		}
//		if (!Validator.isValidPassword(password)){
//			errorMsg.put("passwordError", "Please enter valid password");
//		} else {
//			enteredText.put("password", password);
//		}
		// if having error go to register again
		String regstState = null;
		if (!errorMsg.isEmpty()){
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			regstState = "regstFial";
		}else{
			// if input correct call service save input in DB
			MemberVO member = new MemberVO();
			member.setName(name);
			member.setEmail(email);
			member.setAccount(account);
			member.setPassword(password);
			new MemberService().createMemberAccount(member);
			regstState = "regstSuccess";
		}
		// generate respond
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().write(regstState);
	}

}
