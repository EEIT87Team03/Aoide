<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css' type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打分數</title>
<p align="center">
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

					//this._num+1這個數字寫入到數據庫中,作為評分的依據

					document.getElementById("e").innerText = this._num + 1;
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
</p>
</head>
<body>
	<h1>GET SCORE</h1>
	<p class="starWrapper" onmouseover="rate(this,event)">
		<img src="http://www.jb51.net/upload/20080508122008586.gif" title="很爛" />
		<img src="http://www.jb51.net/upload/20080508122008586.gif" title="一般" />
		<img src="http://www.jb51.net/upload/20080508122008586.gif" title="還好" />
		<img src="http://www.jb51.net/upload/20080508122008586.gif" title="較好" />
		<img src="http://www.jb51.net/upload/20080508122008586.gif" title="很好" />


		<BR>
		<BR>
		<HR>
	<BR>
<span style="text-decoration: underline;">GetPoint..is.....</span> <span
			id="e">*</span>
	<P />
	<BR>
	<BR>
	<HR>
	<BR>
	<small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small>
<!-- 	<small>&lt;&lt;<a href="../">回首頁</a>&gt;&gt; -->
	</small>
<!-- ======= -->
					

<!-- 					document.getElementById("e").innerText = this._num + 1; -->
<!-- 				}; -->
<!-- 			} -->

<!-- 			if (target.tagName == "IMG") { -->
<!-- 				for (var j = 0; j < imgArray.length; j++) { -->
<!-- 					if (j <= target._num) { -->
<!-- 						imgArray[j].src = imgSrc_2; -->
<!-- 					} else { -->
<!-- 						imgArray[j].src = imgSrc; -->
<!-- 					} -->
<!-- 				} -->
<!-- 			} else { -->
<!-- 				for (var k = 0; k < imgArray.length; k++) { -->
<!-- 					imgArray[k].src = imgSrc; -->
<!-- 				} -->
<!-- 			} -->

<!-- 		} -->
<!-- 	</script> -->
<!-- </p> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1>GET SCORE</h1> -->
<!-- 	<p class="starWrapper" onmouseover="rate(this,event)"> -->
<!-- 	<img src="http://www.jb51.net/upload/20080508122008586.gif" title="很爛" /></a> -->
<!-- 	<img src="http://www.jb51.net/upload/20080508122008586.gif" title="一般" /></a> -->
<!-- 	<img src="http://www.jb51.net/upload/20080508122008586.gif" title="還好" /></a> -->
<!-- 	<img src="http://www.jb51.net/upload/20080508122008586.gif" title="較好" /></a> -->
<!-- 	<img src="http://www.jb51.net/upload/20080508122008586.gif" title="很好" /></a> -->


<!-- 		<BR> -->
<!-- 		<BR> -->
<!-- 		<HR> -->
<!-- 	<BR> -->
<!-- <span style="text-decoration: underline;">GetPoint..is.....</span> <span -->
<!-- 			id="e">*</span> -->
<!-- 	<P /> -->
<!-- 	<BR> -->
<!-- 	<BR> -->
<!-- 	<HR> -->
<!-- 	<BR> -->
<%-- 	<small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small> --%>
<!-- <!-- 	<small>&lt;&lt;<a href="../">回首頁</a>&gt;&gt; --> -->
	
<!-- >>>>>>> branch 'master' of https://github.com/EEIT87Team03/Aoide.git -->
</body>
</html>
