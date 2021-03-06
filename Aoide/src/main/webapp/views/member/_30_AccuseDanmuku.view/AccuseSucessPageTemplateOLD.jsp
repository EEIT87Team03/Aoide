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
  
  <!-- _05_DisplayDanmuku_library_css -->
  <!-- <c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library_css.html"/> -->
  <!-- _05_DisplayDanmuku_library_css -->
  
<title>檢舉成功</title>
</head>
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
<!--   <div class="content-wrapper"> -->
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
      
      
            <div class="row">
        <div class="col-xs-12">
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
          <!-- /.box -->
        </div>
      </div>
      
      


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

<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->

<!-- _05_DisplayDanmuku_library -->
<!-- <c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library.html"/> -->
<!-- _05_DisplayDanmuku_library -->
</body>
</html>