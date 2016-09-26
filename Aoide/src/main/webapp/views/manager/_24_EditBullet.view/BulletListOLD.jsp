<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bullet</title>
 <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
  <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
<link rel="strlesheet" href="css/bootstrap.min.css">
<body>
<div class="wrapper">
    <section class="content">
    <div class="row">
           <div class="col-md-2">
        </div>
         <div class="col-md-8">
                <div class="box">
		         <div class="box-header with-border">
		         <div class="box-body">

			<td><div align="right">
					<input class="btn btn-primary" type="button" value="新增" 
						onclick="location.href='<c:url value='/views/manager/_24_EditBullet.view/Uploadbullet.jsp'/>'">
				</div></td>

			<table class="table">
				<thead>
					<tr>
						<th>No</th>
						<th>date</th>
						<th>title</th>
						<th>content_file</th>
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
	</div>
	</div>
	</div>
	</section>
	</div>
</body>
</html>
