<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
  <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
<title>編輯歌曲</title>
</head>
<body>
<div class="wrapper">
    <section class="content">
    <div class="row">
           <div class="col-md-2">
        </div>
         <div class="col-md-8">
                <div class="box">
		         <div class="box-header with-border">
		         <div class="box-body">
<% int i = 0; %>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>　</th>
				<th>歌曲ID</th>
				<th>歌名</th>
				<th>演出者</th>
				<th>類型</th>
				<th>語言</th>
				<th>上傳日期</th>
				<th>動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mySong" items="${mySongList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td>${mySong.songId}</td>
					<td>${mySong.name}</td>
					<td>${mySong.singer}</td>
					<td>${mySong.songType}</td>
					<td>${mySong.songLanguage}</td>
					<td>${mySong.updateDate}</td>
					<td>
						<input type="button" value="編輯" onclick="location.href='<c:url value='/EditSongServlet.member?id=${mySong.songId}'/>'">　
						<input type="button" value="刪除" onclick="location.href='<c:url value='/DeleteSongServlet.member?id=${mySong.songId}'/>'">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ManageSong.jsp">回管理歌曲</a>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</section>
</body>
</html>