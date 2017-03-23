package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs320.model.GuestBookEntry;

@WebServlet("/editEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditEntry() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		int index = Integer.parseInt(request.getParameter("index"));
		
		GuestBookEntry entry = entries.get(index);
		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>Edit Entry</title></head><body>");
		out.println("<form action='editEntry' method='post'>");
		out.println("Name: <input type='text' name='name' value='" + entry.getName() + "'/></br>");
		out.println("<textarea name='message' rows='5' cols='60' value='" + entry.getMessage() + "'></textarea></br>");
		out.println("<input type='hidden' name='index' value='" + index + "' />");
		out.println("<input type='submit' value='Submit' />");
		out.println("</form>");
		out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		int index = Integer.parseInt(request.getParameter("index"));
		
		
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
	
		entries.get(index).setName(name);
		entries.get(index).setMessage(message);
		
		//entries.add(new GuestBookEntry(name, message));
		response.sendRedirect("guestBook");
	}

}