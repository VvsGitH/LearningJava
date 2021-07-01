import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLShell {
	private Connection connect = null;
	private Statement statement = null;

	private boolean connectToDB() {
		try {
			// Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connection
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root",
					"wH8b99ZP3XGDKmfoKt3y");
			
			// Statement
			statement = connect.createStatement();
			
			return true;

		} catch (ClassNotFoundException cnfe) {
			System.err.println("Driver non trovato! " + cnfe.getMessage());
			return false;
		} catch (SQLException sqle) {
			System.err.println("Errore SQL! " + sqle.getMessage());
			return false;
		}
	}

	private void closeConnection() {
		try {
			statement.close();
			connect.close();
		} catch (SQLException sqle) {
			System.err.println("Errore SQL! " + sqle.getMessage());
		}
	}

	public void startShell() {

		if (!connectToDB())
			return;

		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);

		String sql;
		int updret;

		out.println("\nInserire i comandi DDL/DML su una sola riga e premere invio.\n");

		while (true) {
			out.print("UpdateShell>> ");
			out.flush();

			// Ricevo sql
			while ((sql = in.nextLine()).equals(""))
				out.print("\nUpdateShell>> ");

			if (sql.equals("exit") || sql.equals("quit"))
				break;

			// Rimuovo il ; finale se l'utente l'ha inserito
			if (sql.charAt(sql.length() - 1) == ';')
				sql = sql.substring(0, sql.length() - 1);

			// Log to JDBC
			DriverManager.println(">> Esecuzione operazione <" + sql + ">");

			// Eseguo il comando
			try {
				updret = statement.executeUpdate(sql);
				out.println("Aggiornato/i " + updret + " records.\n");
				out.flush();
			} catch (SQLException sqle) {
				System.err.println("DBProblem: execute update: " + sqle.getMessage());
				continue;
			}
		}

		in.close();

		closeConnection();
	}

	public static void main(String[] args) {
		MySQLShell shell = new MySQLShell();
		shell.startShell();
	}

}
