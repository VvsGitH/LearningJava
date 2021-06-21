import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ParametricStatements extends MySQLConnection {
	
	private PreparedStatement filmsByActor;
	private PreparedStatement actorsIDByName;
	
	public ParametricStatements(String schema) {
		super(schema);
	}

	public boolean prepareStatements() {
		// Init query parametriche
		try {
			String filmQuery = "select title, description, length, release_year, rating\n"
					+ "from film\n"
					+ "where film_id in (\n"
					+ "	select film_id\n"
					+ "    from film_actor\n"
					+ "    where actor_id = ?)\n"
					+ "and length > ?\n"
					+ "order by title;";
			filmsByActor = conn.prepareStatement(filmQuery);
			
			String actorQuery = "select actor_id, first_name, last_name\n"
					+ "from actor\n"
					+ "where first_name like ?"
					+ "and last_name like ?;";
			actorsIDByName = conn.prepareStatement(actorQuery);

			return true;
		
		} catch (SQLException e) {
			manageSqlException(e);
			return false;
		}
	}
	
	public void searchActors(String firstName, String lastName) {
		try {
			actorsIDByName.setString(1, '%' + firstName + '%');
			actorsIDByName.setString(2, '%' + lastName + '%');
			
			ResultSet ids = actorsIDByName.executeQuery();

			printResultSet(ids);

			ids.close();
			actorsIDByName.close();
		
		} catch (SQLException e) {
			manageSqlException(e);
		}
	}

	public void searchFilms(int actorID, int length) {
		try {
			filmsByActor.setInt(1, actorID);
			filmsByActor.setInt(2, length);

			ResultSet films = filmsByActor.executeQuery();

			printResultSet(films);

			films.close();
			filmsByActor.close();

		} catch (SQLException e) {
			manageSqlException(e);
		}
	}

	public static void main(String[] args) {
		ParametricStatements db = new ParametricStatements("sakila");
		if (!db.connectToDB())
			return;
		
		if (!db.prepareStatements())
			return;

		Scanner in = new Scanner(System.in);

		System.out.println("Insert the first name of the actor:");
		System.out.flush();
		String firstName = in.nextLine();

		System.out.println("Insert the first name of the actor:");
		System.out.flush();
		String lastName = in.nextLine();

		db.searchActors(firstName, lastName);

		System.out.println("Insert the actor_id corresponding to your actor of choice:");
		System.out.flush();
		int actorID = in.nextInt();

		System.out.println("Insert the minimum length of the movies:");
		System.out.flush();
		int length = in.nextInt();

		db.searchFilms(actorID, length);

		in.close();
		db.closeDBConnection();
	}

}
