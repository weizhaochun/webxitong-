package com;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("GBK");
		
		String id=request.getParameter("id");
		String psWorld=request.getParameter("psWorld");
		Vector jilu,ziduan;
		PreparedStatement ps=null;
	    Connection ct=null;
	    ResultSet rs=null;
	    int	flag=0;
	    
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=xinxixitong","sa","w123456");
			ps=ct.prepareStatement("select * from zhanghao");	
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString(1).equals(id))
				{
					flag=1;
					if(rs.getString(2).equals(psWorld))
						{
						response.sendRedirect("xinxizonglan.jsp");
						break;
						}
					else
					{
						response.getWriter().write("<script language='javascript'>alert('’À∫≈√‹¬Î¥ÌŒÛ');"
		                          + "window.location.href='index.jsp';</script>");
						break;
					}
				}
			}
			
			if(flag==0)
			{
				
				response.getWriter().write("<script language='javascript'>alert('’À∫≈√‹¬Î¥ÌŒÛ');"
			                          + "window.location.href='index.jsp';</script>");
			}
				  
			  
		} catch (ClassNotFoundException | SQLException e) {
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
		
	}

}
