package essais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException {
		
		// �tape 1 - enregistrer le pilote
        DriverManager.registerDriver(new Driver());
        
		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compta", "root", "");
		
		boolean valide = connection.isValid(500);
		
		if (valide == true) {
			System.out.println("La connection fonctionne correctement");
		}
		else {
			System.out.println("Erreur de connection");
		}
		
		// �tape 3 => lib�ration des ressources
        connection.close();

	}

}
