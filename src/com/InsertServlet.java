package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GBK");	
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String banji=request.getParameter("class");
		
		PreparedStatement ps=null;
	    Connection ct=null;
	    ResultSet rs=null;
	    
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=xinxixitong","sa","w123456");
			ps=ct.prepareStatement("select * from xinxi where 学号=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				response.getWriter().write("<script language='javascript'>alert('学号已存在');"
                        + "window.location.href='insert.jsp';</script>");
			}
			else
			{
				ps=ct.prepareStatement("insert into xinxi values(?,?,?,?)");
				ps.setString(1,id);
				ps.setString(2,name);
				ps.setString(3,age);
				ps.setString(4,banji);
				ps.executeUpdate();
			
				response.getWriter().write(" <script language='javascript'>window.opener.location.href = 'xinxizonglan.jsp';</script>");
				response.getWriter().write("<script language='javascript'>alert('添加成功');</script>");
				response.getWriter().write(" <script language='javascript'>window.close() </script>");
			}
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
