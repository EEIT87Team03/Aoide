<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
    
    No :${bulletVO.bulletId}<p>
	Date：${bulletVO.date}<p>
	ContentFile：${bulletVO.contentFile}<p>
	Title：${bulletVO.title}<p>
	
	<a href="<c:url value ='/EditBulletList'/>">回上一頁</a>
	
</body>
</html>