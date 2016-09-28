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
								<a
									href="<c:url value='/BuildPlaylist?songId=${songVO.songId}'/>"><svg
										fill="#000000" height="24" viewBox="0 0 24 24" width="40"
										xmlns="http://www.w3.org/2000/svg"> <path
											d="M8 5v14l11-7z" /> <path d="M0 0h24v24H0z" fill="none" /> </svg></a>
								<script type="text/javascript"
									src="http://mediaplayer.yahoo.com/js"></script>

								<button style="background-color: #C2C2FF" title="蒐藏"
									onclick="location.href='<c:url value='/UpdateFavoriteServlet.member'/>'">
							<img src="http://www.miankoutu.com/uploadfiles/2015-11-20/2015112022522988.png">
								</button>


								<button style="background-color: #C2C2FF" title="分享"
									onclick="location.href='<c:url value='/ShareServlet.member'/>'">
							<img src="http://www.miankoutu.com/uploadfiles/2015-11-20/2015112022832588.png">
								</button>


								<button style="background-color: #C2C2FF" title="贊助"
									onclick="location.href='<c:url value=''/>'">
								<img src="http://www.miankoutu.com/uploadfiles/2016-4-10/sky_1_9.png">
								</button>
						



								<br>
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

											<button style="background-color: #C2C2FF" title="check out!"
												onclick="location.href='<c:url value='/GetSongInfo.member'/>'">
									       <Img Src="http://www.miankoutu.com/uploadfiles/2016-4-13/august_24_3.png">
											</button>&nbsp評分評論
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
											</div>

											<!-- body-library  -->
											<c:import url="/TestHTML/body_library.html" />
											<!-- Go to www.addthis.com/dashboard to customize your tools -->
<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-57ea63172c50a682"></script>
											
</body>
</html>