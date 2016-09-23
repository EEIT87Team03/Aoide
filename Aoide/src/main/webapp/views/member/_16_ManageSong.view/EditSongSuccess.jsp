<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改成功</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
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
          
		<img src="${song.coverFile}" width="300" height="300">
	<p>
		歌名：${updateSong.name}
	<p>
		演出者：${updateSong.singer}
	<p>
		類型：${updateSong.songType}
	<p>
		語言：${updateSong.songLanguage}
	<p>
		歌曲簡介：${updateSong.introductionFile}
	<p>
		歌詞：${updateSong.lyricsFile}
	<p>
		<a href="<c:url value = '/ListSongServlet.member'/>">回歌曲列表</a>
		</p>

</div>
</div>
</section>
</div>
</body>
</html>