package com.simplilearn.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSession
 */
public class TestSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int data = 0; //After the session is created, it will not touch this line again.
		HttpSession session = request.getSession(); //You create a session for the user
		PrintWriter out = response.getWriter();
		
		response.getWriter();
		if (session.isNew())
		{
			data = 1;
			session.setAttribute("count", data+""); //They can be set as ServletContext, ServletRequest 
													//Created on server side
			out.println("This is your first time visiting.");
		}
		else
		{
			data = Integer.parseInt((String)session.getAttribute("count"));
			data++;
			session.setAttribute("count", data+"");
			out.println("You have visited = "+data+"<br>");
			out.println("<a href="+"logoff"+">Logout</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
