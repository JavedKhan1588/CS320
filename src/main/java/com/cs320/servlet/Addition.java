package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class Addition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Addition() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		if (a == null || b == null || a.trim().length() == 0 || b.trim().length() == 0 ){
			response.sendRedirect("AddForm.html");
			return;
		}
			int sum = Integer.parseInt(a) + Integer.parseInt(b);

		PrintWriter out = response.getWriter();

		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Add</title></head><body>");
		out.println("<p>" + a + "+" + b + "=" + sum + "</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

