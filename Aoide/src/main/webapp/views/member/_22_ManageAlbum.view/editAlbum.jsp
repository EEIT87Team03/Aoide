<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編輯專輯</title>
</head>
<body>
正在編輯專輯：${aAlbum.name}<p>
<img src="${aAlbum.coverFilePath}" width="300" height="300"><p>
上傳日期：${aAlbum.updateDate}<p>
<hr><p>
<form action="<c:url value ='/UpdateAlbumServlet'/>" method="post" enctype="multipart/form-data">
			上傳專輯封面：<input type="file" name="coverFile">
		<p>
			專輯名稱：<input type="text" name="name" placeholder="${aAlbum.name}">
		<p>
			演出者：<input type="text" name="artist" placeholder="${aAlbum.artist}">
		<p>
			專輯簡介：<textarea name="introductionFile" id="introductionFile">${aAlbum.introductionFilePath}</textarea>
			<!-- <script>CKEDITOR.replace('introductionFile');</script> -->
		<p>
			<input type="submit" value="送出">
</form>
</body>
</html>