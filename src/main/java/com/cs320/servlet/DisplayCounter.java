package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayCounter")
public class DisplayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayCounter() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletContext servletContext = getServletContext();
		
		//get counter
		Integer counter = (Integer) servletContext.getAttribute("counter");

		
		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Display Counter</title></head><body>");
		out.println("<h2>The current value of counter is:" + counter + "</h2>");
		out.println("</body></html>");
	}

}
