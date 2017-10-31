/**
 * 
 */
package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

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
 * 
 * @author kevin
 * @Classe EditerCollaborateurController
 */
@SuppressWarnings("serial")
public class EditerCollaborateurController extends HttpServlet {
	
	/**
	 * @param CollaborateurService
	 */
	private CollaborateurService collabService 	= Constantes.COLLAB_SERVICE;
	
	/**
	 * @param DepartementService
	 */
	private DepartementService deptService		= Constantes.DEPT_SERIVCE;
	
	/**
	 * @Method doGet 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		/**
		 * @List des collaborateurs 
		 */
		List<Collaborateur> collaborateurs 	= collabService.listerCollaborateurs();
		
		/**
		 * @List des departements 
		 */
		List<Departement> departements 		= deptService.listeDepartements();
		
		/**
		 * @param matricule
		 */
		String matricule = req.getParameter("matricule");
	
		for (Collaborateur collaborateur : collaborateurs) 
		{
			if(collaborateur.getMatricule().equals(matricule))
			{
				req.setAttribute("Collab", collaborateur);
			}
			
		}
		
		/**
		 * @Init des département si la taille du département == 0
		 */
		if(departements.size() == 0)
		{
			departements.add(new Departement(1, "Comptabilité"));
			departements.add(new Departement(2, "Ressources Humaines"));
			departements.add(new Departement(3, "Informatique"));
			departements.add(new Departement(4, "Administratif"));
		}
		
		req.setAttribute("listeDept", departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/Edit_Banque.jsp")
		.forward(req, resp);
	}
	
	/**
	 * @Method doPost
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		/*
		 * Instanciation du matricule pour le département
		 */
		String matricule	= req.getParameter("matricule");
		
		
		/*
		 * Adresse 			: adresse
		 * intitulePoste 	: intitulePoste
		 * nom departement 	: depart
		 * banque			: banque
		 * bic				: bic
		 * iban				: iban
		 */
		String adresse 		= req.getParameter("adresse");
		String intitulePoste= req.getParameter("nomDept");
		String telephone	= req.getParameter("telephone");
		String bic			= req.getParameter("bic");
		String iban			= req.getParameter("iban");
		
		Departement depart 	= new Departement(0, req.getParameter("poste"));
		
		/*
		 * Test si les champs ne sont pas vide lors de l'update
		 */
		String message ="";
		
		if(matricule.isEmpty() || adresse.isEmpty() )
		{
			resp.sendError(400);
		}
		else
		{
			message = "Collaborateur mis à jour avec succès";
		}
		
		
		/**
		 * @BoucleFor
		 * La boucle permet d'afficher la liste des collaborateurs par 
		 * Matricule
		 * Adresse
		 * intitule de poste
		 * departement
		 * telephone
		 * bic
		 * iban
		 */
		for (Collaborateur collab: collabService.listerCollaborateurs()) {
			if (collab.getMatricule().equals(matricule)) {
				collab.setAdresse(adresse);
				collab.setIntitulePoste(intitulePoste);
				collab.setDepartement(depart);
				collab.setTelephone(telephone);
				collab.setBic(bic);
				collab.setIban(iban);
			}
		}
				
		
		/* Transmission à la page JSP en charge de l'affichage des données */		
		
		resp.sendRedirect("lister");
		
	}
}