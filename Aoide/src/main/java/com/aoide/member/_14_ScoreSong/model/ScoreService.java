package com.aoide.member._14_ScoreSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

public class ScoreService {

	ScoreDAO scoreDAO = new JdbcScoreDAO();

	public ScoreService() {

	}

	public List<ScoreVO> getPoint() {
		List<ScoreVO> point = new ArrayList<ScoreVO>();
		for (ScoreVO iscore : scoreDAO.getAll()) {

			point.add(iscore);
		}
		return point;

	}

	public ScoreVO getScoreById(Integer memberId, Integer songId) {

		return scoreDAO.findByPrimaryKey(memberId, songId);
	}

	public ScoreVO updateScore(ScoreVO scoreVO) {

		scoreDAO.update(scoreVO);
		return scoreVO;

	}

	public ScoreVO insert(ScoreVO scoreVO) {
		scoreDAO.insert(scoreVO);
		return scoreVO;

	}
	
	public List<ScoreVO> getwrittes(){
		List<ScoreVO> unreplys =  new ArrayList();
		for(ScoreVO acom : scoreDAO.getAll()){
				unreplys.add(acom);
		
		}// end for
		return unreplys;
	}// end getUnreplySuggestions()

	
	public ScoreVO calculatorAVG(int scoreValue) {
		return scoreDAO.calculatorAVG(scoreValue);


	}
	
	
	
	
	
}
