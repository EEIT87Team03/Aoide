package com.aoide.global._04_PutSuggestion.model;

import com.aoide.global.dataBaseManipulationObjects.suggestion.JdbcSuggestionDAO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

public class PutSuggestionService {
	// Fields
	JdbcSuggestionDAO suggestionDAO = null;

	// Constructors
	public PutSuggestionService() {
		this.suggestionDAO = new JdbcSuggestionDAO();
	}
	
	// Methods
	public Integer putSuggetion(SuggestionVO suggestion){
		return suggestionDAO.insert(suggestion);
	}
	
	public SuggestionVO getSuggestionById(Integer suggestionId){
		return suggestionDAO.findByPrimaryKey(suggestionId);
	}
	
	
}
