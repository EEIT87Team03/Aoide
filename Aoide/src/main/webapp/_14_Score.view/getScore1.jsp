<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
<title>Get Score</title>

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
									<th>SongId</th>
									<th>Date</th>
									<th>ScoreValue</th>
									<th>CommentFile</th>
								</tr>
    						</thead>
    						<tbody>
								<c:forEach var="iscore" items="${getScore}">
			    					<tr>
			    					    <td>${iscore.memberId}</td>
			    						<td>${iscore.songId}</td>
			    						<td>${iscore.date}</td>
			    						<td>${iscore.scoreValue}</td>
			    						<td>${iscore.comment}</td>
<%--  			    				      <td><a href="<c:url value='/GenerateReplyPageServlet?id=${iscore.songId}'/>" class="btn btn-info" role="button">評分</a></td> --%>
 			    				        
  
                                         <td> <a href="getScore.jsp" value='/GenerateReplyPageServlet?id=${iscore.scoreValue}' class="btn btn-info" role="button">評分</a></td>
    
    
  </tr>  
 			    				        
 			   			    					</tr>
                                      
			    					</tr>
		    					</c:forEach>
    						</tbody>
    					</table>
		    				
    				<br>
  					</div>
				</div>
  			</div>
  			<div class="col-lg-1"></div>
		</div>
	</div>
=======
<script type="text/javascript">
function rate(obj, oEvent) {
	


			var imgSrc = 'http://www.jb51.net/upload/20080508122008586.gif';
			var imgSrc_2 = 'http://www.jb51.net/upload/20080508122010810.gif';

			if (obj.rateFlag)
				return;
			var e = oEvent || window.event;

			var target = e.target || e.srcElement;
			var imgArray = obj.getElementsByTagName("img");

			for (var i = 0; i < imgArray.length; i++) {
				imgArray[i]._num = i;
 				imgArray[i].onclick = function() {
 					if (obj.rateFlag)
 						return;
					obj.rateFlag = true;
					

				
// 					document.getElementById("e").innerText = this._num + 1;
					
					
					
					
					function setClick(event){
						
						document.onclick = showAlert;
						var p =document.getElementById("e");
						
						
						p.addEventListener("click",setClick,false);
						
			        
						
					}
					
					
					
				};
			}

			if (target.tagName == "IMG") {
				for (var j = 0; j < imgArray.length; j++) {
					if (j <= target._num) {
						imgArray[j].src = imgSrc_2;
					} else {
						imgArray[j].src = imgSrc;
					}
				}
			} else {
				for (var k = 0; k < imgArray.length; k++) {
					imgArray[k].src = imgSrc;
				}
			}

		}
		

		</script>
		<script type="text/javascript">
		
		
		
		function fuck(){
			     
			var g =document.getElementById("idStar1");
				alert(g);
				
			   
			     
			    	var c  = document.getElementById("idStar1");
			     
			     {}
			}
		
		
	

		</script>

<title>評分評論</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
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
									<th>SongId</th>
									<th>Date</th>
									<th>ScoreValue</th>
									<th>CommentFile</th>
								</tr>
    						</thead>
    						<tbody>
    						
    								<script>
	

		</script>
    						

			    					<tr>
			    					    <td>${getScore.memberId}</td>
			    						<td>${getScore.songId}</td>
			    						<td>${getScore.date}</td>
			    						<td><!-- 顯示star與取值 -->


		         <form action="/GetScoreServlet?" ></form>
		         <p class="starWrapper" onmouseover="rate(this,event)"> 
		         
			     <img id="idStar1" src="http://www.jb51.net/upload/20080508122008586.gif"  title="很爛"/>
					
			     <img id="idStar2" src="http://www.jb51.net/upload/20080508122008586.gif" title="一般" />
					
				 <img id="idStar3" src="http://www.jb51.net/upload/20080508122008586.gif" title="還好" />
					 
				 <img id="idStar4" src="http://www.jb51.net/upload/20080508122008586.gif" title="較好" />
					
				 <img id="idStar5" src="http://www.jb51.net/upload/20080508122008586.gif" title="很好" />
			
				
				
				   <br> &nbsp; &nbsp; 分數為: &nbsp;<span id="e" style="width:120px;height:40px;font-size:14px;">Point</span></td>
                           
     <td>            
                     
				            
				       <button onclick="fuck()" type"button" value="fuckyou">fuckyou</p>     
				            </td>
  
  <br>
		    					<small>&lt;&lt;<a href="http://localhost:8080/Aoide/index.jsp">回首頁</a>&gt;&gt;</small>
		    					<small>&lt;&lt;<a href="CommentPresent.jsp">其他短評</a>&gt;&gt;</small>
    						</tbody>
    					</table>
		    				
    				<br>
  					</div>
				</div>
  			</div>
  			<div class="col-lg-1"></div>
		</div>
	</div>

>>>>>>> branch 'master' of https://github.com/EEIT87Team03/Aoide.git
</body>
</html>
