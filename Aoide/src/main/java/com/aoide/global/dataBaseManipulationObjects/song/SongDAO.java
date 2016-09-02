package com.aoide.global.dataBaseManipulationObjects.song;

import java.util.List;

public interface SongDAO {
	public void insert(SongVO songVO);
	public void update(SongVO songVO);
	public void delete(Integer songId);
	public SongVO findByPrimaryKey(Integer songId);
	public List<SongVO> getAll();
}
