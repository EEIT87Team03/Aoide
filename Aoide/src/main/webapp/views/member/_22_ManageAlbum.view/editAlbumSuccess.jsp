<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改成功</title>
</head>
<body>
		<img src="${updateAlbum.coverFilePath}" width="300" height="300">
	<p>
		專輯名稱：${updateAlbum.name}
	<p>
		演出者：${updateAlbum.artist}
	<p>
		歌曲簡介：${updateAlbum.introductionFilePath}
</body>
</html>