<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
<title>index</title>
</head>
<body>
<% int i = 0; %>
<!-- Site wrapper -->
<div class="wrapper">


    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
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
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>