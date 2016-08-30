package com.aoide.global.dataBaseManipulationObjects.clickhistory;

import java.util.*;



public interface ClickhistoryDAO_interface {

    public void insert(ClickhistoryVO chlickhistoryVO);
    public void update(ClickhistoryVO chlickhistoryVO);
    public void delete(Integer clickhistoryId);
    public ClickhistoryVO findByPrimaryKey(Integer clickhistoryId);
    public List<ClickhistoryVO> getAll();
	
	
	
	
	
	
}
