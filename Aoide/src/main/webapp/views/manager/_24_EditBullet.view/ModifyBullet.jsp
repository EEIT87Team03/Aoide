<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
			<div class="box">
					<div class="box-header with-border">
						<div class="box-body">

							<h3>Modify</h3>
							<form action="<c:url value ='/ModifyEditBullet'/>" method="post">

								日期：${bulletVO.date}
								<hr>

									contentFile：<input class="form-control" type="text"
										name="contentFile" value="${bulletVO.contentFile}">
								<hr>

									title：
									<textarea name="title" id="title">${bulletVO.title}</textarea>
									<script>
										CKEDITOR.replace('title');
									</script>
								<hr>

									<input class="btn" type="submit" value="送出"> 
									<input class="btn" type="reset"  value="清除">
							</form>
							<a href="<c:url value ='/EditBulletList'/>">回列表頁</a>
						</div>
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