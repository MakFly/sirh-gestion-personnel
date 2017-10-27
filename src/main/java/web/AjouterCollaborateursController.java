/**
 * 
 */
package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Collaborateur;
import service.CollaborateurService;
import util.Constantes;

@SuppressWarnings("serial")
public class AjouterCollaborateursController extends HttpServlet {
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	static int compteur = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/collab/new_collab.jsp")
		.forward(req, resp);
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		
		/*
		 * variable + 1 et non ++
		 */
		compteur = compteur + 1 ;
		String matricule	= "M"+compteur;
		
		/*
		 * Nom + prénom
		 */
		String nom 				= req.getParameter("nom");
		String prenom 			= req.getParameter("prenom");
		
		/*
		 * Parse de la date de naissance
		 */
		LocalDate dtn			= LocalDate.parse(req.getParameter("date_naissance"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	
		
		/*
		 * Stocker avec l'heure de création en mémoire
		 */
		LocalDateTime dhc		= LocalDateTime.now();
		
		/*
		 * Adresse + sécu
		 */
		String adresse 			= req.getParameter("adresse");
		String secu 			= req.getParameter("secu");
		
		/*
		 * Resource Bundle Application propertie pour avoir le suffixe @societe.com
		 */
		ResourceBundle bundle 	= ResourceBundle.getBundle("application");
		String emailPro			= bundle.getString("suffixe.emailPro");
		
		String message ="";
		
		if(matricule.isEmpty() || nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || secu.isEmpty() )
		{
			resp.sendError(400);
		}
		else
		{
			message = "Collaborateur crée avec succès";
		}
		
		Collaborateur collabateur = new Collaborateur(matricule, nom, prenom, dtn, adresse, secu, emailPro, null, dhc, true);
		collabService.sauvegarderCollaborateur(collabateur);
		
		
		/* Transmission à la page JSP en charge de l'affichage des données */		
		
		resp.sendRedirect("lister");
		
		
	}
}