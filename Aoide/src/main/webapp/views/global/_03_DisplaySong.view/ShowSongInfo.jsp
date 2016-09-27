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
								<a
									href="<c:url value='/BuildPlaylistServlet?id=${songVO.songId}'/>"><svg
										fill="#000000" height="24" viewBox="0 0 24 24" width="24"
										xmlns="http://www.w3.org/2000/svg"> <path
											d="M8 5v14l11-7z" /> <path d="M0 0h24v24H0z" fill="none" /> </svg></a>
								<script type="text/javascript"
									src="http://mediaplayer.yahoo.com/js"></script>

								<button style="background-color: #C2C2FF" title="蒐藏"
									onclick="location.href='<c:url value='/UpdateFavoriteServlet.member'/>'">
									<svg fill="#000000" height="18" viewBox="0 0 18 18" width="18"
										xmlns="http://www.w3.org/2000/svg"> <path
											d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z" />
							<path d="M0 0h18v18H0z" fill="none" /> </svg>
								</button>


								<button style="background-color: #C2C2FF" title="分享"
									onclick="location.href='<c:url value='/ShareServlet.member'/>'">
									<svg fill="#000000" height="18" viewBox="0 0 24 24" width="18"
										xmlns="http://www.w3.org/2000/svg"> <path
											d="M0 0h24v24H0z" fill="none" /> <path
											d="M1 21h4V9H1v12zm22-11c0-1.1-.9-2-2-2h-6.31l.95-4.57.03-.32c0-.41-.17-.79-.44-1.06L14.17 1 7.59 7.59C7.22 7.95 7 8.45 7 9v10c0 1.1.9 2 2 2h9c.83 0 1.54-.5 1.84-1.22l3.02-7.05c.09-.23.14-.47.14-.73v-1.91l-.01-.01L23 10z" />
							</svg>
								</button>


								<button style="background-color: #C2C2FF" title="贊助"
									onclick="location.href='<c:url value=''/>'">
									<svg fill="#000000" height="18" viewBox="0 0 24 24" width="18"
										xmlns="http://www.w3.org/2000/svg"> <g> <path
											d="M0 0h24v24H0z" fill="none" /> <path
											d="M16.49 15.5v-1.75L14 16.25l2.49 2.5V17H22v-1.5z" /> <path
											d="M19.51 19.75H14v1.5h5.51V23L22 20.5 19.51 18z" /> <g> <path
											d="M9.5 5.5c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zM5.75 8.9L3 23h2.1l1.75-8L9 17v6h2v-7.55L8.95 13.4l.6-3C10.85 12 12.8 13 15 13v-2c-1.85 0-3.45-1-4.35-2.45l-.95-1.6C9.35 6.35 8.7 6 8 6c-.25 0-.5.05-.75.15L2 8.3V13h2V9.65l1.75-.75" />
							</g></g> </svg>
								</button>




								<br>

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