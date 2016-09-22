package com.aoide.member._13_ShareSong.model;

import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.song.JdbcSongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongDAO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;

public class ShareService {
	
	SongDAO songDAO = new JdbcSongDAO();

	


	
	public Integer insert(SongVO songVO) {
		return songDAO.insert(songVO);
	} {

		
	}
	
	
	
	public SongVO findByKey(Integer shares) {
		
		SongVO share = songDAO.findByPrimaryKey(shares);
		share.setShares((share.getShares() + 1));
		songDAO.update(share);
		return share;
		

		
	}
	
	
	

	public List<SongVO> getAllId(int songId) {

		List<SongVO> song = new ArrayList<SongVO>();

		for (SongVO songshareVO : songDAO.getAll()) {

			song.add(songshareVO);

		}

		{

		}
		return song;

	}
}

