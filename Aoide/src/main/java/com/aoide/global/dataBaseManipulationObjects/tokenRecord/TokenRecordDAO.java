package com.aoide.global.dataBaseManipulationObjects.tokenRecord;

import java.sql.SQLException;
import java.util.List;

public interface TokenRecordDAO {
	public void insert(TokenRecordVO TokenRecordVO);
	public void update(TokenRecordVO TokenRecordVO);
	public void delete(Integer token_record_id);
	public TokenRecordVO findByPrimaryKey(Integer token_record_id);
	public List<TokenRecordVO> getAll();
}
