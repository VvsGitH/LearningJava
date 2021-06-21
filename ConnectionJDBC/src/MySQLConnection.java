import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MySQLConnection {

	private String timezone = "serverTimezone=UTC";
	private String schema;
	
	protected Connection conn = null;
	
	public MySQLConnection(String schema) {
		this.schema = schema;
	}
	
	public boolean connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = String.format("jdbc:mysql://localhost:3306/%s?&%s", schema, timezone);
			conn = DriverManager.getConnection(url, "root", "wH8b99ZP3XGDKmfoKt3y");
			
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
			conn.close();
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}
	
	protected void manageSqlException(SQLException sqle) {
		System.err.println("SQL Exception!");
		while (sqle != null) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("SQL ErrorCode: " + sqle.getErrorCode());
			System.out.println();
			sqle = sqle.getNextException();				
		}
	}
	
	protected void printResultSet(ResultSet rs) {
		try {
			ResultSetMetaData resMeta = rs.getMetaData();
			int colsnum = resMeta.getColumnCount();

			if (!rs.next()) {
				System.out.println("No results found!");
				return;
			}

			do {
				for (int i=1; i <= colsnum; i++) {
					System.out.println("	"
							+ resMeta.getColumnName(i).toUpperCase()
							+ ": "
							+ rs.getString(i));
				}
				System.out.println("------------------------------------");
			} while (rs.next());

		} catch (SQLException e) {
			manageSqlException(e);
		}		
	}
	
	protected void printUpdateCount(int updateCount) {
		System.out.println("Number of updates: " + updateCount);
	}
}
