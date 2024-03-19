/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author somebody
 */
public class ActionSimple extends Action {

    /** attribut lien*/
    private Map<Jour, Cours> mapCours;
    
    private int quantite;
    private double prix;
    
    /**l'attribut pour stocker le pourcentage maximal d'actions 
     * disponibles à la vente
    */
    private double pourcentageMaxVente;

    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
        /* Par défaut, 100% des actions sont disponibles à la vente**/
        this.pourcentageMaxVente = 100;
    }

    /**
     * Enregistrement de la valeur d'une action à une date donnée
     * 
     * @param j une date donnée
     * @param v valeur
     */
    public void enrgCours(Jour j, float v) {
        if (this.mapCours.containsKey(j) == false) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }
    
     public int getQuantite() {
            return quantite;
    }

    public void setQuantite(int quantite) {
            this.quantite = quantite;
    }

    public double getPrix() {
            return prix;
    }

    public void setPrix(double prix) {
            this.prix = prix;
    }
    
    /**
    * Retourne le pourcentage maximal d'actions pouvant être vendues.
    * <p>
    * Ce pourcentage indique la limite supérieure des actions de la compagnie qui peuvent être mises en vente.
    * Par défaut, ce pourcentage est fixé à 100%, signifiant que toutes les actions peuvent être vendues.
    * </p>
    * 
    * @return le pourcentage maximal d'actions vendables.
    */
    public double getPourcentageMaxVente() {
        return pourcentageMaxVente;
    }
    
    /**
    * Définit le pourcentage maximal d'actions pouvant être vendues.
    * <p>
    * Cette méthode permet de limiter la quantité d'actions qui peuvent être vendues.
    * Si la valeur spécifiée n'est pas dans cet intervalle, une IllegalArgumentException est levée.
    * </p>
    * 
    * @param pourcentageMaxVente le pourcentage maximal de vente, entre 0 et 100.
    * @throws IllegalArgumentException si le pourcentage spécifié n'est pas entre 0 et 100.
    */
    public void setPourcentageMaxVente(double pourcentageMaxVente) {
        if (pourcentageMaxVente >= 0 && pourcentageMaxVente <= 100) {
            this.pourcentageMaxVente = pourcentageMaxVente;
        } else {
            throw new IllegalArgumentException("Le pourcentage doit être compris entre 0 et 100");
        }
    }
    
    public Map<Jour, Cours> getMapCours() {
            return mapCours;
    }

    public void setMapCours(Map<Jour, Cours> mapCours) {
            this.mapCours = mapCours;
    }

    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j) == true) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; 
        }
    }
}
