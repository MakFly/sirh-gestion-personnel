/**
 * 
 */
package entite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author kevin
 * @Classe Collaborateur
 */

/**
 * @author kevin
 *
 */
/**
 * @author kevin
 *
 */
public class Collaborateur {

	/*
	 * @Matricule du collaborateur
	 */
	String matricule;
	/*
	 * @Nom du collaborateur
	 */
	String nom;
	/*
	 * @Prenom du collaborateur
	 */
	String prenom;
	/*
	 * @Date de naissance du collaborateur
	 */
	LocalDate dtn;
	/*
	 * @Adresse du collaborateur
	 */
	String adresse;
	/*
	 * @Numéro de sécu du collaborateur
	 */
	String secu;
	/*
	 * @Email du collaborateur
	 */
	String emailPro;
	/*
	 * @Photo du collaborateur 
	 */
	String photo;
	/*
	 * @Date heure local 
	 */
	LocalDateTime dhc;
	/*
	 * Collaborateur @actif ou pas
	 */
	Boolean actif;
	/*
	 * Intitule du poste du collaborateur
	 */
	String intitulePoste;
	/*
	 * @Objet de la classe Departement
	 */
	Departement departement;
	/*
	 * @Banque du collaborateur
	 */
	String banque;
	/*
	 * @Bic du collaborateur
	 */
	String bic;
	/*
	 * @Iban du collaborateur
	 */
	String iban;
	/*
	 * @Telephone du collaborateur
	 */
	String telephone;
	

	/*
	 * Constructeur sauvegarde collabo	
	 */
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dtn, String adresse, String secu,
			String emailPro, String photo, LocalDateTime dhc, Boolean actif) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dtn = dtn;
		this.adresse = adresse;
		this.secu = secu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dhc = dhc;
		this.actif = actif;
	}
	
	/*
	 * Constructeur mise à jour
	 */
	public Collaborateur(String matricule, String adresse, String intitulePoste, Departement departement, String banque,
			String bic, String iban) {
		super();
		this.matricule = matricule;
		this.adresse = adresse;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
	}

	
	/*
	 * Retourne le nom de la banque
	 */
	public String getBanque() {
		return banque;
	}

	/*
	 * Met à jour le nom de la banque
	 */
	public void setBanque(String banque) {
		this.banque = banque;
	}

	/*
	 * Retourne le numero Bic
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * 
	 * @update bic
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

	/**
	 * 
	 * @return L'iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * 
	 * @update iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * 
	 * @return Le numéro de telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @update telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * 
	 * @return Le matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	
	/**
	 * 
	 * @update matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	/**
	 * 
	 * @return Le nom
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
	
	/**
	 * 
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * 
	 * @update du prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * 
	 * @return La date de naissance
	 */
	public LocalDate getDtn() {
		return dtn;
	}
	
	/**
	 * 
	 * @update Date de naissance
	 */
	public void setDtn(LocalDate dtn) {
		this.dtn = dtn;
	}
	
	/**
	 * 
	 * @return L'adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * 
	 * @update L'adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * 
	 * @return le numéro de sécurité sociale
	 */
	public String getSecu() {
		return secu;
	}
	
	/**
	 * 
	 * @update Du numéro de secu
	 */
	public void setSecu(String secu) {
		this.secu = secu;
	}
	
	/**
	 * 
	 * @return l'emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}
	
	/**
	 * 
	 * @update de l'emailPro
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	
	/**
	 * 
	 * @return la photo
	 */
	public String getPhoto() {
		return photo;
	}
	
	/**
	 * 
	 * @update de la photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * 
	 * @return la date heure local
	 */
	public LocalDateTime getDhc() {
		return dhc;
	}
	
	/**
	 * 
	 * @update de la date heure local
	 */
	public void setDhc(LocalDateTime dhc) {
		this.dhc = dhc;
	}
	
	/**
	 * 
	 * @return si le collaborateur est actif ou pas
	 */
	public Boolean getActif() {
		return actif;
	}
	
	/**
	 * 
	 * @update si le collaborateur est actif ou pas 
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	/**
	 * 
	 * @return l'intitulé du poste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}

	/**
	 * 
	 * @update de l'intitulé du poste
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	/**
	 * 
	 * @return le nom du departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * 
	 * @update met à jour le nom du département
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
