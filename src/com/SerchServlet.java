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
 * Servlet implementation class SerchServlet
 */
@WebServlet("/SerchServlet")
public class SerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GBK");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=null;
		String banji=null;
		
		PreparedStatement ps=null;
	    Connection ct=null;
	    ResultSet rs=null;
	    
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=xinxixitong","sa","w123456");
			ps=ct.prepareStatement("select * from xinxi where 学号=? or 姓名=?");
			ps.setString(1,id);
			ps.setString(2,name);
			rs=ps.executeQuery();
			
			if(rs.next())
			{	
				id=rs.getString(1);
				name=rs.getString(2);
				age=rs.getString(3);
				banji=rs.getString(4);
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("age", age);
				request.setAttribute("class", banji);
				
				request.getRequestDispatcher("serch.jsp").forward(request, response);
			}
			else
			{
				response.getWriter().write("<script language='javascript'>alert('无此学号或无此姓名');"
                        + "window.location.href='serch1.jsp';</script>");
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
