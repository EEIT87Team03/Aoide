<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜尋結果</title>
</head>
<body>
${type1}
<% int i = 0; %>
	<table class="table">
		<thead>
			<tr>
				<th>　</th>
				<th>點歌</th>
				<th>歌曲ID</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${searchList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td><a href="<c:url value='/BuildPlaylistServlet?id=${result.songId}'/>">點歌</a></td>
					<td>${result.songId}</td>
					<td><a href="<c:url value='/ShowSongInfo?id=${result.songId}'/>">${result.name}</a></td>
					<td>${result.singer}</td>
					<td>${result.songType}</td>
					<td>${result.songLanguage}</td>
					<td>${result.updateDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	共有<% out.print(i); %>項符合搜尋結果
	<p>
	<a href="SearchSong.jsp">回搜尋歌曲</a>
</body>
</html>