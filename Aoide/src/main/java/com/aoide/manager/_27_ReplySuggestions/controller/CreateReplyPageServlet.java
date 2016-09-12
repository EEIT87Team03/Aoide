package com.aoide.manager._27_ReplySuggestions.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

/**
 * Servlet implementation class GenerateReplyPageServlet
 */
@WebServlet("/GenerateReplyPageServlet")
public class CreateReplyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<SuggestionVO> suggestions;
		HttpSession session = null;
		
		// get the suggestion id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the suggestionVO by id from session
		session = request.getSession();
		suggestions = (List<SuggestionVO>) session.getAttribute("unreplySuggestionsList"); // from ListSuggestionServlet
		
		// put the suggestionVO in session
		for(SuggestionVO aSuggestion:suggestions){
			if(aSuggestion.getSuggestionId() == id){
				session.setAttribute("suggestion", aSuggestion);
			}
		}
		
		// go to enter reply page
		String path = request.getContextPath();
		response.sendRedirect(path + "/views/manager/_27_ReplySuggestions.view/enterReplyContent.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
