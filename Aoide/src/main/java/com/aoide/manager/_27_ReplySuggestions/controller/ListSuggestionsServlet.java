package com.aoide.manager._27_ReplySuggestions.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.manager._27_ReplySuggestions.model.SuggestionService;




@WebServlet("/ReplySuggestionsServlet")
public class ListSuggestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In ReplySuggestionsServlet doGet()");
		// get the suggestion list from service
		List<SuggestionVO> unreplySuggestions = new SuggestionService().getUnreplySuggestions();
		// put suggestions list into session object
		for(SuggestionVO aSuggestion : unreplySuggestions){
			System.out.println(aSuggestion.getSuggestionContentFile());
		}
		
		request.getSession().setAttribute("unreplySuggestionsList", unreplySuggestions);
		// go suggestionList.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_27_ReplySuggestions.view/suggestionList.jsp");
	}// end doGet()


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In ReplySuggestionsServlet doPost()");
	}

}
