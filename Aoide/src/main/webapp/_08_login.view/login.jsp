<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<form action = "/Aoide/Login" method = "post">
			<label for = "account">Account : </label>
			<input type = "text" name = "account" id = "account" value="${enteredText.account }" required>${errorMsg.accountError}<br>
			<label for = "password">Password : </label>
			<input type = "password" name = "password" id = "password" required>${errorMsg.passwordError}<br>
			<input type = "reset" value = "Reset">
			<input type = "submit" value = "Submit">
		</form>	
	</div>																																																		
</body>
</html>