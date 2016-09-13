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
	<form action="<c:url value ='/BuildAlbumServlet'/>" method="post" enctype="multipart/form-data">
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
			<input type="submit" value="送出">
	</form>
</body>
</html>