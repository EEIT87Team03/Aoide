<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- head_library -->
<c:import url="/template/htmlBlocks/head_library.html" />
<!-- head_library -->
<title>編輯專輯</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
	<%
		int i = 0;
		int j = 0;
	%>
	<!-- Site wrapper -->
	<div class="wrapper">

		<!-- Main content -->
		<section class="content">

			<!-- Default box -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Title</h3>
					正在編輯專輯：${album.name}<p>
					<img src="${album.coverFilePath}" width="300" height="300"><p>
					建立日期：${album.updateDate}<p>
					<hr>
					<p>
				</div>
				<div class="box-body">Start creating your amazing application!
				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
			<!-- /.box -->

		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<!-- ./wrapper -->

	<!-- body_library -->
	<c:import url="/template/htmlBlocks/body_library.html" />
	<!-- body_library -->
</body>
</html>