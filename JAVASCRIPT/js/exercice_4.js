/***********************************************************************************************************
**************************************Exercice 4 - Total d'une commande*************************************
***********************************************************************************************************/

var bouton4= document.getElementById("Id_btn4");
bouton4.addEventListener("click", clickbtn4);

function clickbtn4() {

    alert("Ce programme affiche le prix total d'une commande\n----------");

    //Déclaration des variables
    var prixUnitaire = 0;
    var quantiteCommande = 0;
    var prixTotal = 0;
    var remiseCommande = 0;
    var prixTotalRemise = 0;
    var fraisDePort = 0;
    var prixTotalCommande = 0;

    //PU
    prixUnitaire = prompt("Saisie du prix unitaire :");
    while (isNaN(prixUnitaire)) {
        alert("Erreur !\nVeuillez recommencer.");
        saisiePrenoms = prompt("Saisie du prix unitaire :");
    }

    //QTECOM
    quantiteCommande = prompt("Saisie de la quantité :");
    while (isNaN(quantiteCommande) || quantiteCommande != parseInt(quantiteCommande) || quantiteCommande == 0) {
        alert("La quantité doit être un entier supérieur à 0 !\nVeuillez recommencer.");
        nombreSaisi = prompt("Saisie de la quantité :");
    }

    //TOT
    prixTotal = prixUnitaire*quantiteCommande;

    //REM
    if (prixTotal < 100){
        remiseCommande = 0;
    } else if (prixTotal >= 100 && prixTotal <= 200) {
        remiseCommande = prixTotal*(5/100);
    } else {
        remiseCommande = prixTotal*(10/100);
    }

    //Total remisé
    prixTotalRemise = prixTotal - remiseCommande;

    //PORT
    if (prixTotalRemise > 500) { 
        fraisDePort = 0;
    } else {
        fraisDePort = (prixTotalRemise*2/100);
        if (fraisDePort < 6) {
            fraisDePort = 6;
        } else {
            fraisDePort = fraisDePort;
        }
    }

    //PAP
    prixTotalCommande = prixTotalRemise + fraisDePort;

    //arrondi des données à 2 chiffres après la virgule
    prixTotalCommande = prixTotalCommande.toFixed(2);
    remiseCommande = remiseCommande.toFixed(2);
    fraisDePort = fraisDePort.toFixed(2);

    //Affichage du prix à payer
    alert("Détail de votre commande : " + "\n.........." +
          "\nPrix unitaire de votre produit = " + prixUnitaire + " €" + "\nQuantité = " + quantiteCommande +
          "\nRemise = " + remiseCommande + " € " + "\nFrais de port = " + fraisDePort + " €" + "\n.........." +
          "\n\nLe prix total de votre commande est : " + prixTotalCommande + " €" + "\n..........");
}