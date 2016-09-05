package com.aoide.global._06_PlayHistory.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.global.dataBaseManipulationObjects.clickHistory.ClickHistoryDAO;
import com.aoide.global.dataBaseManipulationObjects.clickHistory.ClickHistoryVO;
import com.aoide.global.dataBaseManipulationObjects.clickHistory.JdbcClickHistoryDAO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;

public class PlayHistoryService {
	
	ClickHistoryDAO clickHistoryDAO = new JdbcClickHistoryDAO();
	SongDAO songDAO = new JdbcSongDAO(); 
	
	
	public PlayHistoryService(){
		
		
	};
	
	
	public List<ClickHistoryVO> getAllClickhistory(){
		
		List<ClickHistoryVO> clickHistorysList = new ArrayList();
		
		for(ClickHistoryVO clickHistoryVO : clickHistoryDAO.getAll()){
			
			clickHistorysList.add(clickHistoryVO);
			
		}
		return clickHistorysList;
		
		
	}


	public void insetNewClickHistory(ClickHistoryVO new_clickhistoryVO) {
		
		clickHistoryDAO.insert(new_clickhistoryVO);
		
	}


	public String getSongNameBySongId(Integer songId) {
		
		SongVO songVO = songDAO.findByPrimaryKey(songId);
		
		return songVO.getName();
		
	}


	
	
	

}
