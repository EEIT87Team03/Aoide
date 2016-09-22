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
<% int i = 0; %>
	<table class="table">
		<thead>
			<tr>
				<th>　</th>
				<th>專輯ID</th>
				<th>專輯名稱</th>
				<th>演出者</th>
				<th>建立日期</th>
				<th>動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="myAlbum" items="${myAlbumList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td>${myAlbum.albumId}</td>
					<td>${myAlbum.name}</td>
					<td>${myAlbum.artist}</td>
					<td>${myAlbum.updateDate}</td>
					<td><input type="button" value="編輯" onclick="location.href='<c:url value='/EditAlbumServlet.member?id=${myAlbum.albumId}'/>'">　
						<input type="button" value="刪除" onclick="location.href='<c:url value='/DeleteAlbumServlet.member?id=${myAlbum.albumId}'/>'">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
	<a href="ManageAlbum.jsp">回管理專輯</a>
</body>
</html>