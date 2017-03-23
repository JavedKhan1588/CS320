package com.cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs320.model.GuestBookEntry;

@WebServlet(urlPatterns="/guestBook", loadOnStartup=1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBook() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry(1, "javed", "hello"));
		entries.add(new GuestBookEntry(2, "john", "hi"));

		getServletContext().setAttribute("entries", entries);
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		PrintWriter out = response.getWriter();

		// this makes sure that it is an html page
		response.setContentType("text/html");

		out.println("<html><head><title>GuestBook</title></head><body>");
		out.println("<h2>GuestBook<h2>");
		out.println("<table border=1>");
		out.println("<tr><th>Name</th><th>Message</th><th>Operations</th></tr>");
		for(int i = 0; i < entries.size(); ++i){
			
			GuestBookEntry entry = entries.get(i);
			out.println("<tr><td>" + entry.getName() + "says: </td><td>"
					+ entry.getMessage() + "</td><td><a href='editEntry?id=" + entry. getId() + "'>Edit</a> | <a href='deleteEntry?id=" + entry.getId() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<p><a href='addComment'>Leave a Comment</a></p>");
		out.println("<p><a href='addCommentWithCookie'>Add a Comment(with cookie)</a></p>");
		out.println("<p><a href='addCommentWithSession'>Add a Comment(with session)</a></p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
