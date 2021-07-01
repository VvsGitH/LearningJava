import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
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

			// Creo un oggetto Statement per poter inviare query
			statement = connect.createStatement();

			// Ottengo il risultato della query in un array di record.
			// resultSet è un'interfaccia più che un oggetto. E' una sorta di cursore che
			// naviga sul set di dati fornito dalla query.
			// Di norma i ResultSet sono dunque immutabili e possono essere navigati in
			// una sola direzione.
			resultSet = statement.executeQuery("SELECT * FROM pet");

			// Navigo e elaboro il set di dati.
			// Con next() vai alla riga successiva, mentre con i vari get ottieni i dati
			// presenti sulle colonne della stessa riga.
			while (resultSet.next()) {
				System.out.println("Nome: " + resultSet.getString(1));
				System.out.println("Cognome: " + resultSet.getString(2));
				System.out.println("Repart: " + resultSet.getString(3));
				System.out.println("------------------------------------");
			}

			// Termino la connessione
			resultSet.close();
			statement.close();
			connect.close();

		} catch (ClassNotFoundException cnfe) {
			System.err.println("Driver non trovato! " + cnfe.getMessage());

		} catch (SQLException sqle) {
			System.err.println("Errore SQL! " + sqle.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MySQLAccess acc = new MySQLAccess();
		acc.readDataBase();
	}

}
