<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
<title>index</title>
</head>
<body>
<% int i = 0; %>
<!-- Site wrapper -->
<div class="wrapper">


    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
<!--         <div class="box-header with-border"> -->
<!--           <h3 class="box-title">Title</h3> -->

<!--           <div class="box-tools pull-right"> -->
<!--             <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse"> -->
<!--               <i class="fa fa-minus"></i></button> -->
<!--             <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"> -->
<!--               <i class="fa fa-times"></i></button> -->
<!--           </div> -->
<!--         </div> -->
        <div class="box-body">
        
        	<img src="${updateAlbum.coverFilePath}" width="300" height="300">
	<p>
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
				<th>歌曲ID</th>
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
					<td>${mySong.songId}</td>
					<td>${mySong.name}</td>
					<td>${mySong.singer}</td>
					<td>${mySong.songType}</td>
					<td>${mySong.songLanguage}</td>
					<td>${mySong.updateDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
	<a href="<c:url value = '/ListAlbumServlet.member'/>">回專輯列表</a>
        
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>