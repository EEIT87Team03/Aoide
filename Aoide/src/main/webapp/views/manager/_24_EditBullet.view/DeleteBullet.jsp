<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Bullet</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
  <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
<link rel="strlesheet" href="css/bootstrap.min.css">
</head>
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

			<form action="<c:url value ='/DeleteEditBullet'/>" method="post">
				delete：<input type="text" name="deleteBullet">
				<p>
					<input type="submit" value="送出">
			</form>
</div>
</div>
</div>
</div>
</div>
</section>
</div>
</body>
</html>
