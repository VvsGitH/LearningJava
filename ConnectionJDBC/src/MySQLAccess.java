import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	// private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() {
		try {
			// Uso la reflection per verificare la presenza della libreria esterna: se non
			// esiste verrà lanciato un errore.
			// Inoltre la classe Driver ha un funzionamento particolare: nel momento in cui
			// viene caricata essa crea un'istanza di se stessa e la registra con il
			// Driver Manager.
			// Nota: la riga di codice sottostante non è più richiesta, in quanto il Driver
			// Manager cercherà automaticamente la presenza del driver quando viene
			// chiamato.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Mi connetto al server del database
			// Username e password sono passati in chiaro... Ci deve essere un altro modo
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root",
					"wH8b99ZP3XGDKmfoKt3y");

			// Creo un oggetto Statement e lo uso per inviare una query
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM pet");

			// Il risultato della query è un iteratore immutabile che si può scorrere
			// solo in una direzione.
			// Con next() vai alla riga successiva, mentre con i vari get ottieni i dati
			// presenti sulle colonne della stessa riga.
			while (resultSet.next()) {
				System.out.println("Nome: " + resultSet.getString(1));
				System.out.println("Cognome: " + resultSet.getString(2));
				System.out.println("Repart: " + resultSet.getString(3));
				System.out.println("------------------------------------");
			}

			// Termino la connessione
			connect.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MySQLAccess acc = new MySQLAccess();
		acc.readDataBase();
	}

}
