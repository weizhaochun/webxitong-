<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
<form action="/webxitong/LoginServlet" method="POST">
账号: <input type="text" name="id">
<br />
密码: <input type="text" name="psWorld" />
<input type="submit" value="登录" />
</form>

</body>
</html>