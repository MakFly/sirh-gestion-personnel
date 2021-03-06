<%@page import="entite.Collaborateur"%>
<%@page import="entite.Departement"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>SGP - App</title>

    <!-- Bootstrap core CSS -->
    <link href="../../sgp/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../sgp/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.4.5/js/bootstrapValidator.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.4.5/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script src="../../sgp/js/jquery-3.2.1.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="../../sgp/styles.css" rel="stylesheet">
    
    <script type="text/javascript">
	    function valider() 
	    {
			document.forms[0].submit();
		}
    </script>
  
</head>

<body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="lister">Login</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="edit">Collaborateur <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="statistique.html">Statistique</a>
                </li>
                <li class="nav-item">
                    <!-- <a class="nav-link disabled" href="#">Disabled</a> -->
                    <a class="nav-link" href="activite.html">Activité</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Partie Haut Ã  droite -->
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <%-- <a id="add_collabo" class="btn btn-primary" href="<%=request.getContextPath()+"/collaborateurs/ajouter"%>" role="button">Ajouter un nouveau Collaborateur</a> --%>
                <a id="add_collabo" class="btn btn-primary" href="<c:url value='/collaborateurs/ajouter'/>" role="button">Ajouter un nouveau Collaborateur</a>
            </div>
        </div>

    </div>

    <!-- Partie Haut -->
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Les Collaborateurs</h1>
                <p>
                    Rechercher un nom ou prénom qui commence par : <input type="text" class="form-control-sm" name="name"> &nbsp&nbsp&nbsp
                    <form method="POST" action="<%=request.getContextPath()%>/collaborateurs/filtrer"><button type="submit" onclick="valider()" class="btn btn-primary">Rechercher</button>
                    <input class="form-check-input" type="checkbox" value=""> &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Voir les Collaborateurs désactivés

                </p>

				<!-- Filtrer par département -->
                <p id="col_colla">
                    Filtrer par département :
                    <select class="form-control-sm" name="nomDept">
                        <option>Tous</option>
                        <%
							List<Departement> listDept = (List<Departement>) request.getAttribute("listeDept");
							for (Departement dept : listDept) 
							{
						%>
							<option><%=dept.getNom() %></option>
						<%
							}
						%>
                    </select>
                </p>

				</form>
			</div>
        </div>
    </div>

    <!-- Partie Milieu -->
    <div class="container">
        <div class="row">
			<%
				List<Collaborateur> list = (List<Collaborateur>) request.getAttribute("listeCollab");
				for (Collaborateur col : list) {
					
			%>
			<div class="col-md-4">
				<article class="card">
					<header class="title-header">
						<h3>
							<%=col.getNom()%>
							<%=col.getPrenom()%>
							<%=col.getMatricule()%>
							<%-- <%=col.getDhc()%> --%>
						</h3>
						<hr class="separateur">
					</header>
					<div class="card-block">
						<div class="img-card">
							<span class="img_left"><img src="//placehold.it/150x80" alt="Movie" class="w-100" /></span><span class="right"></span> 
							<span class="left">Fonction <%=col.getIntitulePoste() %></span><span class="right"></span> 
							<% 	if (col.getDepartement()!=null){ %>
								<span class="left">Département <%= col.getDepartement().getNom() %></span><span class="right"></span> 
							<%	} 
							else {%>
								<span class="left">Département non défini</span><span class="right"></span> 
							<% } %>
							<span class="left">Email <%= col.getNom() %>.<%= col.getPrenom() %> <%= col.getEmailPro() %></span>
							<span class="right"></span> 
							<span class="left">Téléphone <%= col.getTelephone() %></span><span class="right"></span>
						</div>

						<a href="<%=request.getContextPath()%>/collaborateurs/editer?matricule=<%=col.getMatricule()%>"  class="btn btn-primary btn-block"><i
							class="fa fa-eye"></i> Editer</a>
					</div>
				</article>
			</div>
			<%
					}
				%>
			
			<!-- <div class="col-md-4">
                <article class="card">
                    <header class="title-header">
                        <h3>Nom Prénom</h3>
                        <hr class="separateur">
                    </header>
                    <div class="card-block">
                        <div class="img-card">
                            <span class="img_left"><img src="//placehold.it/150x80" alt="Movie" class="w-100" /></span><span class="right"></span>
                            <span class="left">Fonction</span><span class="right"></span>
                            <span class="left">Département</span><span class="right"></span>
                            <span class="left">Email</span><span class="right"></span>
                            <span class="left">Téléphone</span><span class="right"></span>
                        </div>

                        <a href="#" class="btn btn-primary btn-block"><i class="fa fa-eye"></i> Editer</a>
                    </div>
                </article>
            </div> -->
        </div>
    </div>
    <!-- /.container -->

</body>

</html>