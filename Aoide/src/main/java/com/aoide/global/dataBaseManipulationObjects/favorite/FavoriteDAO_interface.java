package com.aoide.global.dataBaseManipulationObjects.favorite;

import java.util.List;

public interface FavoriteDAO_interface {
	
	public void insert(FavoriteVO favoriteVO);
    public void update(FavoriteVO favoriteVO);
    public void delete(Integer memberId,Integer songId);
    public FavoriteVO findByPrimaryKey(Integer memberId,Integer songId);
    public List<FavoriteVO> getAll();
	
	
	

}
