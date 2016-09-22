package com.aoide.manager._27_ReplySuggestions.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionDAO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.JdbcSuggestionDAO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.TestSuggestionDAO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

public class SuggestionService {

	// Fields
	SuggestionDAO suggestionDAO = new JdbcSuggestionDAO();
	
	
	// Constructors
	public SuggestionService() {
		
	}
	
	// Methods  
	public List<SuggestionVO> getUnreplySuggestions(){
		List<SuggestionVO> unreplySuggestions =  new ArrayList();
		for(SuggestionVO aSuggestion : suggestionDAO.getAll()){
			if(aSuggestion.getReplyState() == 0){
				unreplySuggestions.add(aSuggestion);
			}
		}// end for
		return unreplySuggestions;
	}// end getUnreplySuggestions()
	
	public void updateSuggestion(SuggestionVO suggestionVO) {
		suggestionDAO.update(suggestionVO);
	}
	
	public SuggestionVO getSuggestionById(Integer suggestionId){
		return suggestionDAO.findByPrimaryKey(suggestionId);
	}
	
	
	
	
}// end class
