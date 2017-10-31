/**
 * 
 */
package entite;


/**
 * @author kevin
 * @Classe Departement
 */
public class Departement {

	/**
	 * @Id du département
	 */
	private Integer id;
	/**
	 * @Nom du département
	 */
	private String nom;
	
	/**
	 * @Constructeur de la classe departement
	 * @param id
	 * @param nom
	 */
	public Departement(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return l'id courant du département
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @update de l'id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @update du nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
