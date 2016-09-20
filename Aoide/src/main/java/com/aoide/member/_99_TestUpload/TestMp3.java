package com.aoide.member._99_TestUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;


public class TestMp3 {

	public static void main(String[] args) {
		File file = new File("‪C:/Aoide/files/song_files/Songid2.mp3");
		
		System.out.println("path: " + file.getPath());
		
		AudioFileFormat baseFileFormat = null;
		try {
			baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map properties = baseFileFormat.properties();
		Long duration = (Long) properties.get("duration");
		
		System.out.println("duration: " + duration);
		
		
	}

}
