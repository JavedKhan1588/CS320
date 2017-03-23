package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/countDown")
public class CountDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int count = 10;

	public CountDown() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Countdown</title></head><body>");
		
		if(count == 0){
			out.println("<h2>Rocket Launched<h2>");
		}
		else{
			out.println("<h3>" + count + "</h3>");
			response.setHeader("Refresh", "1");
			--count;
		}
		
		out.println("</body></html>");
	}

}
