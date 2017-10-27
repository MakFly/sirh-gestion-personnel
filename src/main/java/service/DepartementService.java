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
 *
 */
public class DepartementService 
{
	List<Departement> listeDepartements = new ArrayList<>();
	public List<Departement> listeDepartements() {
		return listeDepartements;
	}
	public void sauvegarderCollaborateur(Departement dept) {
		listeDepartements.add(dept);
	}
}
