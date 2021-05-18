package org.openjfx.model;

public class Customers {
    // déclaration des variables
    private  String first_name;
    private  String last_name;
    private  String city;

    /**
     * constructeur par défaut
     */
    public Customers() {
    }

    /**
     * constructeur des données du client avec les paramètres ci-dessous
     * @param first_name : prénom du client
     * @param last_name : nom du client
     * @param city : ville du client
     */
    public Customers(String first_name, String last_name, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
    }

    // créaction des accesseurs (getters) et mutateurs (setters)

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}