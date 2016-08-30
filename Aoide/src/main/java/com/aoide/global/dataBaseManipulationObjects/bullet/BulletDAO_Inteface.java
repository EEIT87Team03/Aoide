package com.aoide.global.dataBaseManipulationObjects.bullet;

import java.util.*;

    public interface BulletDAO_Inteface {
    	public void insert(BulletVO bulletVO);
    	public void update(BulletVO bulletVO);
    	public void delete(Integer bullet_id);
    	public BulletVO findByPrimaryKey(Integer bullet_id);
    	public List<BulletVO> getAll();
    }