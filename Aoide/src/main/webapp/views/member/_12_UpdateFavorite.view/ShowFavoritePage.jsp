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
			    <!-- Main content -->
			    <section class="content">
					  <!-- Default box -->
				      <div class="box">
				        <div class="box-header with-border">
				          <h3 class="box-title">歌曲收藏清單</h3>
				        </div>
				        <!-- /.box-body -->
				        <div class="box-body">
					    <!-- /.table -->
						<% int i = 0; %>
						<table class="table">
							<thead>
								<tr>
									<th>　</th>
									<th>點歌</th>
									<th>歌名</th>
									<th>演出者</th>
									<th>類型</th>
									<th>語言</th>
									<th>上傳日期</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="aSong" items="${songs}">
									<tr>
										<td><% out.print(i = i + 1); %></td>
										<td><u><a href="<c:url value='/BuildPlaylistServlet?id=${aSong.songId}'/>">點歌</a></u></td>
										<td><u><a href="<c:url value='/DisplaySongServlet?id=${aSong.songId}'/>">${aSong.name}</a></u></td>
										<td>${aSong.singer}</td>
										<td>${aSong.songType}</td>
										<td>${aSong.songLanguage}</td>
										<td>${aSong.updateDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a  class="btn" href="/Aoide/views/global/_10_SearchSong.view/SearchSong.jsp">back</a>
				        <!-- /.table -->
				       </div>
				        <!-- /.box-body -->
				        <div class="box-footer clearfix">
				          <ul class="pagination pagination-sm no-margin pull-right">
				            <li><a href="#">&laquo;</a></li>
				            <li><a href="#">1</a></li>
				            <li><a href="#">2</a></li>
				            <li><a href="#">3</a></li>
				            <li><a href="#">&raquo;</a></li>
				          </ul>
				        </div>
				        <!-- /.box-footer-->
				      </div>
				      <!-- /.box -->
			    </section>
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>
