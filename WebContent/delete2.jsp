<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除确认界面</title>
</head>
<body>
<%
String id=(String)request.getAttribute("id");
String name=(String)request.getAttribute("name");
String age=(String)request.getAttribute("age");
String banji=(String)request.getAttribute("class");
%>
<p>请确认是否要删除</p>
<p>学号：<%=id%> </p>
<p>姓名：<%=name%> </p>
<p>年龄：<%=age%> </p>
<p>班级：<%=banji%> </p>

<input type="button" value="确认" onclick="window.location.href='/webxitong/DeleteServlet2?id=<%=id%>'"/>
<input type="button" value="取消" onclick="window.location.href='delete1.jsp'"/>

</body>
</html>