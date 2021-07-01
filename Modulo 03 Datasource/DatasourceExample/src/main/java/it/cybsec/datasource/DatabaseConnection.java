package it.cybsec.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	static private DataSource ds = null;

	public DatabaseConnection() throws NamingException {
		if (ds == null)
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/sakila");
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
