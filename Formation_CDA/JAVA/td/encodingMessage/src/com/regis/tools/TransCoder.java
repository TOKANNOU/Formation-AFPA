package com.regis.tools;

import org.germain.tool.ManaBox;
import java.util.HashMap;
import java.util.Map;

public class TransCoder {
    // déclaration des attributs
    private String keyCrypted; // message crypté
    private final Map<Character, String> encode = new HashMap<Character, String>(); // Clef: Character | Valeur: String
    private final Map<String, Character> decode = new HashMap<String, Character>(); // Clef: String | Valeur: Character

    /**
     * constructeur qui prend en paramètre le message à transcoder
     */
    public TransCoder(String keyCrypted) {
        // décryptage de la clé
        String keyDecrypted = ManaBox.decrypt(keyCrypted);

        // initiation de chaque colonne des couples de lettres
        char firstColumn = 'A';
        char secondColumn = 'A';

        // pour chaque lettre de la clé qui a été au préalable insérée dans un tableau
        for (char letter : keyDecrypted.toCharArray()) {
            // encodage du message (insertion des associations (clef, valeur) dans la map "encode")
            this.encode.put(letter, String.valueOf(firstColumn) + String.valueOf(secondColumn));
            // décodage du message (insertion des associations (clef, valeur) dans la map "decode")
            this.decode.put(Character.toString(firstColumn) + Character.toString(secondColumn), letter);

            // affichage des couples de lettres
            // si la seconde colonne du couple de valeurs est égale à "Z"
            if (secondColumn == 'Z') {
                firstColumn++; // Passage de la première colonne à la lettre suivante
                secondColumn = 'A'; // réinitialisation de l'affichage de la seconde colonne à "A"
            } else {
                // sinon affichage des lettres de A à Z
                secondColumn++;
            }
        }
        // System.out.println(this.encode);
        // System.out.println(this.decode);
    }

    /**
     * méthode qui prend en paramètre un message décodé et qui renvoie une string encodée
     * @return msg
     */
    public String encode(String msg) {
        // initialisation du message à encoder
        StringBuilder encodedMessage = new StringBuilder();
        // pour chauqe lettre du message qui a été au préalable insérée dans un tableau
        for (char letter : msg.toCharArray()) {
            // on récupère la valeur associée à la clef de chaque lettre du mappage
            encodedMessage.append(this.encode.get(letter));
        }
        // System.out.println(encodedMessage);
        return encodedMessage.toString(); // renvoi du message encodé
    }

    /**
     * méthode qui prend en paramètre une string encodé et qui renvoie un message décodé
     * @return msg
     */
    public String decode(String msg) {
        // initialisation du message à décoder
        StringBuilder decodedMessage = new StringBuilder();
        // sélection de 2 caractères du message à chaque tour de boucle
        for (int i = 0; i < msg.length(); i+=2) {
            // récupération de la valeur associée à la clef de chaque lettre du mappage
            decodedMessage.append(this.decode.get(msg.substring(i, i + 2)));
        }
        // System.out.println(decodedMessage);
        return decodedMessage.toString(); // renvoi du message décodé
    }

    /**
     * méthode qui donne accès au message encodé
     * @return encode
     */
    public Map<Character, String> getEncode() {
        return encode;
    }

    /**
     * méthode qui donne accès au message décodé
     * @return decode
     */
    public Map<String, Character> getDecode() {
        return decode;
    }
}
