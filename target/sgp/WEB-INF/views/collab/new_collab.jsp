<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Création de nouveau Collaborateur</title>

    <!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/fontawesome/4.1.0/css/font-awesome.min.css" />

    <!-- Bootstrap core CSS -->
    <link href="../../sgp/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../../sgp/styles.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" />
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>

    <script src="../../sgp/js/bootstrap.min.js"></script>

    <!-- javascript collab (modal + alert) -->
    <script src="../../sgp/js/js_collab.js"></script>

	<script>
         function enregistrer() //enregistrer les options, fonction appelée par le click sur le bouton
        {
        	 /* localStorage['matricule']		= document.getElementById('matricule').value; */
        	 localStorage['nom'] 			= document.getElementById('nom').value;
             localStorage['prenom'] 		= document.getElementById('prenom').value;
             localStorage['date_naissance'] = document.getElementById('date_naissance').value;
             localStorage['adresse'] 		= document.getElementById('adresse').value;
             localStorage['secu'] 			= document.getElementById('secu').value; 
        }
         
        function valider()
        {
        	document.forms[0].submit();
        }
    </script>

</head>

<body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="<%=request.getContextPath()+"/collaborateurs/lister"%>">Login</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Edit_Banque.html">Collaborateur <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="statistique.html">Statistique</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="activite.html">Activité</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- Partie Haut -->
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Nouveau Collaborateurs</h1>
                <form id="addForm" role="form" method="POST" action="<%=request.getContextPath()+"/collaborateurs/ajouter"%>" data-toggle="validator">
                    <br>

                    <fieldset>

                        <div class="form-group">
                            <div class="col-md-10 inputGroupContainer">
                                <div class="input-group">
                                    <span class="left_add_collab">Nom</span><span class="right"></span><input id="nom" name="nom"  placeholder="Nom" class="form-controle" type="text">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-10 inputGroupContainer">
                                <div class="input-group">
                                    <span class="left_add_collab">Prénom</span><span class="right"></span><input id="prenom" name="prenom" placeholder="Prénom" class="form-controle" type="text">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-10 inputGroupContainer">
                                <div class="input-group">
                                    <span class="left_add_collab">Adresse</span><span class="right"></span><textarea id="adresse" class="form-controle" name="adresse" placeholder="Adresse"></textarea>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-10 inputGroupContainer">
                                <div class="input-group">
                                    <span class="left_add_collab">Date de naissance</span><span class="right"></span><input id="date_naissance" name="date_naissance" placeholder="Date de naissance" class="form-controle" type="date">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-10 inputGroupContainer">
                                <div class="input-group">
                                    <span class="left_add_collab">Numéro de sécurité sociale</span><span class="right"></span><input id="secu" name="secu" placeholder="Numéro de sécurité sociale" class="form-controle" type="text">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4">
                                <button type="submit" class="btn btn-primary btn_add" id="myBtn" onclick="enregistrer()">Créer</button>
                            </div>
                        </div>

                    </fieldset>
                </form>


                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Création d'un Collaborateur</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                            </div>
                            <div class="modal-body">
                                Vous êtes sur le point de crée un nouveau Collaborateur :<br>
                                <span class="left_add_collab_modal">Nom</span><span class="right"></span><input id="nomModal" disabled="disabled" type="text" class="form-controle-collab-modal" name="nom">
                                <span class="left_add_collab_modal">Prénom</span><span class="right"></span><input id="prenomModal" disabled="disabled" type="text" class="form-controle-collab-modal" name="prenom">
                                <span class="left_add_collab_modal">Date de naissance</span><span class="right"></span><input id="dtnModal" disabled="disabled" type="text" class="form-controle-collab-modal" name="date_naissance">
                                <span class="left_add_collab_modal">Adresse</span><span class="right"></span><!-- <textarea id="adrModal" disabled="" class="form-controle-collab-modal" name="adrModal"></textarea> --><input id="adrModal" disabled="disabled" type="text" class="form-controle-collab-modal" name="adresse">
                                <span class="left_add_collab_modal">Numéro de sécurité sociale</span><span class="right"></span><input id="secuModal" disabled="disabled" type="text" class="form-controle-collab-modal" name="secu">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                <button type="button" onclick="valider()" class="btn btn-primary">Confirmer</button>
                            </div>
                        </div>
                    </div>
                </div>
				<!-- Modal -->

            </div>
        </div>
    </div>
    <!-- /.container -->
</body>

</html>