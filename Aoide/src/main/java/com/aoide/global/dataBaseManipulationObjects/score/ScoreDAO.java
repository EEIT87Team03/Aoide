package com.aoide.global.dataBaseManipulationObjects.score;

import java.util.List;



public interface ScoreDAO {
	
	public void insert(ScoreVO scoreVO);
    public void update(ScoreVO scoreVO);
    public void delete(Integer memberId,Integer songId);
    public ScoreVO findByPrimaryKey(Integer memberId,Integer songId);
    public List<ScoreVO> getAll();
	
	

}
