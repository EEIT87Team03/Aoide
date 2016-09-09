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
	<form action="<c:url value ='/ModifyEditBullet'/>" method="post">
		
<!-- 		date：<input type="text" name="date"><p> -->
	    No：<input type="text" name="bulletId"><p>
	    contentFile：<input type="text" name="contentFile"><p>
        title：<textarea name="title" id="title"></textarea>
		<script>CKEDITOR.replace('introductionFile');</script><p>
        <input type="submit" value="送出">
        <input type = "reset" value = "清除">
	
	</form>
</body>
</html>