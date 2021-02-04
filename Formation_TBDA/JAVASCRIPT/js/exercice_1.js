/*************************************************************************************************************
**************************************Exercice 1 - Dénombrement d'âge*****************************************
*************************************************************************************************************/

var bouton1= document.getElementById("Id_btn1");
bouton1.addEventListener("click", clickbtn1);

function clickbtn1() {

    alert("Ce programme réalise le recensement d'âges\n----------" + 
          "\nIl s'arrête dès la saisie d'un centenaire\n----------");

    //initialisation des variables
    var agesPersonnes = 0;
    var tableauAge = [];
    var jeuneAge = [];
    var moyenAge = [];
    var vieuxAge = [];
    var compteurNombreAge = 0;
    var sauvegardeAge = 0;

    //vérification de la saisie des âges qui doivent être des nombres entiers
    function saisieAge() {
        agesPersonnes = prompt("Veuillez entrer l'âge n° " + (compteurNombreAge + 1));

        while (isNaN(agesPersonnes) || agesPersonnes != parseInt(agesPersonnes)) {
            alert("Vous n'avez pas saisi un âge correct !\nVeuillez recommencer.");
            agesPersonnes = prompt("Veuillez entrer l'âge n° " + (compteurNombreAge + 1));
        }
    }

    saisieAge();

    //sauvegarde des âges dans un tableau
    do {
        if (agesPersonnes == 0) {
            alert("Il faut un âge supérieur ou égal à 1 an !");
            saisieAge();
        } 
        else if (agesPersonnes > 99) {           
            tableauAge.push(agesPersonnes);  //prise en compte d'un âge centenaire
            break;
        } 
        else {
            tableauAge[sauvegardeAge] = agesPersonnes; 
            sauvegardeAge += 1;
            compteurNombreAge++;                     
            saisieAge();
        }
    } while (agesPersonnes != null);

    //accord des âges (singulier/pluriel) pour l'affichage des âges saisis
    var accordTableauAge = "";
    if (tableauAge.length > 1) {
        accordTableauAge = "âges";
    } else {
        accordTableauAge = "âge";
    }

    alert ("Vous avez saisi " + tableauAge.length + " " + accordTableauAge + " : " + tableauAge); //affichage de tous les âges saisis

    //calcul du nombre de jeunes, de moyens et de vieux
    for (var i = 0; i < tableauAge.length; i++) {
        if (tableauAge[i] < 20 ) {
            jeuneAge.push(tableauAge[i]);
        } 
        else if (tableauAge[i] >= 20 && tableauAge[i] <= 40) {
            moyenAge.push(tableauAge[i]);
        }
        else {
            vieuxAge.push(tableauAge[i]);
        }
    }

    //accord des âges pour l'affichage du recensement
    var accordAge = "";
    if (jeuneAge.length > 1 || moyenAge.length > 1 || vieuxAge.length > 1) {
        accordAge = "âges";
    } else {
        accordAge = "âge";
    }

    //affichage du recensement
    alert("On recense : " + "\n\n" + jeuneAge.length + " " + accordAge + " strictement inférieur à 20 ans : " + jeuneAge + 
          "\n.........." + "\n" + moyenAge.length + " " + accordAge + " compris entre 20 et 40 ans : " + moyenAge + 
          "\n.........." + "\n" + vieuxAge.length + " " + accordAge + " strictement supérieur à 40 ans : " + vieuxAge + 
          "\n..........");
}