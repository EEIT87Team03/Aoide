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
					<div class="box-header with-border">
						<div class="box-body">

							<p>公告編號 : ${bulletVO.bulletId}</p>
							<hr><p>公告日期：${bulletVO.date}</p>
							<hr>公告標題：<p>${bulletVO.title}</p>
							<hr>
							<label>公告內容</label>
							<div class="box-body-content">
								${bulletVO.contentFile}
							</div>
							<hr>
								<a href="<c:url value ='/EditBulletList'/>">回上一頁</a>
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