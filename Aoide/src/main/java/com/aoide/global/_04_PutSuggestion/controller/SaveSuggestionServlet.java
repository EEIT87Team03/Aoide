package com.aoide.global._04_PutSuggestion.controller;

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
import com.aoide.global._04_PutSuggestion.model.PutSuggestionService;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;


@WebServlet("/SaveSuggestionServlet")
public class SaveSuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	String title = null;
		String content = null;
		Map<String,String> errorMsg = new HashMap<>();
		Map<String,String> enteredText = new HashMap<>();
		PutSuggestionService service = new PutSuggestionService();
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		
		
		// Get title and suggestion content
		request.setCharacterEncoding("UTF-8");
		title = request.getParameter("title");
		content = request.getParameter("content");
		// Check is empty or not
		if(!Validator.isValidString(title)){
			errorMsg.put("emptyTitleMsg", "Please enter title");
		}else{
			enteredText.put("title", title);
		}
		
		if(!Validator.isValidString(content)){
			errorMsg.put("emptyContentMsg", "Please enter suggetion");
		}else{
			enteredText.put("content", content);
		}
		// If input not empty call service to save the suggestion
		if(errorMsg.isEmpty()){
			SuggestionVO suggestion = new SuggestionVO();
			suggestion.setTitle(title);
			suggestion.setSuggestionContentFile(content);
			// get new suggestion by id
			Integer suggestionId = service.putSuggetion(suggestion);
			suggestion = service.getSuggestionById(suggestionId); 
			// go checkSuggetionResult.jsp
			session.setAttribute("suggestion", suggestion);
			response.sendRedirect(contextPath + "/views/global/_04_PutSuggestion.view/checkSuggetionResult.jsp");
			return;
		}else{
		// If input empty forward to enterSuggestion.jsp
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("enteredText", enteredText);
			request.getRequestDispatcher("/views/global/_04_PutSuggestion.view/enterSuggestion.jsp").forward(request, response);
			return;
		}

		
		
	}

}
