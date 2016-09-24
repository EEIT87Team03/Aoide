package com.aoide.member._14_ScoreSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.JdbcFavoriteDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class ScoreInService {
	
	ScoreDAO scoreDAO = new JdbcScoreDAO();

	

	public void insert(ScoreVO new_scoreVO) {
		

		scoreDAO.insert(new_scoreVO);
		
	
		
	}
	


	

	public List<ScoreVO> getComment_D()
	
	{  
	  List<ScoreVO> commentfile = new ArrayList<ScoreVO>();
	  
		for(ScoreVO commentValue : scoreDAO.getAll()){
			commentfile.add(commentValue);
			commentValue.getComment();
			
			}
		return commentfile;

	
		 

	}



	public List<ScoreVO> ScoreSong(Integer songId) {
		return ((JdbcScoreDAO) scoreDAO).getScoreSongById(songId);
		
	
	}
	
}
		 
		 
	 
	 
	
		 
		 
	
	
	
	 


