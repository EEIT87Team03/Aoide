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
<title>上傳歌曲</title>
</head>
<body>
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
			<form role="form" action="<c:url value ='/UploadSongServlet.member'/>" method="post" enctype="multipart/form-data">
			<label>上傳歌曲：</label><input type="file" name="songFile">　${errorMsg.emptyPartMsg}
		<hr>
			<label>上傳封面圖片：</label><input type="file" name="coverFile">　${errorMsg.emptyPart2Msg}
		<hr>
			<label>歌名：</label><input type="text" name="name" value="${enteredText.name}">　${errorMsg.emptyNameMsg}
		<hr>
			<label>演出者：</label><input type="text" name="singer" value="${enteredText.singer}">　${errorMsg.emptySingerMsg}
		<hr>
			<label>類型：</label><input type="text" name="songType" value="${enteredText.songType}">
		<hr>
			<label>語言：</label><input type="text" name="songLanguage" value="${enteredText.songLanguage}">
		<hr>
			<label>歌曲簡介：</label><textarea name="introductionFile" id="introductionFile">${enteredText.introductionFile}</textarea>
			<script>CKEDITOR.replace('introductionFile');</script>
		<hr>
			<label>歌詞：</label><textarea name="lyricsFile" id="lyricsFile">${enteredText.lyricsFile}</textarea>
			<script>CKEDITOR.replace('lyricsFile');</script>
		<hr>
			<input type="submit" value="送出">
	</form>
	<p>
	<a href="/Aoide/views/member/_16_ManageSong.view/ManageSong.jsp">回管理歌曲</a>
	
        </div>
        <!-- /.box-body -->
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