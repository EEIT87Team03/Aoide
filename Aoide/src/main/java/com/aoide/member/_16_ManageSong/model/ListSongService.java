package com.aoide.member._16_ManageSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class ListSongService {
	SongDAO songDAO = new JdbcSongDAO();
	
	public ListSongService(){
		
	}
	
	public List<SongVO> getMySong() {
		List<SongVO> mySongResult = new ArrayList();
		for (SongVO mySong : songDAO.getAll()) {
			if (mySong.getMemberId() == 1) {
				mySongResult.add(mySong);
			}
		}
		return mySongResult;
	}
	
	public List<SongVO> getMyAlbumSong() {
		List<SongVO> mySongResult = new ArrayList();
		for (SongVO mySong : songDAO.getAll()) {
			if (mySong.getMemberId() == 1 && mySong.getAlbumId() == 1) {
				mySongResult.add(mySong);
			}
		}
		return mySongResult;
	}
	
	public void updateSong(SongVO songVO) {
		songDAO.update(songVO);
	}
	
	public SongVO getSongById(Integer songId){
		return songDAO.findByPrimaryKey(songId);
	}
	
	public void deleteSong(Integer songId) {
		songDAO.delete(songId);
	}

}
