<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編輯專輯</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>專輯ID</th>
				<th>專輯名稱</th>
				<th>演出者</th>
				<th>上傳日期</th>
				<th>動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="myAlbum" items="${myAlbumList}">
				<tr>
					<td>${myAlbum.albumId}</td>
					<td>${myAlbum.name}</td>
					<td>${myAlbum.artist}</td>
					<td>${myAlbum.updateDate}</td>
					<td><input type="button" value="編輯" onclick="location.href='<c:url value='/editAlbumServlet?id=${myAlbum.albumId}'/>'">　
						<input type="button" value="刪除" onclick="location.href='<c:url value='/deleteAlbumServlet?id=${myAlbum.albumId}'/>'">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>