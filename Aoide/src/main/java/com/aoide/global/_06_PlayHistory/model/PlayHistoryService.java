package com.aoide.global._06_PlayHistory.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.clickhistory.JdbcClickHistoryDAO;
import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickHistoryDAO;
import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickHistoryVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO_Inteface;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;

public class PlayHistoryService {
	
	ClickHistoryDAO clickhistoryDAO = new JdbcClickHistoryDAO();
	SongDAO_Inteface SongDAO = new SongDAO(); 
	
	
	public PlayHistoryService(){
		
		
	};
	
	
	public List<ClickHistoryVO> getAllClickhistory(){
		
		List<ClickHistoryVO> clickhistorysList = new ArrayList();
		
		for(ClickHistoryVO clickhistoryVO : clickhistoryDAO.getAll()){
			
			clickhistorysList.add(clickhistoryVO);
			
		}
		return clickhistorysList;
		
		
	}


	public void insetNewClickHistory(ClickHistoryVO new_clickhistoryVO) {
		
		clickhistoryDAO.insert(new_clickhistoryVO);
		
	}


	public String getSongNameBySongId(Integer songId) {
		
		SongVO songVO = SongDAO.findByPrimaryKey(songId);
		
		return songVO.getName();
		
	}


	
	
	

}
