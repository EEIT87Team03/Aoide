<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


    <!-- Custom styles for this template -->
    <link href="css/sideBar.css" rel="stylesheet">

</head>
<body>
<div class="container">
	<h3>Aoide<br />
        <small>Hello! ${logInToken}</small>
    </h3>
    <br />
    
    <div class="row">
        <div class="col-sm-2">
            <nav class="nav-sidebar">
                <ul class="nav">
                    <li class="active"><a href="javascript:;">Home</a></li>
                    <li><a href="javascript:;">LogIn</a></li>
                    <li><a href="javascript:;">Manage Demuku Accusement</a></li>
                    <li><a href="<c:url value = '/ListSuggestionsServlet'/>">Manage Reply Suggestions</a></li>
                    <li><a href="javascript:;">Edit Bullet</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="/AOIDE01/_08_login.view/login.jsp"><i class="glyphicon glyphicon-off"></i> Sign in</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-sm-2 col-sm-offset-8">
        <nav class="nav-sidebar pull-right">
                <ul class="nav">
                    <li class="active"><a href="javascript:;">Home</a></li>
                    <li><a href="javascript:;">A long link will naturally wrap around</a></li>
                    <li class="text-overflow" title="An long link with .text-overflow"><a href="javascript:;">A link with .text-overflow can be applied in case it's too long!</a></li>
                    <li>
                        <a href="javascript:;" class="media">
                            <span class="pull-left">
                                <i class="media-object glyphicon glyphicon-list"></i>
                            </span>
                            <div class="media-body">
                                A media object can also be a link, making longer wrapping links play well with the icons!
                            </div>
                        </a>
                    </li>
                    <li class="text-overflow" title="Combine them all to make an awesome, safe solution!">
                        <a href="javascript:;" class="media">
                            <span class="pull-left">
                                <i class="media-object glyphicon glyphicon-list"></i>
                            </span>
                            <div class="media-body">
                                Combine them all to make an awesome, safe solution!
                            </div>
                        </a>
                    </li>
                    <li class="nav-divider"></li>
                    <li><a href="javascript:;"><i class="glyphicon glyphicon-off"></i> Sign in</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>