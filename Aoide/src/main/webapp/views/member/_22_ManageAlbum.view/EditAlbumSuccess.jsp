<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
</head>
<body>
<% int i = 0; %>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
            <section class="content">
			<div class="box">
<div class="box-header">
							<h3 class="box-title"><b>本次修改紀錄</b></h3>
						</div>
        <div class="box-body">
        
        	<img src="${updateAlbum.coverFilePath}" width="300" height="300">
	<p><p>
		<label>專輯名稱：${updateAlbum.name}</label>
	<p>
		<label>演出者：${updateAlbum.artist}</label>
	<p>
		<label>專輯簡介：${updateAlbum.introductionFilePath}</label>
	<p>
	<hr>
	<p>
		<label>已加入專輯的歌曲：</label>
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
        </div>
        <!-- /.box-body -->
      </div>
            </section>
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>