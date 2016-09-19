<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編輯歌曲</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
正在編輯歌曲：${song.name}<p>
<img src="${song.coverFile}" width="300" height="300"><p>
上傳日期：${song.updateDate}<p>
<hr><p>
<form action="<c:url value ='/UpdateSongServlet'/>" method="post" enctype="multipart/form-data">
			上傳封面圖片：<input type="file" name="coverFile">　${errorMsg.emptyPartMsg}
		<p>
			歌名：<input type="text" name="name" placeholder="${song.name}" value="${enteredText.name}">　${errorMsg.emptyNameMsg}
		<p>
			演出者：<input type="text" name="singer" placeholder="${song.singer}" value="${enteredText.singer}">　${errorMsg.emptySingerMsg}
		<p>
			類型：<input type="text" name="songType" placeholder="${song.songType}" value="${enteredText.songType}">
		<p>
			語言：<input type="text" name="songLanguage" placeholder="${song.songLanguage}" value="${enteredText.songLanguage}">
		<p>
			歌曲簡介：<textarea name="introductionFile" id="introductionFile">${song.introductionFile}${enteredText.introductionFile}</textarea>
			<script>CKEDITOR.replace('introductionFile');</script>
		<p>
			歌詞：<textarea name="lyricsFile" id="lyricsFile">${song.lyricsFile}${enteredText.lyricsFile}</textarea>
			<script>CKEDITOR.replace('lyricsFile');</script>
		<p>
			<input type="submit" value="送出">
</form>
<p>
<a href="<c:url value = '/ListSongServlet'/>">回歌曲列表</a>
</body>
</html>