package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));
		
		// Création d'une liste de fournisseurs
		List<Fournisseur> listeF = new ArrayList<>();

		// Try with resources
		// Les variables doivent implémenter l'interface java.util.AutoCloseable
		try (Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from fournisseur");) {
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("nom"));
				listeF.add(new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom")));
			}
			
			for (Fournisseur f : listeF) {
				System.out.println(f.toString());
			}

			// étape 5 => libération des ressources
			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Erreur de requête");
		}

	}

}
