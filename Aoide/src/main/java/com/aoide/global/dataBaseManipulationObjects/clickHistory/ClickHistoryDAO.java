package com.aoide.global.dataBaseManipulationObjects.clickHistory;

import java.util.*;



public interface ClickHistoryDAO {

    public void insert(ClickHistoryVO chlickhistoryVO);
    public void update(ClickHistoryVO chlickhistoryVO);
    public void delete(Integer clickhistoryId);
    public ClickHistoryVO findByPrimaryKey(Integer clickhistoryId);
    public List<ClickHistoryVO> getAll();
	
	
	
	
	
	
}
