<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上傳測試</title>
</head>
<body>
	
	<form action="<c:url value='/InsertAdds'/>" method="post" enctype="multipart/form-data">
		上傳歌曲：<input type="file" name="songFile"><p>
		歌名：<input type="text" name="name"><p>
		<input type="submit" value="送出">
	</form>
</body>
</html>