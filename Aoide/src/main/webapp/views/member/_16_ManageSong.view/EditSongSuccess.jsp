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
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
				<!-- Main content -->
			    <section class="content">
			      <!-- Default box -->
			      <div class="box">
						<div class="box-header">
							<h3 class="box-title"><b>本次修改紀錄</b></h3>
						</div>
			            <div class="box-body">
							<img src="${updateSong.coverFile}" width="300" height="300">
							<hr>
							<label>歌名：${updateSong.name}</label>
							<hr>
							<label>演出者：${updateSong.singer}</label>
							<hr>
							<label>類型：${updateSong.songType}</label>
							<hr>
							<label>語言：${updateSong.songLanguage}</label>
							<hr>
							<label>歌曲簡介：${updateSong.introductionFile}</label>
							<hr>
							<label>歌詞：${updateSong.lyricsFile}</label>
						 </div>
			             <!-- /.box-body -->
			        <!-- /.box-footer-->
			      </div>
			      <!-- /.box -->
			    </section>
			    <!-- /.content -->
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>