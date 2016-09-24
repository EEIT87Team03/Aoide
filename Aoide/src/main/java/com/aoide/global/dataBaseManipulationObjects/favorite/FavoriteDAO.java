package com.aoide.global.dataBaseManipulationObjects.favorite;

import java.util.List;

public interface FavoriteDAO {
	
	public void insert(FavoriteVO favoriteVO);
    public void update(FavoriteVO favoriteVO);
    public void delete(Integer memberId,Integer songId);
    public FavoriteVO findByPrimaryKey(Integer memberId,Integer songId);
    public List<FavoriteVO> finByMemberId(Integer memberId);
    public List<FavoriteVO> getAll();
    public FavoriteVO getFavoritesBySong(Integer songId);

}
