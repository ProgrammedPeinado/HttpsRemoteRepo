package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet implements Servlet {
	
    /**
     * Default constructor. 
     */
	
	ServletConfig config; //1. init parameters 2. obtaining ServletContext 1:1 for every servlet
	
	
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("From init method()");
		this.config = config; 
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Destroyed invoked.");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This is my first servlet program."; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println(getServletInfo());
		out.println("<br>");
		String email = config.getInitParameter("email");
		out.println("Your email: "+email+"<br>");
		
		//How to obtain ServletContext instance
		ServletContext context = config.getServletContext();
		String token = context.getInitParameter("authtoken");
		out.println("Your token for access is: "+token+"<br>");
		
		//Request 1:1, 1 request and response object pair for every user
		String user = request.getParameter("userid");
		out.println("Your user id is: "+user+"<br>");
		
		//Post invokes this as well
		//out.println("Your username is: "+uname+"<br>")
		
		out.close();
	}

}
