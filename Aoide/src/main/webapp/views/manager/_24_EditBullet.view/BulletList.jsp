<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bullet</title>

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
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<a href=""></a>
					</div>
					<div class="panel-body">
                        
                        <td><a href="<c:url value='/_24_EditBullet.view/Uploadbullet.jsp'/>">Upload</a></td>
						
						<table class="table">
							<thead>
								<tr>
									<th>No</th>
									<th>date</th>
									<th>title</th>
									<th>content_file</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="aBullet" items="${BulletList}">
									<tr>
										<td>${aBullet.bulletId}</td>
										<td>${aBullet.date}</td>
										<td>${aBullet.title}</td>
										<td>${aBullet.contentFile}</td>
                                        <td> 
                                        <input type="button" value="編輯"
                                            onclick="location.href='<c:url value='/ModifyBullet?id=${aBullet.bulletId}'/>'">　
										</td>
										<td><input type="button" value="刪除"
											onclick="location.href='<c:url value='/DeleteBullet?id=${aBullet.bulletId}'/>'">
										</td>
									</tr>
								</c:forEach>
								<tr>
								</tr>
							</tbody>
						</table>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
