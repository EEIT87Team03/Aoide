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
				        <div class="box-header with-border">
				        <table class="table">
				        <thead>
    							<tr>
									<th>歌曲ID</th>
									<th>歌曲名稱</th>
									<th>歌手</th>
									<th>專輯</th>
									<th>上傳日期</th>
									
									
								</tr>
    					</thead>
    					<br>
    					<tbody>
							
									<tr>
 										<td>${songVO.songId}</td>
										<td>${songVO.name}</td>
										<td>${songVO.singer}</td>
										<td>${songVO.albumId}</td>
										<td>${songVO.updateDate}</td>
										 <table class="table"></table>
										 <h4>專輯</h4> 
										 <table class="table">
										<td><img src='${songVO.coverFile}'></td>
										<br>
										<table class="table">
										<th>歌曲簡介</th>
										<td>${songVO.introductionFile}</td>
									</tr>
								
    						</tbody>
    					</table>
		    				
    				<br>
    				
    				<table>平均分數 : ${value.scoreValue}</table>
    				<br>
    							<table class="table">
									<thead>
										<tr>
											<th>會員</th>
											<th>日期</th>
											<th>評分</th>
											<th>評論</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="ScoreVO" items="${comments}">
											<tr>
												<td>${ScoreVO.memberId}</td>
												<td>${ScoreVO.date}</td>
												<td>${ScoreVO.scoreValue}</td>
												<td>${ScoreVO.comment}</td>

											</tr>

										</c:forEach>
									</tbody>
								</table>
       
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>