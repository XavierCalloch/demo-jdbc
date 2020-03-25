package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		
		Connection connection = null;
		Statement statement = null;
		
		// Try with resources
		// Les variables doivent implémenter l'interface java.util.AutoCloseable
		try {
			connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
					db.getString("db.pass"));
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Erreur de requête");
		}

		// étape 4 - exécuter la requête
		// 4.1 - exemple insert, update, delete
		int nbLignesImpactees = statement.executeUpdate("insert into fournisseur(id, nom) values(4, 'La Maison de la Peinture')");

		// étape 5 => libération des ressources
		statement.close();
		connection.close();

	}

}
