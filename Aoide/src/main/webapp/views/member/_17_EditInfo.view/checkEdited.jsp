<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
	<title>Edit Member Info</title>
</head>
<body>
	<div>
		<p>memberId: ${member.memberId }</p>
		<p>Account: ${member.account }</p>
		<p>name: ${member.name }</p>
		<p>email: ${member.email }</p>
	<%-- 			<p>picture: ${member.picture }</p> --%>
		<p>introductionFilePath: ${member.introductionFilePath }</p>
		<p>bankInfo: ${member.bankInfo }</p>
		<input type = "reset" value = "Reset">
		<input type = "submit" value = "Submit">
	</div>	
</body>
</html>