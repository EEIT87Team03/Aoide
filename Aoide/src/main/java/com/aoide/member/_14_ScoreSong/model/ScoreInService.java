package com.aoide.member._14_ScoreSong.model;

import java.util.ArrayList;
import java.util.List;

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
	

	
	 public ScoreVO findScoredByPrimaryKey(Integer memberId, Integer songId)
	 
	 {
		 

	    return scoreDAO.findByPrimaryKey(memberId, songId);
		 
			
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
	
}
		 
		 
	 
	 
	
		 
		 
	
	
	
	 


