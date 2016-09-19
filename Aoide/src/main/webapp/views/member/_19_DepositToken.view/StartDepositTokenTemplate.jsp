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
<body class="hold-transition skin-blue fixed sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- header -->
  <c:import url="/template/htmlBlocks/header.html"/>
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
  <c:import url="/template/htmlBlocks/sidebar_global.html"/>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Fixed Layout
        <small>Blank example to the fixed layout</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Layout</a></li>
        <li class="active">Fixed</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      
      <!-- Default box -->
      <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">儲值開始頁面</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" method="POST" action="<c:url value='/TurnToInsertCreditCardPageServlet.member' />"  id="DonationServlet" >
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputPassword1">儲值金額</label><font color = 'red' size='-1'>   ${cash_volumeError}</font>
                  <input type="text" class="form-control" id="exampleInputPassword1" placeholder="儲值金額" name = "cash_volume" maxlength=9>
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
  <c:import url="/template/htmlBlocks/footer.html"/>
  <!-- footer -->

  <!-- Control Sidebar -->
  <c:import url="/template/htmlBlocks/control_sidebar.html"/>
  <!-- Control Sidebar -->
</div>
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
<script>



</script>
</body>
</html>