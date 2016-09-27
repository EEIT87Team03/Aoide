<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html" />
<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
				<!-- ========================================= -->
				<div class="box">
					<div class="box-body">
						<form role="form"
							action="<c:url value ='/UploadSongServlet.member'/>"
							method="post" enctype="multipart/form-data">
							<label>上傳歌曲：</label><input type="file" name="songFile">${errorMsg.emptyPartMsg}
							<hr>
							<label>上傳封面圖片：</label><input type="file" name="coverFile">${errorMsg.emptyPart2Msg}
							<hr>
							<label>歌名：</label><input type="text" name="name"
								value="${enteredText.name}">　${errorMsg.emptyNameMsg}
							<hr>
							<label>演出者：</label><input type="text" name="singer"
								value="${enteredText.singer}">　${errorMsg.emptySingerMsg}
							<hr>
							<label>類型：</label><input type="text" name="songType"
								value="${enteredText.songType}">
							<hr>
							<label>語言：</label><input type="text" name="songLanguage"
								value="${enteredText.songLanguage}">
							<hr>
							<label>歌曲簡介：</label>
							<textarea name="introductionFile" id="introductionFile">${enteredText.introductionFile}</textarea>
							<script>
								CKEDITOR.replace('introductionFile');
							</script>
							<hr>
							<label>歌詞：</label>
							<textarea name="lyricsFile" id="lyricsFile">${enteredText.lyricsFile}</textarea>
							<script>
								CKEDITOR.replace('lyricsFile');
							</script>
							<hr>
							<input class="btn" type="submit" value="送出">
						</form>

					</div>
					<!-- /.box-body -->
					<!-- /.box-footer-->
				</div>

				<!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
	</div>

	<!-- body-library  -->
	<c:import url="/TestHTML/body_library.html" />
</body>
</html>