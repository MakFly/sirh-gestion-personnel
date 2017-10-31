/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.List;

import entite.Collaborateur;
import entite.Departement;

/**
 * @author kevin
 * @Classe DepartementService
 */
public class DepartementService 
{
	/**
	 * @Liste des départements
	 */
	List<Departement> listeDepartements = new ArrayList<>();
	
	/**
	 * 
	 * @return la liste des départements
	 */
	public List<Departement> listeDepartements() {
		return listeDepartements;
	}
	
	/**
	 * 
	 * @param de sauvegarde de collaborateur
	 */
	public void sauvegarderCollaborateur(Departement dept) {
		listeDepartements.add(dept);
	}
}
