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
<% int i = 0; %>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
			<div class="box">
        <div class="box-body">
          <table class="table table-hover">
		<thead>
			<tr>
				<th>　</th>
				<th>專輯ID</th>
				<th>專輯名稱</th>
				<th>演出者</th>
				<th>建立日期</th>
				<th>動作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="myAlbum" items="${myAlbumList}">
				<tr>
					<td><% out.print(i = i + 1); %></td>
					<td>${myAlbum.albumId}</td>
					<td>${myAlbum.name}</td>
					<td>${myAlbum.artist}</td>
					<td>${myAlbum.updateDate}</td>
					<td><input type="button" value="編輯" onclick="location.href='<c:url value='/EditAlbumServlet.member?id=${myAlbum.albumId}'/>'">　
						<input type="button" value="刪除" onclick="location.href='<c:url value='/DeleteAlbumServlet.member?id=${myAlbum.albumId}'/>'">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
	<a href="ManageAlbum.jsp">回管理專輯</a>
        </div>
        <!-- /.box-body -->
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