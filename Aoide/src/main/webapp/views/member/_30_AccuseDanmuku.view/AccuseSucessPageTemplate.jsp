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
            <div class="box-header">
              <h3 class="box-title">檢舉成功! 以下是這次的檢舉資訊</h3>

            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>檢舉ID</th>
				  <th>檢舉日期</th>
				  <th>檢舉人ID</th>
				  <th>被檢舉ID</th>
				  <th>檢舉原因</th>
                </tr>
                <tr>
                  <td>${accusementDanmukuVO.accusementDanmukuId}</td>
				  <td>${accusementDanmukuVO.date}</td>
				  <td>${accusementDanmukuVO.accuseId}</td>
				  <td>${accusementDanmukuVO.accusedId}</td>
				  <td>${accusementDanmukuVO.contentFile}</td>
                </tr>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
			<input type="submit" class="btn btn-primary" value="Submit">
            
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>