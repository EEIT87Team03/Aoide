<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理專輯</title>
</head>
<body>
	<a href="<c:url value = '/BuildAlbumServlet'/>">建立專輯</a>
	<p>
	<a href="<c:url value = '/ListAlbumServlet'/>">編輯專輯</a>
</body>
</html>