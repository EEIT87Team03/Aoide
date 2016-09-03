<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Result</title>
</head>
<body>
	<p>SongId : ${song.songId}</p>
	<p>SongName : ${song.name}</p>
	<p>SongFile : ${song.songFile}</p>
	<audio src="<c:url value='${song.songFile}'/>">Play</audio>
</body>
</html>