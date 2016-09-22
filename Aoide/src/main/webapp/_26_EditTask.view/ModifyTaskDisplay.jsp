<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ModifyEditTaskDisplay</title>
</head>
<body>
   
<%--     ID:${taskId.taskId}<p> --%>
    name:${taskVO.name}<p>
	contentFile:${taskVO.contentFile}<p>
	reward:${taskVO.reward}<p>
	periodHour:${taskVO.periodHour}<p>
	beginDate:${taskVO.beginDate}<p>
	closeDate:${taskVO.closeDate}<p>

</body>
</html>