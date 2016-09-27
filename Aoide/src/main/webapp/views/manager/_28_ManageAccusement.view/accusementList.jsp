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
			
				<!-- Main content -->
			    <c:forEach var="aAccusement" items="${accusements}">
			    <!-- =========================================================== -->
			    <section class="content">
			      <!-- =========================================================== -->
			      <div class="row">
			        <!--box -->
			          <div class="box">
			            <div class="box-header with-border">
			              <h3 class="box-title">
			                ${aAccusement.accusementDanmukuId} &nbsp;&nbsp; ${aAccusement.danmukuContent} 
			              </h3>
			              <span style="float:right;">${aAccusement.date}</span>  
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
			                  	<td>${aAccusement.accused.banState}</td>
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
			          </div>
			          <!-- /.box -->
			      </div>
			      <!-- /.row -->
			    </section>
			    <!-- /.content -->
			    </c:forEach>
            
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>