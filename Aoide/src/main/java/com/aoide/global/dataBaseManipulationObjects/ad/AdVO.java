package com.aoide.global.dataBaseManipulationObjects.ad;


public class AdVO {
	private Integer songId;
	private String adImg;
	public AdVO() {
	}
	public AdVO(Integer songId, String adImg) {
		this.songId = songId;
		this.adImg = adImg;

	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
}
