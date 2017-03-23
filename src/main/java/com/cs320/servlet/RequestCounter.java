package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/requestCounter", loadOnStartup=1)
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestCounter() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		int counter = 0;
		getServletContext().setAttribute("counter", counter);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletContext servletContext = getServletContext();
		
		//get counter
		Integer counter = (Integer) servletContext.getAttribute("counter");
		

		//increment the counter
		++counter;
		
		//set it back to application context
		servletContext.setAttribute("counter", counter);
		
		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Request Counter</title></head><body>");
		out.println("<h2>The counter is incremented</h2>");
		out.println("</body></html>");
	}

}
