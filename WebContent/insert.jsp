<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加界面</title>
</head>
<body>
<body>
<form action="/webxitong/InsertServlet" method="POST">
学号: <input type="text" name="id">
<br />
姓名: <input type="text" name="name" />
<br />
年龄: <input type="text" name="age">
<br />
班级: <input type="text" name="class" />
<br />
<input type="submit" value="添加" />
</form>

</body>
</html>