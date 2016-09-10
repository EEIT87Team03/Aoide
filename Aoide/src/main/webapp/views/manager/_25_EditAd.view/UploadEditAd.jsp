<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>

	<form action="<c:url value='/InsertAdds'/>" method="post"
		enctype="multipart/form-data">
		上傳封面圖片：<input type="file" name="AdImage">
		<p>
			<!-- 		專輯編號：<input type="text" name="ImageId"><p> -->
			<input type="submit" value="送出">
						
	</form>
</body>
</html>