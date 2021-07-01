package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movieservlet")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private PreparedStatement filmsByActor;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = String.format("jdbc:mysql://localhost:3306/%s?&%s", "sakila", "serverTimezone=UTC");
			conn = DriverManager.getConnection(url, "root", "wH8b99ZP3XGDKmfoKt3y");

			prepareStatement();

		} catch (ClassNotFoundException cnfe) {
			throw new UnavailableException("Couldn't load database driver");

		} catch (SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}
	
	public void destroy() {
		try {
			if (conn != null)
				conn.close();

		} catch (SQLException ignored) {}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");

		if (firstName == null || lastName == null) {
			out.print("Something went wrong. Fill the form again!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			return;
		}
		
		try {
			ResultSet rs;
			synchronized (filmsByActor) {
				filmsByActor.clearParameters();
				filmsByActor.setString(1, "%" + firstName + "%");
				filmsByActor.setString(2, "%" + lastName + "%");
				rs = filmsByActor.executeQuery();
			}

			ResultSetMetaData resMeta = rs.getMetaData();
			int colsnum = resMeta.getColumnCount();
			
			out.println("<HTML><HEAD><TITLE>FILMS</TITLE></HEAD>");
			out.println("<BODY>");

			if (!rs.next()) {
				out.println("<H2>No results found!</H2>");
			
			} else {
				out.println("<UL>");
				do {
					out.println("<LI>\n<UL>");
					for (int i=1; i <= colsnum; i++) {
						out.println("<LI>"
								+ resMeta.getColumnName(i).toUpperCase()
								+ ": "
								+ rs.getString(i)
								+ "</LI>");
					}
					out.print("------------------------------------");
					out.println("</UL>\n</LI>");
				} while (rs.next());	
				out.println("</UL>");
			}
			
			out.println("</BODY></HTML>");
			rs.close();

		} catch (SQLException sqle) {
			manageSqlException(sqle);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void prepareStatement() throws SQLException{
		// Init query parametriche
		String filmQuery = "select f.title, f.description, f.release_year, a.first_name, a.last_name\n"
				+ "from film_actor fa\n"
				+ "	inner join film f on f.film_id = fa.film_id\n"
				+ "    inner join actor a on fa.actor_id = a.actor_id\n"
				+ "where a.first_name like ? and a.last_name like ?\n"
				+ "order by f.title;";
		filmsByActor = conn.prepareStatement(filmQuery);
	}

	private void manageSqlException(SQLException sqle) {
		System.err.println("SQL Exception!");
		while (sqle != null) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("SQL ErrorCode: " + sqle.getErrorCode());
			System.out.println();
			sqle = sqle.getNextException();
		}
	}

}
