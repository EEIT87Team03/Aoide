package com.aoide.global.dataBaseManipulationObjects.score;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;



public interface ScoreDAO {
	
	public void insert(ScoreVO scoreVO);
    public void update(ScoreVO scoreVO);
    public void delete(Integer memberId,Integer songId);
    public ScoreVO findByPrimaryKey(Integer songId);
    public List<ScoreVO> getAll();
	public ScoreVO calculatorAVG(int scoreValue);
	void calculatorAVG(ScoreVO scoreValue);
//	public ScoreVO findBySong(Integer songId);
	public List<ScoreVO> getScoreSongById(Integer songId);
	

}
