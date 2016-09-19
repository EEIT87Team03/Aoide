<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜尋歌曲</title>
</head>
<body>
	<form action="<c:url value ='/SearchSongServlet'/>" method="post">
		搜尋：<input type="text" name="searchSong">　
		<input type="submit" value="送出">
		<p>
		<input type="radio" name="searchType" value="name" checked>搜尋歌名　
		<input type="radio" name="searchType" value="singer">搜尋歌手
	</form>
</body>
</html>