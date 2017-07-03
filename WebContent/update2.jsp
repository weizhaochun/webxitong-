<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改结果</title>
</head>
<body>
<%
String id=(String)request.getAttribute("id");
String name=(String)request.getAttribute("name");
String age=(String)request.getAttribute("age");
String banji=(String)request.getAttribute("class");
%>
<p>请修改：</p>
<form action="/webxitong/UpdateServlet2?oldid=<%=id%>" method="POST">
<p>学号：<input type="text" name="newid" value=<%=id%>></p>
<p>姓名：<input type="text" name="name" value=<%=name%>></p>
<p>年龄：<input type="text" name="age" value=<%=age%>></p>
<p>班级：<input type="text" name="banji" value=<%=banji%>></p>
<input type="submit" value="确认" />
</form>

</body>
</html>