/**
 * 
 */
package entite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author kevin
 *
 */
public class Collaborateur {

	String matricule;
	String nom;
	String prenom;
	LocalDate dtn;
	String adresse;
	String secu;
	String emailPro;
	String photo;
	LocalDateTime dhc;
	Boolean actif;
	String intitulePoste;
	Departement departement;
	String banque;
	String bic;
	String iban;
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

	

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDtn() {
		return dtn;
	}
	public void setDtn(LocalDate dtn) {
		this.dtn = dtn;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSecu() {
		return secu;
	}
	public void setSecu(String secu) {
		this.secu = secu;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public LocalDateTime getDhc() {
		return dhc;
	}
	public void setDhc(LocalDateTime dhc) {
		this.dhc = dhc;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
