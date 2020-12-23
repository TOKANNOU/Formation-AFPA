/*****************************************************************************************************************************************
****************************************Exercice 3 - Recherche d'un prénom****************************************************************
*****************************************************************************************************************************************/

/*************************************************1ère méthode***************************************************************************/

var bouton3= document.getElementById("Id_btn3");
bouton3.addEventListener("click", clickbtn3);

function clickbtn3() {

    alert("Ce programme effectue une recherche de prénom\n----------");

    var tab = ["Audrey", "Aurélien", "Flavien", "Jérémy", "Laurent", "Melik", "Nouara", "Salem", "Samuel", "Stéphane"];

    var saisiePrenoms = prompt("Veuillez choisir un prénom parmi : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "]");

    //La méthode "includes" vérifie si le prénom recherché fait partie du tableau
    if (tab.includes(saisiePrenoms)) {
        alert("\""+ saisiePrenoms + "\"" + " se trouve bien dans la liste : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
        tab.splice(tab.indexOf(saisiePrenoms),1);  //suppression du prénom trouvé
        tab.push(" ");
        alert("Voici les prénoms restants : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
    } else {
        alert("\"" +saisiePrenoms + "\"" + " ne fait pas partie de la liste : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
    }
}


/*************************************************2ème méthode***************************************************************************/

// var bouton3= document.getElementById("Id_btn3");
// bouton3.addEventListener("click", clickbtn3);

// function clickbtn3() {

//     alert("Ce programme effectue une recherche de prénom\n----------");

//     var tab = ["Audrey", "Aurélien", "Flavien", "Jérémy", "Laurent", "Melik", "Nouara", "Salem", "Samuel", "Stéphane"];

//     var saisiePrenoms = prompt("Veuillez choisir un prénom parmi : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "]");

//     for (var i = 0; i <= tab.length; i++) {
//         if (saisiePrenoms == tab[i]) {
//             alert("\""+ tab[i] + "\"" + " se trouve bien dans la liste : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
//             tab.splice(i, 1);                 //supression du prénom trouvé
//             tab.splice(tab.length, 0, " ");   //la méthode "splice" peut aussi ajouter un élément dans un tableau
//             alert("Voici les prénoms restants : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
//             break;
//         } else if (i == tab.length) {
//             alert("\"" +saisiePrenoms + "\"" + " ne fait pas partie de la liste : [" + "\"" + tab.join("\" " + "," + " \"") + "\"" + "];");
//         }
//     }
// }

