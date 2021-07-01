package it.cybsec.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/insert")
public class InsertData extends HttpServlet {

	private DatabaseConnection dc;
	private Connection conn;
	private PreparedStatement st;
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
		try {
			dc = new DatabaseConnection();
			setStatement();
		} catch (Exception e) {

		}
	}
	
	private void setStatement() throws SQLException {
		conn = dc.getConnection();
		st = conn.prepareStatement("insert into actor(actor_id,first_name,last_name) values(?,?,?)");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		try {
			if(conn.isClosed())
				setStatement();
			
			st.setString(1, request.getParameter("id"));
			st.setString(2, request.getParameter("firstName"));
			st.setString(3, request.getParameter("lastName"));
			st.execute();
			st.close();
			conn.close();

			message += "Successfully inserted - id = '" + request.getParameter("id") + "'";
			message += " nome = '" + request.getParameter("firstName") + "'";
			message += " cognome = '" + request.getParameter("lastName") + "'";
			
			request.setAttribute("message", message);
			request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
