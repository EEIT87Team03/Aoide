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
				<th>專輯ID</th>
				<th>專輯名稱</th>
				<th>演出者</th>
				<th>上傳日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${searchList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td>${result.albumId}</td>
					<td>${result.name}</td>
					<td>${result.artist}</td>
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