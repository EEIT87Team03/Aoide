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


<script type="text/javascript">



function play( event )
{ 		  
	event.preventDefault();
	xhr = new XMLHttpRequest();

	xhr.onload = 
		function() 
	 	{ 
			if ( this.status == 200 ) 
			{

// 				alert( this.responseText );

				console.log( this.responseText );

			}
			
			
			
			
		};

// 		xhr.open( "get", "/Aoide/BuildPlaylist?songId="+ '${songVO.songId}',false);
// 		xhr.send();


	xhr.open( "get", "/Aoide/BuildPlaylist?songId=" + '${songVO.songId}', true );
	xhr.send();

} 

</script>		


	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
				<!-- Main content -->
				<section class="content">
					<!-- Default box -->
					<div class="box">

					

							<button style="background-color: #C2C2FF" title="蒐藏" onclick="location.href='<c:url value='/UpdateFavoriteServlet.member'/>'">
								<img src="/Aoide/static/img/songinfo_icons/add_favorite.png">
							</button>
							
							<button style="background-color: #C2C2FF" title="分享" onclick="location.href='<c:url value='/ShareServlet.member'/>'">
								<img src="/Aoide/static/img/songinfo_icons/fb.png">
							</button>

							<button style="background-color: #C2C2FF" title="贊助" onclick="location.href='<c:url value='/StartDonationServlet?recipient_id=${songVO.memberId }'/>'">
								<img src="/Aoide/static/img/songinfo_icons/donation.png">
							</button>
							<!-- top buttons ============================-->
							<br>
							
								<div class="box-body">
							<button><a href = "#" onclick="play(event)" ><svg fill="#000000" height="24" viewBox="0 0 24 24" width="40" xmlns="http://www.w3.org/2000/svg"> 

								<path d="M8 5v14l11-7z" /> <path d="M0 0h24v24H0z" fill="none" /> </svg></a>
								<script type="text/javascript" src="http://mediaplayer.yahoo.com/js"></script></button>
							<!-- song info table -->
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
									</tr>
								</tbody>
							</table>
							<!-- song intro table -->
							<table class="table">
								<tr>	
									<th>歌曲簡介</th>
								</tr>
								<tr>
									<td><img alt="" src="${songVO.coverFile}"></td>
									<td>${songVO.introductionFile}</td>
								</tr>
							</table>
							<!-- comment button -->
							<br>
								<button style="background-color: #C2C2FF" title="check out!" onclick="location.href='<c:url value='/GetSongInfo.member'/>'">
									<Img Src="/Aoide/static/img/songinfo_icons/comment.png">
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
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
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