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
								<h3 class="box-title">儲值成功!以下是本次的儲值紀錄~</h3>

							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive no-padding">
								<table class="table">
									<tr>
									<th>交易ID</th>
									<th>交易日期</th>
							    <!--<th>贊助者ID</th>
									<th>被贊助者ID</th>-->
									<th>贊助金額</th>
									<th>獲得點數</th>
								</tr>
									<tr>
										<td>${cashRecordVO.cashRecordId}</td>
										<td>${cashRecordVO.date}</td>
										<!--  <td>${cashRecordVO.sponsorId}</td>
										<td>${cashRecordVO.recipientId}</td>-->
										<td>${cashRecordVO.cashVolume}</td>
										<td>${cashRecordVO.tokenVolume}</td>
									</tr>
								</table>
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