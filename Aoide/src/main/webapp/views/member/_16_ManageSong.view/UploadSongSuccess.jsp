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
<title>上傳成功</title>
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
							<div class="box-header">
								<h3 class="box-title"><b>本次上傳紀錄</b></h3>

							</div>

        <div class="box-body">
		<embed style="background-color:white"src="${song.songFile}" autostart="false"><!-- chrome預設開啟，設false也沒用 -->
	<hr>
		<img src="${song.coverFile}" width="300" height="300">
	<hr>
		<label>歌名：${song.name}</label>
	<hr>
		<label>演出者：${song.singer}</label>
	<hr>
		<label>類型：${song.songType}</label>
	<hr>
		<label>語言：${song.songLanguage}</label>
	<hr>
		<label>歌曲簡介：${song.introductionFile}</label>
	<hr>
		<label>歌詞：${song.lyricsFile}</label>
	<hr>
		<label>上傳日期：${song.updateDate}</label>
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