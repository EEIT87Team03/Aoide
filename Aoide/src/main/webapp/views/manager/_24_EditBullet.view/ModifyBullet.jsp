<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ModifyBullet</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
<h3>Modify</h3>
	<form action="<c:url value ='/ModifyEditBullet'/>" method="post">
		
		          日期：${bulletVO.date}<p>
			
			contentFile：<input type="text" name="contentFile" value="${bulletVO.contentFile}"><p>
			
			title：<textarea name="title" id="title">${bulletVO.title}</textarea>
			<script>CKEDITOR.replace('introductionFile');</script><p>
			
			<input type="submit" value="送出"> <input type="reset"
				value="清除">
	</form>
	<a href="<c:url value ='/EditBulletList'/>">回列表頁</a>
</body>
</html>