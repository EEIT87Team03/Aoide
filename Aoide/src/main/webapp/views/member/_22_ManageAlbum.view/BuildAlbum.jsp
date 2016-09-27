<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建立專輯</title>
<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
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
				<div class="box">			
				<%  int i = 0;%>
				<div class="box-body">
					<form action="<c:url value ='/BuildAlbumSuccessServlet.member'/>"
						method="post" enctype="multipart/form-data">
						<label>上傳專輯封面：</label><input type="file" name="coverFile">${errorMsg.emptyPartMsg}
						<hr>
							<label>專輯名稱：</label><input type="text" name="name" value="${enteredText.name}">　${errorMsg.emptyNameMsg}
						<hr>
							<label>演出者：</label><input type="text" name="artist"　value="${enteredText.artist}">　${errorMsg.emptyArtistMsg}
						<hr>
							<label>專輯簡介：</label>
							<textarea name="introductionFile" id="introductionFile">${enteredText.introductionFile}</textarea>
							<script>
								CKEDITOR.replace('introductionFile');
							</script>
						
						<hr>
						<p><label>請選擇要加入專輯的未分類歌曲：</label>
						<table class="table">
							<thead>
								<tr>
									<th>　</th>
									<th>加入</th>
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
										<td>
											<%
												out.print(i = i + 1);
											%>
										</td>
										<td><input type="checkbox" name="check"
											value="${mySong.songId}"></td>
										<td>${mySong.name}</td>
										<td>${mySong.singer}</td>
										<td>${mySong.songType}</td>
										<td>${mySong.songLanguage}</td>
										<td>${mySong.updateDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<input type="submit" class="btn" value="送出">
					</form>
					<hr>
						</div>
						<!-- ========================================= -->
				</div>
				<div class="col-xs-6 col-md-3"></div>
			</div>
		</div>
</div>
		<!-- body-library  -->
		<c:import url="/TestHTML/body_library.html" />
</body>
</html>