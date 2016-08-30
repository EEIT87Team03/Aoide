package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.util.List;

public interface AccusementDanmukuDAO {
	public void insert(AccusementDanmukuVO accusementDanmukuVO);
	public void update(AccusementDanmukuVO accusementDanmukuVO);
	public void delete(Integer accusementDanmukuId);
	public AccusementDanmukuVO findByPrimaryKey(Integer accusementDanmukuId);
	public List<AccusementDanmukuVO> getAll();
}
