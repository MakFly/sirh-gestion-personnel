/**
 * 
 */
package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Collaborateur;
import entite.Departement;
import service.CollaborateurService;
import service.DepartementService;
import util.Constantes;

@SuppressWarnings("serial")
public class ListerCollaborateursController extends HttpServlet {
	
	// recuperation du service
	private CollaborateurService collabService 	= Constantes.COLLAB_SERVICE;
	private DepartementService deptService		= Constantes.DEPT_SERIVCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		// utilisation du service
		List<Collaborateur> collaborateurs 	= collabService.listerCollaborateurs();
		List<Departement> departements 		= deptService.listeDepartements();
		
//		LocalDateTime dateT = LocalDateTime.of(2017, 11, 8, 23, 8, 1);
//		LocalDate date = LocalDate.of(1992, 12, 14);
		
		//collaborateurs.add(new Collaborateur("007", "Bond", "James", null, "Londre", "123654789654789", "bond.james@london.eu", "test", dateT, true));
		
		/*
		 * Si le champs select == 0 alors on implémente sinon on ne fait rien
		 */
		if(departements.size() == 0)
		{
			departements.add(new Departement(1, "Comptabilité"));
			departements.add(new Departement(2, "Ressources Humaines"));
			departements.add(new Departement(3, "Informatique"));
			departements.add(new Departement(4, "Administratif"));
		}		
		
		req.setAttribute("listeCollab", collaborateurs);
		req.setAttribute("listeDept", departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/index.jsp")
		.forward(req, resp);
		
	}
}