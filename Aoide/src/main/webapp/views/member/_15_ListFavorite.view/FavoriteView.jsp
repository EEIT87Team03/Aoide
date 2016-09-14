<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">


<!-- head_library -->
<c:import url="/template/htmlBlocks/head_library.html" />
<!-- head_library -->
<title>Favorite List</title>


</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<!-- Site wrapper -->

	<div class="wrapper">
		<!-- header -->
		<c:import url="/template/htmlBlocks/header.html" />
		<!-- header -->

		<!-- =============================================== -->

		<!-- sidebar -->
		<c:import url="/template/htmlBlocks/sidebar_global.html" />
		<!-- sidebar -->

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Favorite <small> Your Favorite</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="\Aoide\_14_Score.view\index.jsp"><i
						class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Favorite List</a></li>
				<!--         <li class="active">Fixed</li> -->
			</ol>
			</section>

			<!-- Default box -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title"></h3>


					<title>評分評論</title>

					<div class="panel-body">

						<table class="table">
							<thead>
								<tr>
									<th>歌曲ID</th>
									<th>作曲者ID</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach var="aFavorite" items="${favorites}">
									<tr>
										<td>${aFavorite.songId}</td>
										<td>${aFavorite.memberId}</td>
									</tr>
								</c:forEach>


								<a href="http://localhost:8080/Aoide/index.jsp"
									class="btn btn-info" role="button">回首頁</a>
</body>


</html>

