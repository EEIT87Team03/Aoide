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
	
	public List<SongVO> getMySong(Integer memberId) {
		List<SongVO> mySongResult = new ArrayList();
		for (SongVO mySong : songDAO.getAll()) {
			//改會員時看這裡
			if (mySong.getMemberId() == memberId) {
				//改會員時看這裡
				mySongResult.add(mySong);
			}
		}
		return mySongResult;
	}
	
	public List<SongVO> getMyAlbumSong(Integer memberId) {
		List<SongVO> mySongResult = new ArrayList();
		for (SongVO mySong : songDAO.getAll()) {
			//改會員時看這裡
			if (mySong.getMemberId() == memberId && mySong.getAlbumId() == 1) {
				//改會員時看這裡
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
