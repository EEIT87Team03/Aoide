package com.aoide.member._22_ManageAlbum.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;

public class ListAlbumService {
	AlbumService albumService = new AlbumService();
	
	public ListAlbumService(){
		
	}
	
	public List<AlbumVO> getMyAlbum() {
		List<AlbumVO> myAlbumResult = new ArrayList();
		for (AlbumVO myAlbum : albumService.getAllAlbumBeans()) {
			if (myAlbum.getMemberId() == 1) {
				myAlbumResult.add(myAlbum);
			}
		}
		return myAlbumResult;
	}

}
