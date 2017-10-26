/**
 * 
 */
package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		// recupere la valeur d'un parametre dont le matricule
		String matricule 	= req.getParameter("matricule");
		String titre 		= req.getParameter("titre");
		String nom 			= req.getParameter("nom");
		String prenom 		= req.getParameter("prenom");
		resp.setContentType("text/html");
		
		
		if(matricule.isEmpty() && titre.isEmpty() && nom.isEmpty() && prenom.isEmpty())
		{
			resp.setStatus(400);
			resp.getWriter().write("Paramètre incorrect"
					+"<ul>"
					+ "<li>matricule</li>"
					+ "<li>titre	</li>"
					+ "<li>nom		</li>"
					+ "<li>prenom	</li>"
					+ "</ul>");
		}
		else {
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write("<h1>Editer des collaborateurs</h1>"
					+ "<ul>"
					+ "<li>matricule="+ matricule + "</li>"
					+ "<li>titre	="+ titre + "</li>"
					+ "<li>nom		="+ nom + "</li>"
					+ "<li>prenom	="+ prenom + "</li>"
					+ "</ul>");
		}
		
		
	}
}