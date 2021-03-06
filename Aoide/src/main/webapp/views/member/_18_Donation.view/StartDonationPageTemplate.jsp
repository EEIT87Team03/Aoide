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
			<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">贊助開始頁面</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" method="POST" action="<c:url value='/TurnToInsertCreditCardPageServletD.member' />"  id="DonationServlet" >
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">受贊助人帳號</label>
                  <input type="text" class="form-control " id="exampleInputEmail1" placeholder="${recipient_Account}" disabled="disabled">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">贊助金額</label><font color = 'red' size='-1'>   ${cash_volumeError}</font>
                  <input type="text" class="form-control" id="exampleInputPassword1" placeholder="贊助金額" name = "cash_volume">
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">下一步</button>
              </div>
            </form>
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