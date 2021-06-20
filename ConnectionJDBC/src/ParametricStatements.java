import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParametricStatements extends MySQLConnection {
	
	public ParametricStatements(String schema) {
		super(schema);
	}
	
	public void executeQueries() {
		String sql = "select title, description, length, release_year, rating\n"
				+ "from film\n"
				+ "where film_id in (\n"
				+ "	select film_id\n"
				+ "    from film_actor\n"
				+ "    where actor_id in (\n"
				+ "		select actor_id\n"
				+ "        from actor\n"
				+ "        where first_name = ? and last_name = ?\n"
				+ "    )\n"
				+ ") and length > ?\n"
				+ "order by title;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// Query 1
			pstmt.setString(1, "debbie");
			pstmt.setString(2, "akroyd");
			pstmt.setInt(3, 160);
			ResultSet res = pstmt.executeQuery();
			printResultSet(res);
			
			// Query 2
			pstmt.setString(1, "debbie");
			pstmt.setString(2, "akroyd");
			pstmt.setInt(3, 170);
			res = pstmt.executeQuery();
			printResultSet(res);
			
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}

	public static void main(String[] args) {
		ParametricStatements db = new ParametricStatements("sakila");
		if (!db.connectToDB())
			return;
		
		db.executeQueries();

		db.closeDBConnection();
	}

}
