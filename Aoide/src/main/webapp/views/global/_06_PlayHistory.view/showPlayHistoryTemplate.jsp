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
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">以下是播放歷史紀錄~</h3>

					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table">
							<tr>
								<th>播放歷史ID</th>
								<th>播放歌曲ID</th>
								<th>撥放日期</th>
							</tr>
							<c:forEach var="clickhistory" items="${clickhistorysList}"
								varStatus="loop">
								<tr>
									<td>${clickhistory.clickhistoryId}</td>
									<td>${songIdList[loop.count-1]}</td>
									<td>${clickhistory.date}</td>
								</tr>
							</c:forEach>
						</table>
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