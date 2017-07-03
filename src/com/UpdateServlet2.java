package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doPost(request,response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GBK");
		
		String oldid=request.getParameter("oldid");
		String newid=request.getParameter("newid");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String banji=request.getParameter("banji");
		
		PreparedStatement ps=null;
	    Connection ct=null;
	    ResultSet rs=null;
	    
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=xinxixitong","sa","w123456");
			ps=ct.prepareStatement("update xinxi set 学号=?,姓名=?,年龄=?,班级=? where 学号='"+oldid+"'");
			ps.setString(1,newid);
			ps.setString(2,name);
			ps.setString(3,age);
			ps.setString(4,banji);
			ps.executeUpdate();
			
			response.getWriter().write(" <script language='javascript'>window.opener.location.href = 'xinxizonglan.jsp';</script>");
			response.getWriter().write("<script language='javascript'>alert('修改成功');</script>");
			response.getWriter().write(" <script language='javascript'>window.close() </script>");	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	try {
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
	}

}
