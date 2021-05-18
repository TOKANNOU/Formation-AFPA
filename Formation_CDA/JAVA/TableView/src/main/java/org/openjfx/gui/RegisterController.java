package org.openjfx.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.model.Customers;

public class RegisterController {
    // déclaration des variables
    public TableView<Customers> customers_list;
    public TableColumn<Customers, String> col_first_name;
    public TableColumn<Customers, String> col_last_name;
    public TableColumn<Customers, String> col_city;
    public TextField txt_first_name, txt_last_name, txt_city, txt_error;
    public Button btn_save;
    public Button btn_cancel;
    public Button btn_delete;

    // attribut qui permet de stocker la liste des clients pour le remplissage du TableView
    ObservableList<Customers> list = FXCollections.observableArrayList();

    /**
     * initialisation du model "Customers" à l'ouverture de l'application
     */
    @FXML
    public void initialize() {
        // initialisation du modèle avec les données des clients suivants
        list.addAll(new Customers("Josh", "Homme", "Joshua Tree"),
                    new Customers("Dave", "Grohl", "Warren"),
                    new Customers("Krist", "Novoselic", "Compton"),
                    new Customers("Robert", "Trujillo", "Santa Monica")
        );

        // on rend le TableView non-éditable
        // customers_list.setEditable(false);

        // jonction des colonnes du TableView avec les données correspondantes
        col_first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        col_city.setCellValueFactory(new PropertyValueFactory<>("city"));

        // indication au TableView du modèle qu'il faut observer pour trouver les données
        customers_list.setItems(list);
    }

    /**
     * méthode de sauvegarde des nouvelles données
     * @param actionEvent : évènement enregistrer
     */
    public void save(ActionEvent actionEvent) {
        // masquage du message d'erreur
        txt_error.setVisible(false);
        // si les zones de texte contiennent des données
        if (!txt_first_name.getText().equals("") && !txt_last_name.getText().equals("") && !txt_city.getText().equals("")) {
            // si le format des données respectent les régex (formats autorisés)
            if (txt_first_name.getText().matches("^[A-Za-z]{2,15}$") &&
                txt_last_name.getText().matches("^[A-Za-z]{2,15}$") &&
                txt_city.getText().matches("^[A-Za-z]{2,15}$")) {

                // récupération et stockage des contenus des labels
                list.add(new Customers(txt_first_name.getText(), txt_last_name.getText(), txt_city.getText()));
            } else {
                // message d'erreur
                txt_error.setText("Format(s) incorrect(s) !");
                // affichage du message d'erreur
                txt_error.setVisible(true);
            }
        } else {
            // message d'erreur
            txt_error.setText("Veuillez renseigner tous les champs !");
            // affichage du message d'erreur
            txt_error.setVisible(true);
        }
    }

    /**
     * méthode pour annuler la saisie des nouvelles données
     * @param actionEvent : évènement annuler
     */
    public void cancel(ActionEvent actionEvent) {
        // masquage du message d'erreur
        txt_error.setVisible(false);
        // suppression des contenus des labels
        txt_first_name.clear();
        txt_last_name.clear();
        txt_city.clear();
    }

    /**
     * méthode pour supprimer les données d'un client
     * @param actionEvent : évènement supprimer
     */
    public void delete(ActionEvent actionEvent) {
        // masquage du message d'erreur
        txt_error.setVisible(false);
        // récupération de la ligne sélectionnée
        Customers line = customers_list.getSelectionModel().getSelectedItem();
        // si la ligne est vide (c'est-à-dire non sélectionnée)
        if (line == null) {
            // message d'erreur
            txt_error.setText("Veuillez sélectionner un client !");
            // affichage du message d'erreur
            txt_error.setVisible(true);
        } else {
            // suppression de la ligne en fonction de son index
            list.remove(line);
        }
    }
}
