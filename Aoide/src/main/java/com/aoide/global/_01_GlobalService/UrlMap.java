package com.aoide.global._01_GlobalService;

import java.util.HashMap;

public class UrlMap extends HashMap<String,String>  {
	// Fields
	private String root;  
	private String folder;  
	
	// Constructors
	public UrlMap(String root, String folder) {
		super();
		this.root = "/" + root;
		this.folder = "/" + folder;
	}
	
	// Methods
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = "/" + root;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = "/" + folder;
	}
	public void addUrl(String key, String file){
		String url = root + folder + "/" + file;
		this.put(key, url);
	}

	public static void main(String[] args) {
		UrlMap urls = new UrlMap("member", "_99_TestUpload.view");
		urls.addUrl("chechUpload", "checkUpload.jsp");
		System.out.println(urls.get("chechUpload"));
		
	}
}
