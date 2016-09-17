<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改成功</title>
</head>
<body>
		<img src="${song.coverFile}" width="300" height="300">
	<p>
		歌名：${updateSong.name}
	<p>
		演出者：${updateSong.singer}
	<p>
		類型：${updateSong.songType}
	<p>
		語言：${updateSong.songLanguage}
	<p>
		歌曲簡介：${updateSong.introductionFile}
	<p>
		歌詞：${updateSong.lyricsFile}
	<p>
		<a href="<c:url value = '/ListSongServlet'/>">回歌曲列表</a>
</body>
</html>