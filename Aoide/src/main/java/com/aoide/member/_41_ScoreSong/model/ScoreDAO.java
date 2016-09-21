package com.aoide.member._41_ScoreSong.model;

import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;



public interface ScoreDAO {
	
	public void insert(ScoreVO scoreVO);
    public void update(ScoreVO scoreVO);
    public void delete(Integer memberId,Integer songId);
    public ScoreVO findByPrimaryKey(Integer memberId,Integer songId);
    public List<ScoreVO> getAll();
	public ScoreVO calculatorAVG(int scoreValue);
	void calculatorAVG(ScoreVO scoreValue);
	
	
	

}
