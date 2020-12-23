/******************************************************************************************************************
*************************************Exercice 2 - Table de multiplication******************************************
******************************************************************************************************************/

var bouton2= document.getElementById("Id_btn2");
bouton2.addEventListener("click", clickbtn2);

function clickbtn2() {

    alert("Ce programme affiche la table de multiplication de nombres entiers supérieurs à 0\n----------")

    //obtention d'un nombre entier
    var nombreSaisi = prompt("Veuillez entrer le numéro de la table");
    while (isNaN(nombreSaisi) || nombreSaisi != parseInt(nombreSaisi) || nombreSaisi == 0) {
        alert("La valeur est incorrecte !\nVeuillez recommencer.");
        nombreSaisi = prompt("Veuillez saisir un nombre entier supérieur à 0");
    }
    
    //table de multiplication
    function tableMultiplication(nombreChoisi) {
        var resultat = [];
        for(var i = 1; i <= 10; i++) {  
            resultat[i-1] = nombreChoisi + " x " + i + " = " + (nombreChoisi * i);
        }
        return alert("Table de " + nombreChoisi + "\n---------------\n" + resultat.join("\n") + "\n---------------");
    }

    tableMultiplication(nombreSaisi);
}