package com.aoide.manager._27_ReplySuggestions.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.manager._27_ReplySuggestions.model.SuggestionService;


@WebServlet("/SaveSuggestionReplyServlet")
public class SaveSuggestionReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		SuggestionVO suggestion = null;
		SuggestionVO updatedSuggestion = null;
		SuggestionService suggestionService = null;
		
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("replyContent").trim();
		
		if (text != null && text.length() != 0){// having reply content, replyState = 1
			// update replyState and replyContentFile 
			session = request.getSession();
			suggestion = (SuggestionVO) session.getAttribute("suggestion");
			session.removeAttribute("suggestion");			
			suggestion.setReplyState(1); 
			suggestion.setReplyContentFile(text);
			
			System.out.println("suggestion: " + suggestion);
			System.out.println("suggestion: " + suggestion.getTitle());
			System.out.println("suggestion: " + suggestion.getReplyContentFile());
			System.out.println("suggestion: " + suggestion.getSuggestionId());
			
			
			// update suggestion
			suggestionService = new SuggestionService();
			suggestionService.updateSuggestion(suggestion);			
			System.out.println("update suggestion success");
		}else{ // no reply content, replyState = 0
			System.out.println("no text availible");
		}
		
		// get the suggestion from database to check the result of update
		updatedSuggestion = suggestionService.getSuggestionById(suggestion.getSuggestionId());
		session.setAttribute("updatedSuggestion", updatedSuggestion);
		// go to replyResult.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/manager/_27_ReplySuggestions.view/replyResult.jsp");
		
	}

}
