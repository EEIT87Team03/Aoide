package com.aoide.member._13_ShareSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;

public class ShareService {
	ScoreDAO scoreDAO = new JdbcScoreDAO();

		
		public List<ScoreVO> getPoint(){
			List<ScoreVO> point = new ArrayList<ScoreVO>();
			for(ScoreVO iscore : scoreDAO.getAll()){
				
				 point.add(iscore);
				}
			return point;
			
			
		
		}

}
