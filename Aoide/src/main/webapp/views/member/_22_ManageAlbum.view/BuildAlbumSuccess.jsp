<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建立成功</title>
</head>
<body>
<% int i = 0; %>
		<img src="${album.coverFilePath}" width="300" height="300">
	<p>
		專輯名稱：${album.name}
	<p>
		演出者：${album.artist}
	<p>
		專輯簡介：${album.introductionFilePath}
	<p>
		建立日期：${album.updateDate}
	<p>
	<hr>
	<p>
		已加入專輯的歌曲：
	<p>
	<table class="table">
		<thead>
			<tr>
				<th>　</th>
				<th>歌曲ID</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mySong" items="${upSongS}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
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
	<p>
	<a href="ManageAlbum.jsp">回管理專輯</a>
</body>
</html>