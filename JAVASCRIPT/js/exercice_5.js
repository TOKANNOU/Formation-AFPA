/**********************************************************************************************************************************************
***********************************Exercice 5 - Vérification d'un formulaire*******************************************************************
**********************************************************************************************************************************************/

/******************************************Déclaration des variables**************************************************************************/

//Traitement informatique
var traitementInformatique = document.getElementById("validation");
var traitementManquant = document.getElementById("traitementManquant");

// Question
var messageDemande = document.getElementById("message");
var messageManquant = document.getElementById("messageManquant");
var messageValide = /^[A-Za-z]{5,40}$/;

//Sujet demande
var objetDemande = document.getElementById("objet_demande");
var objetManquant = document.getElementById("objetManquant");

//Email
var email = document.getElementById("email");
var emailManquante = document.getElementById("emailManquante");
var emailValide = /^[a-z0-9.-]+@[a-z0-9.-]{2,}.[a-z]{2,4}$/;

//Ville
var ville = document.getElementById("ville");
var villeManquante = document.getElementById("villeManquante");
var villeValide = /^[A-Za-z]{2,15}$/;

//Adresse
var adresse = document.getElementById("adresse");
var adresseManquante = document.getElementById("adresseManquante");
var adresseValide = /^[A-Za-z]{8,30}$/;

//Code postal
var codePostal = document.getElementById("code_postal");
var codePostalManquant = document.getElementById("codePostalManquant");
var codePostalValide = /^[0-9]{5}$/;

//Date de naissance
var dateNaissance = document.getElementById("date_naissance");
var dateNaissanceManquante = document.getElementById("dateNaissanceManquante");

//Sexe
var sexe = document.getElementById("sexe_feminin");
var sexeManquant = document.getElementById("sexeManquant");

//Prénom
var prenom = document.getElementById("prenom");
var prenomManquant = document.getElementById("prenomManquant");
var prenomValide = /^[A-Za-z]{2,15}$/;

//Nom
var nom = document.getElementById("nom");
var nomManquant = document.getElementById("nomManquant");
var nomValide = /^[A-Za-z]{2,15}$/;


//Info début formulaire
var info = document.getElementById("infoFormulaire");
document.getElementById("boutonEnvoyer").onclick = function validationDesDonnees() {
    info.innerHTML = "<span style='font-size:15px; color:#CC3300'> ***Appuyez sur la touche <b>*Entrée*</b> pour valider vos données***</span>";
};


/****************************************Gestionnaire d'évènement******************************************************************************/

var validationFormulaire = document.getElementById("boutonEnvoyer");

validationFormulaire.addEventListener("click", validation) ;
function validation(Event) {

    //Traitement informatique
    if (traitementInformatique.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        traitementManquant.textContent = "Veuillez accepter le traitement numérique de vos données svp !";
        traitementManquant.style.color = "#FF0000";
        traitementInformatique.style.border = "2px solid #FF0000";
        traitementInformatique.focus();

    } else {
        traitementInformatique.style.border = "2px solid #339900";
        traitementManquant.textContent = " ";
        traitementInformatique.blur();
    }

    // Question
    if (messageDemande.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        messageManquant.textContent = "Veuillez saisir votre message !";
        messageManquant.style.color = "#FF0000";
        messageDemande.style.border = "2px solid #FF0000";
        messageDemande.focus();

    } else if (messageValide.test(messageDemande.value) == false) {
        Event.preventDefault();
        messageManquant.textContent = "Ce champ doit comporter entre 5 et 40 caractères.";
        messageManquant.style.color = "#FF9966";
        messageDemande.style.border = "2px solid #FF9966";
        messageDemande.focus();

    } else {
        messageDemande.style.border = "2px solid #339900";
        messageManquant.textContent = " ";
        messageDemande.blur();
    }

    //Sujet demande
    if (objetDemande.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        objetManquant.textContent = "Veuillez renseigner l'objet de votre demande svp !";
        objetManquant.style.color = "#FF0000";
        objetDemande.style.border = "2px solid #FF0000";
        objetDemande.focus();

    } else {
        objetDemande.style.border = "2px solid #339900";
        objetManquant.textContent = " ";
        objetDemande.blur();
    }

    //Email
    if (email.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        emailManquante.textContent = "Veuillez saisir votre adresse mail svp !";
        emailManquante.style.color = "#FF0000";
        email.style.border = "2px solid #FF0000";
        email.focus();

    } else if (emailValide.test(email.value) == false) {
        Event.preventDefault();
        emailManquante.textContent = "Veuillez respecter le format prédéfini !";
        emailManquante.style.color = "#FF9966";
        email.style.border = "2px solid #FF9966";
        email.focus();

    } else {
        email.style.border = "2px solid #339900";
        emailManquante.textContent = " ";
        email.blur();
    }

    //Ville
    if (ville.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        villeManquante.textContent = "Veuillez renseigner votre ville !";
        villeManquante.style.color = "#FF0000";
        ville.style.border = "2px solid #FF0000";
        ville.focus();

    } else if (villeValide.test(ville.value) == false) {
        Event.preventDefault();
        villeManquante.textContent = "Ce champ doit comporter entre 2 et 15 caractères.";
        villeManquante.style.color = "#FF9966";
        ville.style.border = "2px solid #FF9966";
        ville.focus();

    } else {
        ville.style.border = "2px solid #339900";
        villeManquante.textContent = " ";
        ville.blur();
    }

    //Adresse
    if (adresse.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        adresseManquante.textContent = "Veuillez renseigner votre adresse postale svp !";
        adresseManquante.style.color = "#FF0000";
        adresse.style.border = "2px solid #FF0000";
        adresse.focus();

    } else if (adresseValide.test(adresse.value) == false) {
        Event.preventDefault();
        adresseManquante.textContent = "Ce champ doit comporter entre 8 et 30 caractères.";
        adresseManquante.style.color = "#FF9966";
        adresse.style.border = "2px solid #FF9966";
        adresse.focus();

    } else {
        adresse.style.border = "2px solid #339900";
        adresseManquante.textContent = " ";
        adresse.blur();
    }

    //Code postal
    if (codePostal.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        codePostalManquant.textContent = "Veuillez entrer votre code postal !";
        codePostalManquant.style.color = "#FF0000";
        codePostal.style.border = "2px solid #FF0000";
        codePostal.focus();

    } else if (codePostalValide.test(codePostal.value) == false) {
        Event.preventDefault();
        codePostalManquant.textContent = "Ce champ doit respecter une longueur imposée à 5 chiffres.";
        codePostalManquant.style.color = "#FF9966";
        codePostal.style.border = "2px solid #FF9966";
        codePostal.focus();

    } else {
        codePostal.style.border = "2px solid #339900";
        codePostalManquant.textContent = " ";
        codePostal.blur();
    }

    //Date de naissance
    if (dateNaissance.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        dateNaissanceManquante.textContent = "Veuillez entrer votre date de naissance svp !";
        dateNaissanceManquante.style.color = "#FF0000";
        dateNaissance.style.border = "2px solid #FF0000";
        dateNaissance.focus();

    } else {
        dateNaissance.style.border = "2px solid #339900";
        dateNaissanceManquante.textContent = " ";
        dateNaissance.blur();
    }

    //Sexe
    if (sexe.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        sexeManquant.textContent = "Veuillez renseigner votre genre !";
        sexeManquant.style.color = "#FF0000";
        sexe.focus();

    } else {
        sexeManquant.textContent = " ";
        sexe.blur();
    }

    //Prénom
    if (prenom.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        prenomManquant.textContent = "Veuillez entrer votre prénom !";
        prenomManquant.style.color = "#FF0000";
        prenom.style.border = "2px solid #FF0000";
        prenom.focus();

    } else if (prenomValide.test(prenom.value) == false) {
        Event.preventDefault();
        prenomManquant.textContent = "Ce champ doit comporter entre 2 et 15 caractères.";
        prenomManquant.style.color = "#FF9966";
        prenom.style.border = "2px solid #FF9966";
        prenom.focus();

    } else {
        prenom.style.border = "2px solid #339900";
        prenomManquant.textContent = " ";
        prenom.blur();
    }
    
    
    //Nom
    if (nom.validity.valueMissing) {
        Event.preventDefault();
        Event.stopPropagation();
        nom.focus();
        nomManquant.textContent = "Veuillez entrer votre nom !";
        nomManquant.style.color = "#FF0000";
        nom.style.border = "2px solid #FF0000";
        
    } else if (nomValide.test(nom.value) == false) {
        Event.preventDefault();
        nomManquant.textContent = "Ce champ doit comporter entre 2 et 15 caractères.";
        nomManquant.style.color = "#FF9966";
        nom.style.border = "2px solid #FF9966";
        nom.focus();
        
    } else {
        nom.style.border = "2px solid #339900";
        nomManquant.textContent = " ";
        nom.blur();
    }
}


/***********************************************Annulation des saisies*************************************************************************/

document.getElementById("boutonAnnuler").onclick = function annulationDesSaisies() {

    dateNaissance = document.getElementById("date_naissance");
    
    info.innerHTML = "<span style='font-size:15px; color:#CC3300'>Vos données ne sont pas enregistrées !!! <br> ***Veuillez renseigner le formulaire***</span>";
    
    nomManquant.textContent = "";
    prenomManquant.textContent = "";
    sexeManquant.textContent = "";
    dateNaissanceManquante.textContent = "";
    codePostalManquant.textContent = "";
    adresseManquante.textContent = "";
    villeManquante.textContent = "";
    emailManquante.textContent = "";
    objetManquant.textContent = "";
    messageManquant.textContent = "";
    traitementManquant.textContent = "";
    nom.style.border = "";
    prenom.style.border = "";
    dateNaissance.style.border = "";
    nom.style.border = "";
    dateNaissance.style.border = "";
    codePostal.style.border = "";
    adresse.style.border = "";
    ville.style.border = "";
    email.style.border = "";
    objetDemande.style.border = "";
    messageDemande.style.border = "";
    traitementInformatique.style.border = "";
};
