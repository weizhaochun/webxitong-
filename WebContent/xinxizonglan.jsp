<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>信息系统</title>
</head>
<body>
<!--
useUnicode=true&characterEncoding=utf-8 防止中文乱码
 -->
<h1>信息系统</h1>
<script>
function openSerch(){  window.open("serch1.jsp","serch","top=200,left=200,width=300,height=300,menubar=yes,scrollbars=no,toolbar=yes,status=yes");

}
</script>
<script>
function openInsert(){  window.open("insert.jsp","insert","top=200,left=200,width=300,height=300,menubar=yes,scrollbars=no,toolbar=yes,status=yes");

}
</script>
<script>
function openUpdate(){  window.open("update1.jsp","update","top=200,left=200,width=300,height=300,menubar=yes,scrollbars=no,toolbar=yes,status=yes");

}
</script>
<script>
function openDelete(){  window.open("delete1.jsp","delete","top=200,left=200,width=300,height=300,menubar=yes,scrollbars=no,toolbar=yes,status=yes");

}
</script>
<button onclick="openSerch();">查询</button>
<button onclick="openInsert();">增添</button>
<button onclick="openUpdate();">修改</button>
<button onclick="openDelete();">删除</button>
<table border="1" width="50%">
<tr>
   <th>学号</th>
   <th>姓名</th>
   <th>年龄</th>
   <th>班级</th>
</tr>
<%!
	Vector jilu,ziduan;
	PreparedStatement ps=null;
    Connection ct=null;
    ResultSet rs=null;
    
%>
<% try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=xinxixitong","sa","w123456");
				ps=ct.prepareStatement("select * from xinxi");	
				rs=ps.executeQuery();
				
				while(rs.next())
				  {	
					  out.print("<tr>");
					  out.print("<td>"+rs.getString(1)+"</td>");
					  out.print("<td>"+rs.getString(2)+"</td>");
					  out.print("<td>"+rs.getInt(3)+"</td>");
					  out.print("<td>"+rs.getString(4)+"</td>");
					  out.print("</tr>");
					  
				  }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    finally
		    {
		    	try {
		    		if(rs!=null)
					{
						rs.close();
					}
		    		if(ps!=null)
					{
						ps.close();
					}
					if(ct!=null)
					{
						ct.close();
					}
					
				} catch (Exception e){}
		    }
%>
</table>
 
</body>
</html>