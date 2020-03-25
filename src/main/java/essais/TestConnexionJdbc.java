package essais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// étape 1 - enregistrer le pilote
		DriverManager.registerDriver(new Driver());

		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection("jdbc:mysql://uogoszmmpk0sswht:6GkqElC2w7mvd8cSji51@bjjvyoj1o5lufiykgkrg-mysql.services.clever-cloud.com:3306/bjjvyoj1o5lufiykgkrg", "uogoszmmpk0sswht", "6GkqElC2w7mvd8cSji51");

		boolean valide = connection.isValid(500);

		if (valide == true) {
			System.out.println("La connection fonctionne correctement");
		}
		else {
			System.out.println("Erreur de connection");
		}

		// étape 3 => libération des ressources
		connection.close();

	}

}
