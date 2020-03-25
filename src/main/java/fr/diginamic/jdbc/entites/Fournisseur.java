package fr.diginamic.jdbc.entites;

/** Représente un fournisseur
 * @author Xavier CALLOCH
 *
 */
public class Fournisseur {
	
	/** identifiant */
	private int id;
	
	/** nom */
	private String nom;
	
	/** Constructeur
	 * @param id	identifiant
	 * @param nom	nom
	 */
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Identifiant: " + getId() + " - Nom: " + getNom();
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
