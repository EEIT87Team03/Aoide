<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

		</script>
<title>Comment</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
  			<div class="col-lg-1"></div>
  			<div class="col-lg-10">
  				<div class="panel panel-primary">
  					<div class="panel-heading"><a href= ""></a></div>
  					<div class="panel-body">
    				
    					<table class="table">
    						<thead>
    							<tr>
    							    <th>MemberId</th>
    							    <th>Date</th>
    							    <th>ScoreValue</th>
									<th>CommentFile</th>
								</tr>
    						</thead>
    						<tbody>
								<c:forEach var="commentValue" items="${getScore}">
			    					<tr>
			    					    <td>${commentValue.memberId}</td>
			                            <td>${commentValue.date}</td>
			                            <td>${commentValue.scoreValue}</td>
			    						<td>${commentValue.comment}</td>


<%--                                          <td><a href="\main\webapp\index.jsp" value='/CommentServlet?id=${commentValue.songId}' class="btn btn-info" role="button">回首頁</a></td> --%>
    
    
  </tr>  
 			    				        
 			   			 
		    					</c:forEach>
    						</tbody>
    					</table>
		    				<small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small>
    				<br>
  					</div>
				</div>
  			</div>
  			<div class="col-lg-1"></div>
		</div>
	</div>
	

		
</body>
</html>