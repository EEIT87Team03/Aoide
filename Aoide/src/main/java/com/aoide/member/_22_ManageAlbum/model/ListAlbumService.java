package com.aoide.member._22_ManageAlbum.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;

public class ListAlbumService {
	AlbumService albumService = new AlbumService();
	
	public ListAlbumService(){
		
	}
	
	public List<AlbumVO> getMyAlbum(Integer memberId) {
		List<AlbumVO> myAlbumResult = new ArrayList();
		
		for (AlbumVO myAlbum : albumService.getAllAlbumBeans()) {
			//改會員時看這裡
			if (myAlbum.getMemberId().equals(memberId)) {
				//改會員時看這裡
				myAlbumResult.add(myAlbum);
			}
		}
		return myAlbumResult;
	}
	
	public void updateAlbum(AlbumVO vo) {
		albumService.updateAlbumContent(vo);
	}

	public AlbumVO getAlbumById(int id) {
		return albumService.getAlbumBean(id);
	}

	public void deleteAlbum(Integer albumId) {
		albumService.deleteAlbum(albumId);		
	}

}
