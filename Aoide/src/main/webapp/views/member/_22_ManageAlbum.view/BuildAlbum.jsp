<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建立專輯</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
	<form action="<c:url value ='/BuildAlbumSuccessServlet'/>" method="post" enctype="multipart/form-data">
			上傳專輯封面：<input type="file" name="coverFile">
		<p>
			專輯名稱：<input type="text" name="name">
		<p>
			演出者：<input type="text" name="artist">
		<p>
			專輯簡介：
			<textarea name="introductionFile" id="introductionFile"></textarea>
			<script>CKEDITOR.replace('introductionFile');</script>
		<p>
		<hr>
		<p>
			請選擇要加入專輯的歌曲：
		<p>
		<table class="table">
		<thead>
			<tr>
				<th>加入</th>
				<th>歌曲ID</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mySong" items="${mySongList}">
				<tr>
					<td><input type="checkbox" name="check" value="${mySong.songId}"></td>
					<td>${mySong.songId}</td>
					<td>${mySong.name}</td>
					<td>${mySong.singer}</td>
					<td>${mySong.songType}</td>
					<td>${mySong.songLanguage}</td>
					<td>${mySong.updateDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			<input type="submit" value="送出">
	</form>
</body>
</html>