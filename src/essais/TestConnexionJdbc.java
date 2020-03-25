package essais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException {
		
		// étape 1 - enregistrer le pilote
        DriverManager.registerDriver(new Driver());
        
		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
		
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
