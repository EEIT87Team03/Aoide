<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編輯歌曲</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>歌曲ID</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
				<th>動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mySong" items="${mySongList}">
				<tr>
					<td>${mySong.songId}</td>
					<td>${mySong.name}</td>
					<td>${mySong.singer}</td>
					<td>${mySong.songType}</td>
					<td>${mySong.songLanguage}</td>
					<td>${mySong.updateDate}</td>
					<td>
						<input type="button" value="編輯" onclick="location.href='<c:url value='/editSongServlet?id=${mySong.songId}'/>'">　
						<input type="button" value="刪除" onclick="location.href='<c:url value='/deleteSongServlet?id=${mySong.songId}'/>'">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>