package org.openjfx.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalculatorController {

    // déclaration des variables
    double first_number;    // premier nombre
    String operator = "";   // initialisation de l'opérateur
    double second_number;   // deuxième nombre

    public TextField text_display; // première zone de texte pour l'affichage des opérations
    public TextField text_result;  // deuxième zone de texte pour le résultat des opérations

    DecimalFormat df = new DecimalFormat(); // instanciation d'un format décimal

    // méthode de contrôle des boutons pour l'affichage des chiffres dans la deuxième zone de texte
    public void number(ActionEvent click) {
        // récupération des contenus des boutons (nombres) suite à leur clic
        String button_text = ((Button)click.getSource()).getText();
        // ajout des contenus des boutons au contenu existant dans la deuxième zone de texte
        text_result.setText(text_result.getText() + button_text);
    }

    // méthode d'affichage des opérations
    public void operator(ActionEvent click) {
        // passage de l'affichage des nombres décimaux en langue anglaise ("#.##...")
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        // récupération des contenus des boutons (opérateurs) suite à leur clic
        String operator_button = ((Button)click.getSource()).getText();
        // si l'opérateur est différent du bouton d'égalité
        if (!operator_button.equals("=")) {
            // si un opérateur est sélectionné
            if (!operator.equals("")) {
                return; // on retourne rien
            }
            // récupération et conversion en "Double" du premier nombre entré dans la deuxième zone de texte
            first_number = Double.parseDouble(text_result.getText());
            // sinon récupération de l'opérateur qui a été sélectionné
            operator = operator_button;
            // affichage du contenu de la deuxième zone de texte
            text_result.setText("");
            // affichage du contenu de la 2ème zone de texte dans la première zone de texte
            text_display.setText(df.format(first_number) + operator_button);
        // sinon si l'opérateur est égal celui de l'égalité "="
        } else {
            // s'il n'y pas d'opérateur
            if (operator.equals("")) {
                return; // on retourne rien
            }
            // sinon récupération et conversion en "Double" du second nombre entré dans la deuxième zone de texte
            second_number = Double.parseDouble(text_result.getText());
            // si le second nombre est négatif
            if (text_result.getText().matches("^[-]([0-9]*[.])?[0-9]+$")) {
                // affichage du contenu de la 1ère zone de texte + l'ajout du contenu de la 2ème zone de texte
                // nombres entre parenthèses
                text_display.setText(text_display.getText() + "(" + df.format(second_number) + ")");
            } else {
                // sinon affichage sans les parenthèses
                text_display.setText(text_display.getText() + df.format(second_number));
            }

            // appel de la méthode de calcul des opérations
            calculate(first_number, second_number, operator);
            // réinitialisation de l'opérateur pour un autre calcul
            operator = "";
        }
    }

    // méthode de calcul des opérations
    public void calculate (double n1, double n2, String op) {

        // configuration du format double à minimum aucun chiffre après la virgule et maximum 10
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(5);

        // pour chaque cas d'opération
        switch (op) {
            // addition
            case "+" -> text_result.setText(df.format(n1 + n2) + "");

            // soustraction
            case "-" -> text_result.setText(df.format(n1 - n2) + "");

            // multiplication
            case "x" -> text_result.setText(df.format(n1 * n2) + "");

            // division (le code d'encodage du caractère spécial «÷» est \u00f7)
            case "\u00f7" -> {
                // si le premier nombre est égal à 0
                if (n1 == 0) {
                    // le résultat vaudra "0"
                    text_result.setText("0");
                    break;
                }
                // si le second nombre est égal à 0
                if (n2 == 0) {
                    // affichage d'erreur
                    text_result.setText("Erreur");
                    break;
                }
                // sinon affichage du résultat de la division
                text_result.setText(df.format(n1 / n2) + "");
            }
        }
    }

    // méthode de suppression du contenu de la zone de texte
    public void clear_button(ActionEvent actionEvent) {
        text_display.clear();
        text_result.clear();
    }

    public void delete_digit(ActionEvent click) {
        // récupération du contenu de la première zone de texte
        String numbers = text_result.getText();
        // suppression du contenu de la 2ème zone de texte
        text_result.setText("");
        // pour chaque chiffre du nombre jusqu'au dernier
        for (int i = 0; i < numbers.length() - 1; i++) {
            // affichage du nombre sans le dernier chiffre
            text_result.setText(text_result.getText() + numbers.charAt(i));
        }
    }

    public void plus_minus_button(ActionEvent click) {
        // passage de l'affichage des nombres décimaux en langue anglaise ("#.##...")
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        // récupération du contenu de text_result
        double numbers = Double.parseDouble(text_result.getText());
        // multiplication par (-1) du nombre à chaque clic du bouton
        numbers *=-1;
        // affichage du résultat
        text_result.setText(String.valueOf(df.format(numbers)));
    }
}
