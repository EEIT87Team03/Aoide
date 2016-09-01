package com.aoide.global.dataBaseManipulationObjects.suggestion;

import java.util.List;


public interface SuggestionDAO {
	public Integer insert(SuggestionVO suggestionVO);
	public void update(SuggestionVO suggestionVO);
	public void delete(Integer suggestion_id);
	public SuggestionVO findByPrimaryKey(Integer suggestion_id);
	public List<SuggestionVO> getAll();
}
