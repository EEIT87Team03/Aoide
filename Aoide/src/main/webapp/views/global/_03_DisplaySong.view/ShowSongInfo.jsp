<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html" />
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

											<button style="background-color: #C2C2FF" title="評分"
												onclick="location.href='<c:url value='//GetSongInfo.member'/>'">
												<svg fill="#000000" height="24" viewBox="0 0 24 24"
													width="24" xmlns="http://www.w3.org/2000/svg">
    <path d="M0 0h24v24H0z" fill="none" />
    <path
														d="M7 14c-1.66 0-3 1.34-3 3 0 1.31-1.16 2-2 2 .92 1.22 2.49 2 4 2 2.21 0 4-1.79 4-4 0-1.66-1.34-3-3-3zm13.71-9.37l-1.34-1.34c-.39-.39-1.02-.39-1.41 0L9 12.25 11.75 15l8.96-8.96c.39-.39.39-1.02 0-1.41z" />
</svg>
											</button>
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
											<c:import url="/TestHTML/body_library.html" />
</body>
</html>