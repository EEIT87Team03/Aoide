<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Member Info</title>
</head>
<body>
	<div>
	<form action="<c:url value='/EditInfoServlet'/>" method="POST" >
		<table>
			<tr>
				<td><label for = "account">Account : </label></td>
				<td><span>${member.account}</span></td>
			</tr>
			<tr>
				<td><label for = "name">Name : </label></td>
				<td><input name="name" type="text" value="${member.name}">${errorMsg.nameError}</td>
			</tr>
			<tr>
				<td><label for = "email">Email : </label></td>
				<td><input  name="email" type="text" value="${member.email}">${errorMsg.emailError}</td>
			</tr>
			<tr>
				<td><label for = "lastLogin">Last Login : </label></td>
				<td><span>${member.lastLoginDate}</span></td>
			</tr>
			<tr>
				<td><label for = "picture">Picture : </label></td>
				<td>
					<div>
						<img id = "current" src="data:image/*;base64,${member.picture}" width="200" height="200">
						<img src="#" id = "preview"  alt = "preview image" width = "200" height = "200" style = "display : none"/>
					</div>	
					<div>
						<input type = "file" id = "selectedFile" accept="image/*" name = "selectedFile">
						<input type = "button" id = "upload" value = "Upload"><span id="progress"></span>
					</div>
				</td>
			</tr>
		</table>
		<p>Introduction: ${errorMsg.introductionError}</p>
		<textarea name="introduction"  id="introduction" rows="10" cols="80" >
           	${member.introductionFilePath}
        </textarea>
           <script>
               // Replace the <textarea id="editor1"> with a CKEditor
               // instance, using default configuration.
               CKEDITOR.replace( 'introduction' );
		   </script>
		<input type="submit" value="Submit">
	</form>
	</div>
	<script src="../../../js/_17_EditInfo/ajaxUploadImage.js"></script>
</body>
</html>