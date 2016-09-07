<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Member Info</title>
</head>
<body>
	<form action="<c:url value='/CreateAccount'/>" method="post">
		<p>Name : <input type="text" name="name" value="${enteredText.name}"> ${errorMsg.nameError}</p>
		<p>Email : <input type="text" name="email" value="${enteredText.email}"> ${errorMsg.emailError}</p>
		<p>Account : <input type="text" name="account" value="${enteredText.account}"> ${errorMsg.accountError}</p>
		<p>Password : <input type="password" name="password" value="${enteredText.password}"> ${errorMsg.passwordError}</p>
		<p><input type="submit" value="submit"></p>
	</form>
</body>
</html>