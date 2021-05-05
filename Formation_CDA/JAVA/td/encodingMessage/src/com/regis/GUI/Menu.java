package com.regis.GUI;

import com.regis.model.Message;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    public void startMenu() {
        // instanciation de la class Scanner pour lire les saisies des utilisateurs
        Scanner scan = new Scanner(System.in);

        // déclaration des variables
        String choice;                                      // variable relative au choix de l'utilisateur
        String home = System.getProperty("user.dir");       // chemin menant au répertoire projet
        Path keyPath = Paths.get(home,"keyTest.txt"); // chemin du fichier contenant la clé cryptée
        String msgClearFile;                                // nom du fichier contenant le message clair
        Path msgClearPath;                                  // chemin du fichier contenant le message clair
        String encodedFile;                                 // nom du fichier contenant le message encodé
        Path msgEncodedPath;                                // chemin du fichier contenant le message encodé
        Message message;                                    // constructeur de message

        // affichage du menu
        System.out.println("""

                ╔══════════════════════════════════════╗
                ║  Système d'encodage et de décodage   ║
                ║             de messages              ║
                ╠══════════════════════════════════════╣
                ║       1) Décoder un message          ║
                ║       2) Encode un message           ║
                ║       3) Quitter                     ║
                ╚══════════════════════════════════════╝""");

        // faire
        do {
            // exécution des opérations selon le choix de l'utilisateur
            System.out.println("\nPour choisir une opéraration, veuillez entrer: 1, 2 ou 3:");
            // récupération du choix de l'utilisateur
            choice = scan.nextLine();

            // si c'est le choix n°1
            if (choice.equals("1")) {
                System.out.println("\nEntrez le nom du fichier à décoder (sans extension)");
                // récupération du nom du fichier
                encodedFile = scan.nextLine();
                // récupération du chemin menant au fichier contenant le message encodé
                msgEncodedPath = Paths.get(home,encodedFile + ".txt");
                // récupération du chemin menant au fichier qui contiendra le message décodé
                msgClearPath = Paths.get(home,"decoded.txt");
                // instanciation et exécution de la class "Message" lorsque le message est encodé
                message = new Message(true, msgClearPath, msgEncodedPath, keyPath);
                // exécution de la méthode readNwrite() pour décoder le message
                message.readNwrite();

            // sinon si c'est le choix n°2
            } else if (choice.equals("2")) {
                System.out.println("\nEntrez le nom du fichier à encoder (sans extension)");
                // récupération du nom du fichier
                msgClearFile = scan.nextLine();
                // récupération du chemin menant au fichier contenant le message clair (à encoder)
                msgClearPath = Paths.get(home,msgClearFile + ".txt");
                // récupération du chemin menant au fichier qui contiendra le message encodé
                msgEncodedPath = Paths.get(home,"encoded.txt");
                // instanciation et exécution de la class "Message" lorsque le message est encodé
                message = new Message(false, msgClearPath, msgEncodedPath, keyPath);
                // exécution de la méthode readNwrite() pour décoder le message
                message.readNwrite();

            // sinon fermer le scanner
            } else if (choice.equals("3")){
                System.out.println("\nVous avez choisi de quitter l'application ! \nÀ bientôt :)");
                scan.close();
                break;
            } else {
                System.out.println("\nErreur ! \nVeuillez choisir parmi les options proposées");
            }

        // jusqu'à ce que l'utilisateur entre le choix n°3
        } while (true);
    }
}
