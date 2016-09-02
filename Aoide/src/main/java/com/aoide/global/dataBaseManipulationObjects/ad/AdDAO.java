package com.aoide.global.dataBaseManipulationObjects.ad;

import java.util.*;

       public interface AdDAO {
	      public void insert(AdVO adVO);
	      public void update(AdVO adVO);
	      public void delete(Integer song_id);
	      public AdVO findByPrimaryKey(Integer song_id);
	      public List<AdVO> getAll();
       }


