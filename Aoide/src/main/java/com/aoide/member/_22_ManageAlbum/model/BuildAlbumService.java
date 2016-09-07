package com.aoide.member._22_ManageAlbum.model;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;

public class BuildAlbumService {
	AlbumService albumService = new AlbumService();
	private AlbumService service = null;
	
	public BuildAlbumService(){
		this.service = new AlbumService();
	}

	public Integer insertBuildAlbum(AlbumVO albumVO) {
		return albumService.createNewAlbum(albumVO);
	}

	public void updatePath(AlbumVO album) {
		service.updateAlbumContent(album);		
	}

	public AlbumVO checkUpload(int id) {
		return service.getAlbumBean(id);
	}

}
