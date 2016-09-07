<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳成功</title>
</head>
<body>
	<embed src="${songVO.songFile}" autostart="false"><!-- chrome預設開啟，設false也沒用 -->
	<p>
		<img src="${songVO.coverFile}" width="300" height="300">
	<p>
		歌名：${songVO.name}
	<p>
		類型：${songVO.songType}
	<p>
		語言：${songVO.songLanguage}
	<p>
		歌曲簡介：${songVO.introductionFile}
	<p>
		歌詞：${songVO.lyricsFile}
	<p>
		上傳日期：${songVO.updateDate}
</body>
</html>