package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs320.model.GuestBookEntry;

@WebServlet("/addCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int idSeed = 100;
	public AddCommentWithSession() {
		super();
	}
	
	@SuppressWarnings("unused")
	private String getUserNameFromCookie(HttpServletRequest request){
		for(Cookie cookie : request.getCookies())
			if(cookie.getName().equals("name"))
				return cookie.getValue();
			
			return null;
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='addCommentWithSession' method='post'>");
		String name = (String) request.getSession().getAttribute("name");
		if(name != null){
			out.println("Name:" + name + "</br>");
		}
		else
		out.println("Name: <input type='text' name='name' /></br>");
		
		out.println("<textarea name='message' rows='5' cols='60'></textarea>");
		out.println("<input type='submit' value='Submit' />");
		out.println("</form>");
		out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String) request.getSession().getAttribute("name");
		
		if(name == null){
			name = request.getParameter("name");
			request.getSession().setAttribute("name", name);
		}
		String message = request.getParameter("message");
		
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		entries.add(new GuestBookEntry(idSeed++, name, message));
		response.sendRedirect("guestBook");
	}

}
