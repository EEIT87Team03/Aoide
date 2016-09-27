<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>刪除成功</title>
</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
				<div class="box">
<% int i = 0; %>
	刪除成功!!
<p>
		<hr>
		<p>
			已從刪除專輯裡移入未分類的歌曲：
		<p>
		<table class="table">
		<thead>
			<tr>
				<th>　</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mySong" items="${mySongList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td>${mySong.name}</td>
					<td>${mySong.singer}</td>
					<td>${mySong.songType}</td>
					<td>${mySong.songLanguage}</td>
					<td>${mySong.updateDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
						<!-- ========================================= -->
				</div>
				<div class="col-xs-6 col-md-3"></div>
			</div>
		</div>
</div>
		<!-- body-library  -->
		<c:import url="/TestHTML/body_library.html" />
</body>
</html>