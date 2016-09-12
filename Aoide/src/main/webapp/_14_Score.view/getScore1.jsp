<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
			imgArray[i].onclick = function() {if (obj.rateFlag)return;   obj.rateFlag = true;
				
  	          document.getElementById("G8").innerText = this._num + 1;
  	          abc = this._num + 1;
	          
 	       ;
 	      
 
                    
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
	    
	
// 	var gb = 0;
	
  	  function myFunction(event) {
 		
  		  var a = "too bad";
 	      var b = "bad";
 		  var c = "so so";
 		  var d = "good";
 		  var e = "very well";
 		
//    		 var bb = a.onclick = document.getElementById("g7").id
//     		 alert(bb);

          v =  document.getElementById("G8").innerText ;
             
 		      if(v == document.getElementById("1").id){
  			alert(a);
  		}else if(v == document.getElementById("2").id){
  			alert(b);
 		}else if(v == document.getElementById("3").id){
 			alert(c);
		
 		 }else if(v ==  document.getElementById("4").id){
 			alert(d);

 		 }else if(v == document.getElementById("5").id)
 			alert(e);
				
			}
  			
	
	
	
	
</script>

<script>


</script>

<script>

</script>



<title>評分評論</title>
<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<a href=""></a>
					</div>
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
									<td>
										<!-- 顯示star與取值 -->


										<form action="/GetScoreServlet?"></form>
										<p  id="g7" class="starWrapper" onmouseover="rate(this,event)">

							
							<a id="1" name="1" title="1" ><img  src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
							
							<a id="2" name="2"  title="2"><img  src="http://www.jb51.net/upload/20080508122008586.gif"/></a> 
							
							<a id="3" name="3" title="3" ><img src="http://www.jb51.net/upload/20080508122008586.gif" /></a> 
							
							<a id="4" name="4" title="4" ><img src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
							
							<a id="5" name="5" title="5" ><img src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
							 
							  <br> &nbsp; &nbsp; 分數為: &nbsp;<span id="G8" style="width: 120px; height: 40px; font-size: 14px;">Point</span>
									</td>
                                    
									<td>

                                  <td><a   href="<c:url value='/ScoreInDataBaseServlet?id= + v '/> class="btn btn-info" role="button"><button onclick="myFunction()"  type="button" value="sumit">
											button</button></a></td>
										
										
									</td>

									<br>
									<small>&lt;&lt;<a
										href="http://localhost:8080/Aoide/index.jsp">回首頁</a>&gt;&gt;
									</small>
									<small>&lt;&lt;<a href="CommentPresent.jsp">其他短評</a>&gt;&gt;
									</small>
							</tbody>
						</table>

						<br>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>

        




</body>
</html>