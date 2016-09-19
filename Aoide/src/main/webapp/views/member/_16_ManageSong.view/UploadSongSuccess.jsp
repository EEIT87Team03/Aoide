<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳成功</title>
</head>
<body>
		<embed src="${song.songFile}" autostart="false"><!-- chrome預設開啟，設false也沒用 -->
	<p>
		<img src="${song.coverFile}" width="300" height="300">
	<p>
		歌名：${song.name}
	<p>
		演出者：${song.singer}
	<p>
		類型：${song.songType}
	<p>
		語言：${song.songLanguage}
	<p>
		歌曲簡介：${song.introductionFile}
	<p>
		歌詞：${song.lyricsFile}
	<p>
		上傳日期：${song.updateDate}
	<p>
		<a href="ManageSong.jsp">回管理歌曲</a>
</body>
</html>