<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload-Task</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
	<form action="<c:url value ='/UploadEditTask'/>" method="post">
		
	    name：<input type="text" name="Name"><p>
        contentFile：<textarea name="contentFile" id="contentFile"></textarea>
		<script>CKEDITOR.replace('introductionFile');</script><p>
		reward：<input type="text" name="reward"><p>
		periodHour：<input type="text" name="periodHour"><p>
		beginDate：<input type="text" name="beginDate"><p>
		closeDate：<input type="text" name="closeDate"><p>
		
        <input type="submit" value="送出">
        <input type = "reset" value = "清除">
	
	</form>
</body>
</html>