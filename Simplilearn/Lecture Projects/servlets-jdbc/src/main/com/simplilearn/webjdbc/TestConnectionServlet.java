package com.simplilearn.webjdbc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConnectionServlet
 */
public class TestConnectionServlet extends HttpServlet 
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource_mysql.properties");
			Properties props = new Properties();
			props.load(in);
			
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("pass"));
			out.println("Connected to the database....");
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy()
	{
		try 
		{
			con.close();	
		} catch (SQLException e) {
			
		}
		
	}

}
