$(document).ready(function() {
    $("#myBtn").click(function(e) {
        var inst = $("#addForm").data('bootstrapValidator');
        inst.validate()
        if (inst.isValid()) {
            e.preventDefault();
            //Passage au localStorage pour l'enregistrement local            
            var saisie_nom 		= localStorage.getItem('nom');
            var saisie_prenom 	= localStorage.getItem('prenom');
            var saisie_dtn 		= localStorage.getItem('date_naissance');
            var saisie_adresse 	= localStorage.getItem('adresse');
            var saisie_secu 	= localStorage.getItem('secu');

            $('#nomModal').attr('value', saisie_nom);
            $('#prenomModal').attr('value', saisie_prenom);
            $('#dtnModal').attr('value', saisie_dtn);
            $('#adrModal').attr('value', saisie_adresse);
            $('#secuModal').attr('value', saisie_secu);
            

            $("#myModal").modal('show');
        } else {
            $("#myModal").modal('hide');
        }
    });

    $('#addForm').bootstrapValidator({
            fields: {
                nom: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Le nom est obligatoire'
                        }
                    }
                },
                prenom: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Le prénom est obligatoire'
                        }
                    }
                },
                adresse: {
                    validators: {
                        notEmpty: {
                            message: 'L\'adresse est obligatoire'
                        }
                    }
                },
                date_naissance: {
                    validators: {
                        notEmpty: {
                            message: 'La date de naissance est obligatoire'
                        }
                    }
                },
                secu: {
                    validators: {
                        integer: {
                            min: 15,
                            message: 'Il vous faut mettre les 15 chiffres de votre carte vital',
                        },
                        notEmpty: {
                            message: 'Le numéro de sécurité social est obligatoire'
                        }
                    }
                }
            }
        })
        /*
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({
                    opacity: "show"
                }, "slow") // Do something ...
            $('#addForm').data('bootstrapValidator').resetForm();
            // Prevent form submission
            e.preventDefault();
            // Get the form instance
            var $form = $(e.target);
            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');
        });
        */
});