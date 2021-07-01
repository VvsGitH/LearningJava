package com.fourthExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter1")
public class Counter1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final int INITIAL_COUNT = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Integer counter = (Integer) request.getAttribute("counter");
		if (counter == null)
			counter = INITIAL_COUNT;
		out.print("<p>" + counter + "</p>\n");


		if (counter < 10) {
			counter++;
			request.setAttribute("counter", counter);

			RequestDispatcher rd = request.getRequestDispatcher("counter2");
			rd.include(request, response);
		}

		out.close();

	}

}
