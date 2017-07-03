<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
<%
String id=(String)request.getAttribute("id");
String name=(String)request.getAttribute("name");
String age=(String)request.getAttribute("age");
String banji=(String)request.getAttribute("class");
%>>
<p>学号：<%=id%> </p>
<p>姓名：<%=name%> </p>
<p>年龄：<%=age%> </p>
<p>班级：<%=banji%> </p>
</body>
</html>