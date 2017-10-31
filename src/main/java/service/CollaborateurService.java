/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.List;

import entite.Collaborateur;

/**
 * @author kevin
 * @Classe CollaborateurService
 */
public class CollaborateurService 
{
	/**
	 * @Liste des collaborateurs
	 */
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	/**
	 * 
	 * @return la liste des collaborateurs
	 */
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}
	
	/**
	 * 
	 * @param de sauvegarde d'un collaborateur
	 */
	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
	
	
}
