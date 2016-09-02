package com.aoide.global._06_PlayHistory.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickhistoryDAO;
import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickhistoryDAO_interface;
import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickhistoryVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO_Inteface;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;

public class PlayHistoryService {
	
	ClickhistoryDAO_interface clickhistoryDAO = new ClickhistoryDAO();
	SongDAO_Inteface SongDAO = new SongDAO(); 
	
	
	public PlayHistoryService(){
		
		
	};
	
	
	public List<ClickhistoryVO> getAllClickhistory(){
		
		List<ClickhistoryVO> clickhistorysList = new ArrayList();
		
		for(ClickhistoryVO clickhistoryVO : clickhistoryDAO.getAll()){
			
			clickhistorysList.add(clickhistoryVO);
			
		}
		return clickhistorysList;
		
		
	}


	public void insetNewClickHistory(ClickhistoryVO new_clickhistoryVO) {
		
		clickhistoryDAO.insert(new_clickhistoryVO);
		
	}


	public String getSongNameBySongId(Integer songId) {
		
		SongVO songVO = SongDAO.findByPrimaryKey(songId);
		
		return songVO.getName();
		
	}


	
	
	

}
