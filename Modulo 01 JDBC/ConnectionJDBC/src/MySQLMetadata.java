import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLMetadata {
	private String timezone = "serverTimezone=UTC";
	private String schema = "sakila";
	
	private Connection connect = null;
	private DatabaseMetaData dbMeta = null;
	private Statement statement = null;
	
	public boolean connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = String.format("jdbc:mysql://localhost:3306/%s?&%s", schema, timezone);
			connect = DriverManager.getConnection(url, "root", "wH8b99ZP3XGDKmfoKt3y");
			
			dbMeta = connect.getMetaData();
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
	
	public void closeDBConnectiony() {
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
	
	public void getTables() {
		System.out.println("ALL THE TABLES INSIDE DB: " + schema);
		
		try {
			ResultSet tables = dbMeta.getTables(schema, null, "%", null);
			
			ArrayList<String> tableNames = new ArrayList<>(5);

			while(tables.next()) {
				tableNames.add(tables.getString("TABLE_NAME"));
			}
			System.out.println(tableNames);		
			
			tables.close();
			
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}
	
	public void getTableStructure(String tableName) {
		System.out.println("COLUMNS OF THE TABLE: " + tableName + "\n");
		
		try {
			ResultSet columns = dbMeta.getColumns(schema, null, tableName, null);
			ResultSetMetaData resMeta = columns.getMetaData();
			
			while(columns.next()) {
				for (int i = 4; i <= 11; i++) 
					System.out.println("	"
							+ resMeta.getColumnLabel(i)
							+ ": "
							+ columns.getString(i));
				System.out.println("------------------------------------");
			}
			
			columns.close();
		
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}
	
	public void sendQuery(String query) {
		try {			
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData resMeta = resultSet.getMetaData();
			
			int colsnum = resMeta.getColumnCount();		
			while (resultSet.next()) {
				for (int i=1; i <= colsnum; i++) {
					System.out.println("	"
							+ resMeta.getColumnName(i).toUpperCase()
							+ ": "
							+ resultSet.getString(i));
				}
				System.out.println("------------------------------------");
			}
			
			resultSet.close();
		
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}
	
	public static void main(String[] args) {
		MySQLMetadata db = new MySQLMetadata();
		if (!db.connectToDB())
			return;
		
		db.getTables();
		System.out.println();
		
		db.getTableStructure("film_actor");
		System.out.println();
		
		System.out.println("ALL MOVIES DONE BY DEBBIE AKROYD LONGER THAN 165 MINUTES\n");
		String query = "select title, description, length, release_year, rating\n"
				+ "from film\n"
				+ "where film_id in (\n"
				+ "	select film_id\n"
				+ "    from film_actor\n"
				+ "    where actor_id in (\n"
				+ "		select actor_id\n"
				+ "        from actor\n"
				+ "        where first_name = 'debbie' and last_name = 'akroyd'\n"
				+ "    )\n"
				+ ") and length > 165\n"
				+ "order by title;";
		db.sendQuery(query);
		
		db.closeDBConnectiony();
	}

}
