<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/Aoide/template/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/css/style.css?ver=8dba6713421708b83f224493838e3224">
<link rel="stylesheet" href="http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/css/framework.css?ver=1.5.3">

<style type="text/css">
body{
	background-color: transparent;
	opacity: 0.8;
}	
#middleContent{
	background-color: black !important;
	opacity: 0.8;
	padding: 20px;
}	
</style>

</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
			    <% int i = 0; %>
					<form action="<c:url value ='/BuildAlbumSuccessServlet.member'/>" method="post" enctype="multipart/form-data">
							上傳專輯封面：<input type="file" name="coverFile">　${errorMsg.emptyPartMsg}
						<p>
							專輯名稱：<input type="text" name="name" value="${enteredText.name}">　${errorMsg.emptyNameMsg}
						<p>
							演出者：<input type="text" name="artist" value="${enteredText.artist}">　${errorMsg.emptyArtistMsg}
						<p>
							專輯簡介：
							<textarea name="introductionFile" id="introductionFile">${enteredText.introductionFile}</textarea>
							<script>CKEDITOR.replace('introductionFile');</script>
						<p>
						<hr>
						<p>
							請選擇要加入專輯的未分類歌曲：
						<p>
						<table class="table">
						<thead>
							<tr>
								<th>　</th>
								<th>加入</th>
								<th>歌曲ID</th>
								<th>歌名</th>
								<th>演出者</th>
								<th>類型</th>
								<th>語言</th>
								<th>上傳日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mySong" items="${mySongList}">
								<tr>
									<td><% out.print(i = i + 1); %></td>
									<td><input type="checkbox" name="check" value="${mySong.songId}"></td>
									<td>${mySong.songId}</td>
									<td>${mySong.name}</td>
									<td>${mySong.singer}</td>
									<td>${mySong.songType}</td>
									<td>${mySong.songLanguage}</td>
									<td>${mySong.updateDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
							<input class="btn btn-primary" type="submit" value="送出">
					</form>
					<p>
					<a class="btn btn-primary" href="ManageAlbum.jsp">回管理專輯</a>
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
</body>
</html>