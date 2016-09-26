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
		         <div class="box-body table-responsive no-padding">

			<td><div align="right">
					<input class="btn btn-primary" type="button" value="新增" 
						onclick="location.href='<c:url value='/views/manager/_24_EditBullet.view/Uploadbullet.jsp'/>'">
				</div></td>

			<table class="table">
				<thead>
					<tr>
						<th>公告編號</th>
						<th>公告日期</th>
						<th>公告標題</th>
						<th>公告頁面</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="aBullet" items="${BulletList}">
						<tr>
							<td>${aBullet.bulletId}</td>
							<td>${aBullet.date}</td>
							<td>${aBullet.title}</td>
							<td>${aBullet.contentFile}</td>
							<td><input class="btn btn-warning" type="button" value="編輯" 
								onclick="location.href='<c:url value='/ModifyBullet?id=${aBullet.bulletId}'/>'">
							</td>
							<td><input class="btn btn-danger" type="button" value="刪除"
								onclick="location.href='<c:url value='/DeleteBullet?id=${aBullet.bulletId}'/>'">
							</td>
						</tr>
					</c:forEach>
					<tr>
					</tr>
				</tbody>
			</table>
			<br>
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