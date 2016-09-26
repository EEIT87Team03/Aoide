<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
</head>
<body>
<%
		int i = 0;
		int j = 0;
	%>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
			<div class="box" >



				<div class="box-body">
				<label>正在編輯專輯：${album.name}</label>
					
					<p>
						<img src="${album.coverFilePath}" width="300" height="300">
						<p>
						<label>建立日期：${album.updateDate}</label>
					<p>
				
				
				
				
				
					<form role="form"
						action="<c:url value ='/UpdateAlbumServlet.member'/>"
						method="post" enctype="multipart/form-data">
						<label>上傳專輯封面：</label><input type="file" name="coverFile">
						${errorMsg.emptyPartMsg}
						<hr>
						<label>專輯名稱：</label><input type="text" name="name"
							placeholder="${album.name}" value="${enteredText.name}">
						${errorMsg.emptyNameMsg}
						<hr>
						<label>演出者：</label><input type="text" name="artist"
							placeholder="${album.artist}" value="${enteredText.artist}">
						${errorMsg.emptyArtistMsg}
						<hr>
						<label>專輯簡介：</label>
						<textarea name="introductionFile" id="introductionFile">${album.introductionFilePath}${enteredText.introductionFile}</textarea>
						<script>CKEDITOR.replace('introductionFile');</script>
						<hr>
						<hr>
						<p>移除專輯裡的歌曲：
						<p>
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th>歌曲ID</th>
									<th>歌名</th>
									<th>演出者</th>
									<th>類型</th>
									<th>語言</th>
									<th>上傳日期</th>
									<th>動作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="mySong" items="${mySongList}">
									<tr>
										<td>
											<%
												out.print(i = i + 1);
											%>
										</td>
										<td>${mySong.songId}</td>
										<td>${mySong.name}</td>
										<td>${mySong.singer}</td>
										<td>${mySong.songType}</td>
										<td>${mySong.songLanguage}</td>
										<td>${mySong.updateDate}</td>
										<td><input type="button" value="移除"
											onclick="location.href='<c:url value='/RemoveAlbumidServlet.member?id=${mySong.songId}'/>'">
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<p>
						<hr>
						<p>加入未分類專輯的歌曲：
						<p>
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th>歌曲ID</th>
									<th>歌名</th>
									<th>演出者</th>
									<th>類型</th>
									<th>語言</th>
									<th>上傳日期</th>
									<th>動作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="mySong" items="${mySongList2}">
									<tr>
										<td>
											<%
												out.print(j = j + 1);
											%>
										</td>
										<td>${mySong.songId}</td>
										<td>${mySong.name}</td>
										<td>${mySong.singer}</td>
										<td>${mySong.songType}</td>
										<td>${mySong.songLanguage}</td>
										<td>${mySong.updateDate}</td>
										<td><input type="button" value="加入"
											onclick="location.href='<c:url value='/AddtoAlbumServlet.member?id=${mySong.songId}'/>'">
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<input type="submit" value="送出">
					</form>

				</div>



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