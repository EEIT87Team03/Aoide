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
				<div class="box">
		        	<br>
		        	<br>
		        	<form action="<c:url value ='/SearchSongServlet'/>" method="post" style="text-align: center;">
						搜尋：<input type="text" name="searchSong" style="color:black">　
						<input class="btn" type="submit" value="送出" style="color:black">　${errorMsg.emptySearchMsg}
						<p>
						<input type="radio" name="searchType" value="name" checked>搜尋歌名　
						<input type="radio" name="searchType" value="singer">搜尋歌手　
						<input type="radio" name="searchType" value="album">搜尋專輯
					</form>
						<div style="padding-left: 215px;">
							<p>點歌規則:</p>
							<p>同一首歌曲 25 小時內只能點播一次。</p>
							<p>相同的演出者不能重複出現在播放清單上。</p>
							<p>一次限點播一首，播放清單上沒有其它人點播時才能連續點播。</p>
							<p>冷卻時間結束後 8 天內又再度被點播的歌曲會增加額外的冷卻時間。</p>
						</div>
					<br>
		        	<br>
				</div>
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>