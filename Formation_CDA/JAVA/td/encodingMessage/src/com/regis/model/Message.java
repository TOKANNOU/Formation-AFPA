package com.regis.model;

import com.regis.tools.TransCoder;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Message {
    private final boolean encoded;      // vérifie si le message est encodé ou non
    private List<String> msgClear;      // liste de chaines contenant le véritable message à encoder
    private List<String> msgEncoded;    // liste de chaines contenant le message encodé
    private final Path msgClearPath;    // chemin du fichier contenant le véritable message
    private final Path msgEncodedPath;  // chemin du fichier contenant le message encodé
    private final Path keyPath;         // chemin du fichier contenant la clé
    private String key;                 // clé à décrypter
    private TransCoder transCoder;      // déclaration d'un transcodeur

    /**
     * constructeur de message qui prend en paramètre les éléments suivants :
     * @param encoded
     * @param msgClearPath
     * @param msgEncoddedPath
     * @param keyPath
     */
    public Message(boolean encoded, Path msgClearPath, Path msgEncoddedPath, Path keyPath) {
        this.encoded = encoded;
        this.msgClearPath = msgClearPath;
        this.msgEncodedPath = msgEncoddedPath;
        this.keyPath = keyPath;
    }


    /**
     * méthode qui vérifie si le message est codé ou non
     * elle peut aussi lire, coder ou décoder le message et l'écrire dans un fichier
     */
    public void readNwrite() {
        // si le fichier contenant la clé cryptée existe
        if (Files.exists(keyPath)) {
            try {
                // lecture de la clé
                this.key = Files.readString(keyPath);
                System.out.println("\nle fichier contenant la clé existe bien !");
            } catch (IOException e) {
                // sinon message d'erreur
                System.out.println(e.getMessage());
            }
            // sinon
        } else {
            try {
                // clé cryptée
                key = "Z/YsEClWF0UqFYP8eds3sNHbY+wHVf7fZUmzsC8L/WdV1egGct3p6Bnm4hyx9XwMjyoQHPIMRrJ8G5mNsf0qtA==";
                // enregistrement de la clé dans le fichier
                Files.writeString(keyPath, key);
                System.out.println("\nUne clé cryptée a été créée à: " + keyPath.toString());
            } catch (IOException e) {
                // sinon message d'erreur
                System.out.println(e.getMessage());
            }
        }
        // appel du transcoder pour décrypter la clé et créer le mappage d'encodage et de décodage
        this.transCoder = new TransCoder(key);

        // si le message n'est pas encodé (donc message de base)
        if (!encoded) {
            try {
                // lecture du message clair (non encodé)
                this.msgClear = Files.readAllLines(msgClearPath);
            } catch (IOException e) {
                // sinon capture et affichage du message d'erreur
                System.out.println("\nOpération impossible ! \nIl n'existe pas de fichier contenant de message à encoder\n");
            }

            /* codage du message clair */
            // pour chaque ligne du message clair
            for (String ligne : msgClear) {
                // encodage de chaque ligne
                String ligneEncoded = transCoder.encode(StringUtils.stripAccents(ligne));
                try {
                    // écriture de chaque ligne encodée dans le fichier correspondant
                    Files.writeString(msgEncodedPath, (ligneEncoded + System.lineSeparator()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    // sinon message d'erreur
                    System.out.println(e.getMessage());
                }
            }
            // affichage du chemin où se trouve le message encodé
            System.out.println("\nVotre message a été bien encodé. Il se trouve dans le répertoire suivant:\n" + msgEncodedPath.toString());

        // si le message est encodé
        } else {
            try {
                // lecture du contenu du fichier contenant le message encodé
                this.msgEncoded = Files.readAllLines(msgEncodedPath);
            } catch (IOException e) {
                // sinon capture et affichage du message d'erreur
                System.out.println("\nOpération impossible ! \nIl n'existe pas de fichier contenant de message à décoder\n");
            }

            /* décodage du message encodé */
            // pour chaque ligne du message encodé
            for(String ligne : msgEncoded){
                // décodage de chaque ligne
                String ligneDecoded = transCoder.decode(ligne);
                try {
                    // écriture de chaque ligne décodée dans le fichier correspondant
                    Files.writeString(msgClearPath, ligneDecoded + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    // sinon message d'erreur
                    System.out.println(e.getMessage());
                }
            }
            // affichage du chemin où se trouve le message décodé
            System.out.println("\nVotre message a été bien décodé. Il se trouve dans le répertoire suivant:\n" + msgClearPath.toString());
        }
    }
}
