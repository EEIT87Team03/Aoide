package com.aoide.global.listener;

import com.aoide.global.websocket.track.TrackVO;

public interface PlaylistListener 
{
	public void listen();
	public void update( TrackVO vo );
}
