/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Clesse représentant les actions composées 
 * Classe parente : Action
 * Attributs : mapPanier(Map), quantité(int), prix(double), allActionsComposees(list d'actions composées)
 * @author Zhuo
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;
    private int quantite;
    private double prix;
    
    private static final List<ActionComposee> allActionsComposees = new ArrayList<>();

    /**
     * Constructeur d'une ActionComposee
     * @param libelle 
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
        allActionsComposees.add(this);
    }

    /**
     * Fonction pour ajouter une action simple à une action composée
     * @param as
     * @param pourcentage 
     */
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    
    /**
     * Fonction pour récuperer la quantité d'actions composées 
     * @return 
     */
    public int getQuantite() {
            return quantite;
    }

    /**
     * Fonction pour mettre à jour le nombre d'actions composées
     * @param quantite 
     */
    public void setQuantite(int quantite) {
            this.quantite = quantite;
    }

    /**
     * Fonction pour récupérer le prix d'une action composée
     * @return 
     */
    public double getPrix() {
            return prix;
    }

    /**
     * Fonction pour mettre à jour le prix d'une action composée
     * @param prix 
     */
    public void setPrix(double prix) {
            this.prix = prix;
    }
    
    /**
    *
    * function pour connaitre toutes les actions composées disponibles
    * @return une list de toutes Les Actions Composees
    */
    public static List<ActionComposee> getAllActionsComposees() {
        return allActionsComposees;
    }

    @Override
    public float valeur(Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

}
