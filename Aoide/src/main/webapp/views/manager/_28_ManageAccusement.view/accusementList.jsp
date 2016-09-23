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
<!-- <div class="wrapper"> -->
  <div>
  <!-- header -->
<%--   <c:import url="/template/htmlBlocks/header.html"/> --%>
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
<%--   <c:import url="C/template/htmlBlocks/sidebar_global.html"/> --%>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
<!--   <div class="content-wrapper"> -->
  <div>
    <!-- Content Header (Page header) -->

    <!-- Main content -->
    <c:forEach var="aAccusement" items="${accusements}">
    <!-- =========================================================== -->
    <section class="content">
      <!-- =========================================================== -->
      <div class="row">
        <!-- left empty column -->
        <div class="col-md-3">
        </div>
        <!-- /left empty column -->

        <!-- =========================================================== -->
        <!-- middle content column -->
        <div class="col-md-6">
        <!-- Collapsed box -->
          <div class="box box-default">
            <div class="box-header with-border">
              <h3 class="box-title">
                ${aAccusement.accusementDanmukuId} &nbsp;&nbsp; ${aAccusement.danmukuContent} 
              </h3>
              <span style="float:right;">${aAccusement.date}</span>  
              

<!--               <div class="box-tools pull-right"> -->
<!--                 <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i> -->
<!--                 </button> -->
<!--               </div> -->
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <!-- =========================================================== -->
            <div class="box-body">
            <!--The body of the box -->
              <table class="table">
                <tbody>
                  <tr>
                    <td>被檢舉者帳號</td>
                    <td>${aAccusement.accused.account}</td>
                    <td align="center" >
                      <a href="<c:url value='/BanMemberServlet?accusedAccount=${aAccusement.accused.account}'/>" class="btn btn-success btn-sm" role="button">Ban</a>
                      <a href="<c:url value='/RemoveAccusement?accusementId=${ aAccusement.accusementDanmukuId}&accusedAccount=${aAccusement.accused.account}'/>" class="btn btn-danger btn-sm" role="button">Release</a>
                    </td>
                  </tr>
                  <tr>
                  	<td>封鎖帳號</td>
                  	<td>${aAccusement.state}</td>
                  </tr>
                  <tr>
                    <td>檢舉原因</td>
                    <td>${aAccusement.contentFile}</td>
                  </tr>
                  <tr>
                    <td>檢舉者帳號</td>
                    <td>${aAccusement.accuse.account}</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- /.box-body -->
            <!-- =========================================================== -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /middle content column -->
        <!-- =========================================================== -->

        <!-- right empty column -->
        <div class="col-md-3">
        </div>
        <!-- /right empty column -->
      </div>
      <!-- /.row -->
      <!-- =========================================================== -->
    </section>
    <!-- /.content -->
    <!-- =========================================================== -->
    </c:forEach>
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
</body>
</html>