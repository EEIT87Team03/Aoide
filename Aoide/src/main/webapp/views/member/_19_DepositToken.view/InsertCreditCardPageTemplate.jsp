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
<title>Home</title>

</head>
<!-- <body class="hold-transition skin-blue fixed sidebar-mini"> -->
<body>
<!-- Site wrapper -->
<div class="wrapper">
  <!-- header -->
<%--   <c:import url="/template/htmlBlocks/header.html"/> --%>
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
<%--   <c:import url="/template/htmlBlocks/sidebar_global.html"/> --%>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
<!--     <section class="content-header"> -->
<!--       <h1> -->
<!--         Fixed Layout -->
<!--         <small>Blank example to the fixed layout</small> -->
<!--       </h1> -->
<!--       <ol class="breadcrumb"> -->
<!--         <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li> -->
<!--         <li><a href="#">Layout</a></li> -->
<!--         <li class="active">Fixed</li> -->
<!--       </ol> -->
<!--     </section> -->

    <!-- Main content -->
    <section class="content">
      
      <!-- Default box -->
      <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">輸入信用卡資訊頁面頁面</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" method="POST" action="<c:url value='/DepositToken.member' />"  id="DonationServlet" >
              <div class="box-body">
                <div class="form-group">
                <label style="margin:10px 0 0 0">訂單編號  :  8591</label>
                <hr>
                <label>交易金額  :  ${cash_volume}</label>
                <hr>
                <label>請選擇信用卡類型</label>
                <input type="radio" name="creditCardType" value = "visa">
                  <img src="../../dist/img/credit/visa.png" alt="Visa">
                  <input type="radio" name="creditCardType" value = "Mastercard">
		          <img src="../../dist/img/credit/mastercard.png" alt="Mastercard">
		          <input type="radio" name="creditCardType" value = "American">
		          <img src="../../dist/img/credit/american-express.png" alt="American Express">
		          <input type="radio" name="creditCardType" value = "Paypal">
		          <img src="../../dist/img/credit/paypal2.png" alt="Paypal">
		          <hr/>
                  <label>信用卡卡號</label>
                  <input type=text  id=pan_no1 size=4 value="" maxlength=4 onKeyUp="setBlur(this,'pan_no2');" >-
			   	  <input type=text  id=pan_no2 size=4 value="" maxlength=4 onKeyUp="setBlur(this,'pan_no3');">-
				  <input type=text  id=pan_no3 size=4 value="" maxlength=4 onKeyUp="setBlur(this,'pan_no4');">-
				  <input type=text  id=pan_no4 size=4 value="" maxlength=4 >  
				  <hr/>
                  <label>三碼檢查碼</label>
                  <input type=text  name=pan_no4 size=3 value="" maxlength=3 >
                  <hr>
                  <label>信用卡到期(月/年)</label>
                  <select>
					 <option>1</option>
					 <option>2</option>
					 <option>3</option>
					 <option>4</option>
					 <option>5</option>
					 <option>6</option>
					 <option>7</option>
					 <option>8</option>
					 <option>9</option>
					 <option>10</option>
					 <option>11</option>
					 <option>12</option>
				  </select>
				  /
				  <select>
					 <option>2016</option>
					 <option>2017</option>
					 <option>2018</option>
					 <option>2019</option>
					 <option>2020</option>
					 <option>2021</option>
					 <option>2022</option>
					 <option>2023</option>
					 <option>2024</option>
					 <option>2025</option>
					 <option>2026</option>
					 <option>2027</option>
				  </select>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- footer -->
<%--   <c:import url="/template/htmlBlocks/footer.html"/> --%>
  <!-- footer -->

  <!-- Control Sidebar -->
<%--   <c:import url="/template/htmlBlocks/control_sidebar.html"/> --%>
  <!-- Control Sidebar -->
</div>
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
<script>
  function setBlur(obj,target2)
  {
     var target =document.getElementById(target2);
       if( obj.value.length ==obj.getAttribute('maxlength'))
           {
               target.focus();
           }
       return;
  } 
</script>
</body>
</html>