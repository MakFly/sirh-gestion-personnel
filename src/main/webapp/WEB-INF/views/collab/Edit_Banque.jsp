<!-- Pour avoir un objet clic droit jsp editor -->
<%@page import="entite.Collaborateur"%>
<%@page import="entite.Departement"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>SGP - App</title>

<!-- Bootstrap core CSS -->
<link href="../../sgp/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.4.5/js/bootstrapValidator.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.4.5/css/bootstrapValidator.min.css"
	rel="stylesheet" />
<script src="../../sgp/js/jquery-3.2.1.min.js"></script>
<script src="../../sgp/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="../../sgp/styles.css" rel="stylesheet">

<script type="text/javascript">
		function valider() 
		{
			
			if(document.getElementById("nomDept").isEmpty())
			{
				alert("champs vide");
			}
			else
			{
				document.forms[0].submit();
			}
			
		}
	</script>

</head>

<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="lister">Login</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Collaborateur
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="statistique.html">Statistique</a></li>
				<li class="nav-item">
					<!-- <a class="nav-link disabled" href="#">Disabled</a> --> <a
					class="nav-link" href="activite.html">Activité</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<span class="img"><img src="//placehold.it/300x300"
					alt="Movie" class="w-100" /></span><span class="right"></span>
			</div>
			<div class="col-md-9">
				<form class="form-inline">
					<%
	                Collaborateur collab = (Collaborateur) request.getAttribute("Collab"); 
                	if (collab!=null) {
					%>
					<h1>
						<%=collab.getNom()%>
						<%=collab.getPrenom()%>
						<%=collab.getMatricule()%>
					</h1>
					<%
						}
                    %>
					<input class="form-check-input-edit" type="checkbox" value="">
					<p class="desactiver">Désactiver</p>
				</form>


				<form method="POST">
					<div id="accordion" role="tablist">
						<div class="card_edit">
							<div class="card-header" role="tab" id="headingOne">
								<h5 class="mb-0">
									<a class="collapsed" data-toggle="collapse" href="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne">
										Identité </a>
								</h5>
							</div>
							<div id="collapseOne" class="collapse" role="tabpanel"
								aria-labelledby="headingOne" data-parent="#accordion">
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><span class="left_add_collab">Civilité</span><span
											class="right"></span> <select
											class="form-control-sm form-edit">
												<option>Monsieur</option>
												<option>Madame</option>
										</select> <%
                                        	if (collab!=null) {
										%> <input type="hidden" value="<%=collab.getMatricule()%>"
											name="matricule"> <span class="left_add_collab">Nom</span><span
											class="right"></span><input disabled="disabled" type="text"
											class="form-controle-collab" value="<%=collab.getNom()%>"
											name="nom"> <span class="left_add_collab">Prénom</span><span
											class="right"></span><input disabled="disabled" type="text"
											class="form-controle-collab" value="<%=collab.getPrenom()%>"
											name="prenom"> <span class="left_add_collab">Date
												de naissance</span><span class="right"></span><input
											disabled="disabled" type="text" class="form-controle-collab"
											value="<%=collab.getDtn()%>" name="dtn"> <span
											class="left_add_collab">Adresse</span><span class="right"></span>
										<textarea required class="form-controle-collab" name="adresse"><%=collab.getAdresse()%></textarea>
											<span class="left_add_collab">Numéro de sécurité
												sociale</span><span class="right"></span><input disabled="disabled"
											required type="text" class="form-controle-collab"
											value="<%=collab.getSecu()%>" name="secu"> <span
											class="left_add_collab">Téléphone</span><span class="right"></span><input
											type="text" class="form-controle-collab"
											value="<%=collab.getTelephone()%>" name="telephone">
										</li>
										<% } %>
									</ul>
								</div>
							</div>
						</div>

						<!--  -->
						<div class="card_edit">
							<div class="card-header" role="tab" id="headingTwo">
								<h5 class="mb-0">
									<a class="collapsed" data-toggle="collapse" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo"> Poste </a>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse show" role="tabpanel"
								aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><span class="left_add_collab">Département</span><span
											class="right"></span> <select name="poste"
											class="form-control-sm form-edit">
												<%
												List<Departement> listDept = (List<Departement>) request.getAttribute("listeDept");
                                            	if (listDept!=null){
													for (Departement dept : listDept) {
														
														if(collab.getDepartement()!= null && collab.getDepartement().getNom().equals(dept.getNom()))
														{
															
														
												%>
												<option value="<%=dept.getNom() %>" selected><%=dept.getNom() %></option>
												<%
														}
														else
														{
												%>
												<option value="<%=dept.getNom() %>"><%=dept.getNom() %></option>
												<%
														}
													}
                                            	}
                                            	else 
                                            	{ 
                                            	%>
												<option>Test</option>
												<%	
                                            		}
												%>
										</select> <%
                                            	if(collab.getDepartement() != null)
                                            	{
		                                            %> <span
													class="left_add_collab">Nom</span><span class="right"></span><input
													required value="<%=collab.getIntitulePoste() %>" type="text"
													class="form-controle-collab" name="nomDept"> <%
                                            	}
                                            	else
                                            	{
		                                            %> <span
													class="left_add_collab">Nom</span><span class="right"></span><input
													required value="" type="text" class="form-controle-collab"
													name="nomDept"> <%		
                                            	}
                                            %></li>
									</ul>
								</div>
							</div>
						</div>

						<!--  -->
						<div class="card_edit">
							<div class="card-header" role="tab" id="headingTree">
								<h5 class="mb-0">
									<a class="collapsed" data-toggle="collapse"
										href="#collapseTree" aria-expanded="false"
										aria-controls="collapseTree"> Coordonnées bancaire </a>
								</h5>
							</div>
							<div id="collapseTree" class="collapse" role="tabpanel"
								aria-labelledby="headingTree" data-parent="#accordion">
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><span class="left_add_collab">IBAN</span><span
											class="right"></span><input type="text"
											class="form-controle-collab" name="iban"
											value="<%=collab.getIban() %>"> <span
											class="left_add_collab">BIC</span><span class="right"></span><input
											type="text" class="form-controle-collab" name="bic"
											value="<%=collab.getBic() %>"></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<button type="submit" onclick="valider()"
								class="btn btn-primary btn_add_banque" id="myBtn">Sauvegarder</button>
						</div>
					</div>
				</form>
			</div>


		</div>
	</div>
	<!-- /.container -->
</body>

</html>