import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExecute {
	
	private String timezone = "serverTimezone=UTC";
	private String schema = "sakila";
	
	private Connection connect = null;
	private Statement statement = null;
	
	public boolean connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = String.format("jdbc:mysql://localhost:3306/%s?&%s", schema, timezone);
			connect = DriverManager.getConnection(url, "root", "wH8b99ZP3XGDKmfoKt3y");
			statement = connect.createStatement();
			
			return true;
			
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Driver not found! " + cnfe.getMessage());
			return false;
		
		} catch (SQLException e) {
			manageSqlException(e);
			return false;
		}
	}
	
	public void closeDBConnection() {
		try {
			statement.close();
			connect.close();
		} catch (SQLException e) {
			manageSqlException(e);
		}
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
	
	public void executeCommand(String sql) {
		try {			
			boolean resType = statement.execute(sql);
			
			if (resType) {
				ResultSet res = statement.getResultSet();
				printResultSet(res);
				res.close();
			} else {
				System.out.println("Number of updates: " + statement.getUpdateCount());
			}
	
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}
	
	private void printResultSet(ResultSet rs) {
		try {
			ResultSetMetaData resMeta = rs.getMetaData();
			int colsnum = resMeta.getColumnCount();
			while (rs.next()) {
				for (int i=1; i <= colsnum; i++) {
					System.out.println("	"
							+ resMeta.getColumnName(i).toUpperCase()
							+ ": "
							+ rs.getString(i));
				}
				System.out.println("------------------------------------");
			}
		} catch (SQLException e) {
			manageSqlException(e);
		}		
	}

	public static void main(String[] args) {
		MySQLExecute db = new MySQLExecute();
		if (!db.connectToDB())
			return;
		
		// PER QUALCHE MOTIVO QUESTO CODICE NON FUNZIONA!
		String sql = "SELECT * FROM film;\n" 
				+ "INSERT INTO film (film_id, title, language_id) VALUES (1001, 'TestFilm', 1);\n"
				+ "UPDATE film SET length = 100 WHERE title = 'TestFilm';\n"
				+ "SELECT * FROM film where title = 'TestFilm';";
		db.executeCommand(sql);
		
		db.closeDBConnection();
	}

}
