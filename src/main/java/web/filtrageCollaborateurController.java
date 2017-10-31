/**
 * 
 */
package web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Collaborateur;
import entite.Departement;
import service.CollaborateurService;
import service.DepartementService;
import util.Constantes;

/**
 * @author kevin
 * @Classe Filtrage Collaborateur Controller
 */
@SuppressWarnings("serial")
public class filtrageCollaborateurController extends HttpServlet {

	/**
	 * @Objet collabservice 
	 */
	private CollaborateurService collabservice = Constantes.COLLAB_SERVICE;
	
	/**
	 * @objet deptService
	 */
	private DepartementService deptService		= Constantes.DEPT_SERIVCE;
	
	/**
	 * @Servlet doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		/**
		 * @List des départements
		 */
		List<Departement> departements 		= deptService.listeDepartements();
		if(departements.isEmpty())
		{
			departements.add(new Departement(1, "Comptabilité"));
			departements.add(new Departement(2, "Ressources Humaines"));
			departements.add(new Departement(3, "Informatique"));
			departements.add(new Departement(4, "Administratif"));
		}		
	
		req.setAttribute("listeDept", departements);
		
		/*
		 * @param nomDept
		 * Permettant de récupéré le nom du département
		 */
		String nomDept = req.getParameter("nomDept");
		List<Collaborateur> listeFiltree = collabservice.listerCollaborateurs()
			.stream()
			.filter(collab -> collab.getDepartement()!=null && collab.getDepartement().getNom().equals(nomDept))
			.collect(Collectors.toList());
		
		req.setAttribute("listeCollab", listeFiltree);
		req.getRequestDispatcher("/WEB-INF/views/collab/index.jsp").forward(req, resp);
		
	}
}
