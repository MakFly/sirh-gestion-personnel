/**
 * 
 */
package util;

import service.CollaborateurService;
import service.DepartementService;

/**
 * @author kevin
 * @Interface Constantes
 */
public interface Constantes {
	
	/**
	 * @param Collab_service
	 */
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	
	/**
	 * @param Dept_service
	 */
	DepartementService DEPT_SERIVCE		= new DepartementService();

}
