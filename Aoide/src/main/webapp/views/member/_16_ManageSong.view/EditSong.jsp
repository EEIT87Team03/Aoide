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
					<!--         <div class="box-header with-border"> -->
					<!--           <h3 class="box-title">Title</h3> -->

					<!--           <div class="box-tools pull-right"> -->
					<!--             <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse"> -->
					<!--               <i class="fa fa-minus"></i></button> -->
					<!--             <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"> -->
					<!--               <i class="fa fa-times"></i></button> -->
					<!--           </div> -->
					<!--         </div> -->
					<div class="box-body">
						<label>正在編輯歌曲：${song.name}</label>
						<p><p>
							<img src="${song.coverFile}" width="300" height="300">
						<p>
							<label>上傳日期：${song.updateDate}</label>
						<p>
						<hr>
						<p>
						<form action="<c:url value ='/UpdateSongServlet.member'/>" method="post" enctype="multipart/form-data">
							<label>上傳封面圖片：</label><input type="file" name="coverFile">${errorMsg.emptyPartMsg}
							<hr>
								<label>歌名：</label><input type="text" name="name" placeholder="${song.name}"
									value="${enteredText.name}">　${errorMsg.emptyNameMsg}
							<hr>
								<label>演出者：</label><input type="text" name="singer"
									placeholder="${song.singer}" value="${enteredText.singer}">　${errorMsg.emptySingerMsg}
							<hr>
								<label>類型：</label><input type="text" name="songType"
									placeholder="${song.songType}" value="${enteredText.songType}">
							<hr>
								<label>語言：</label><input type="text" name="songLanguage"
									placeholder="${song.songLanguage}"
									value="${enteredText.songLanguage}">
							<hr>
								<label>歌曲簡介：</label>
								<textarea name="introductionFile" id="introductionFile">${song.introductionFile}${enteredText.introductionFile}</textarea>
								<script>
									CKEDITOR.replace('introductionFile');
								</script>
							<hr>
								<label>歌詞：</label>
								<textarea name="lyricsFile" id="lyricsFile">${song.lyricsFile}${enteredText.lyricsFile}</textarea>
								<script>
									CKEDITOR.replace('lyricsFile');
								</script>
							<hr>
								<input type="submit" class="btn" value="送出">
						</form>
					</div>
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