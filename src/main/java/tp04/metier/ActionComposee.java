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
 * Classe représentant les actions composées.
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
     * @param libelle le libellé de l'action composée
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
        allActionsComposees.add(this);
    }
    
   

    /**
     * Fonction pour ajouter une action simple à une action composée
     * @param as l'action simple à ajouter
     * @param pourcentage le pourcentage de l'action simple dans l'action composée
     */
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    
    /**
     * Fonction pour récupérer la quantité d'actions composées 
     * @return la quantité d'actions composées
     */
    public int getQuantite() {
            return quantite;
    }

    /**
     * Fonction pour mettre à jour le nombre d'actions composées
     * @param quantite la nouvelle quantité d'actions composées
     */
    public void setQuantite(int quantite) {
            this.quantite = quantite;
    }


    
    /**
     * Fonction pour récupérer le prix d'une action composée
     * @return le prix d'une action composée
     */
    public double getPrix() {
            return prix;
    }

    /**
     * Fonction pour mettre à jour le prix d'une action composée
     * @param prix le nouveau prix de l'action composée
     */
    public void setPrix(double prix) {
            this.prix = prix;
    }
    
    /**
    *
    * Fonction pour obtenir toutes les actions composées disponibles
    * @return une list de toutes Les Actions Composees
    */
    public static List<ActionComposee> getAllActionsComposees() {
        return allActionsComposees;
    }
    /**
    * Fonction permettant d’effacer toutes les actions composées disponibles.
    */
    public static void clearAllActionsComposees() {
        allActionsComposees.clear();
    }
    
    /**
     * Fonction pour obtenir la composition d'une action composée.
     * @param libelle le libellé de l'action composée
     * @return la composition de l'action composée, contenant les actions simples et leur pourcentage
     */
    public static Map<String, Float> getComposition(String libelle) {
        for (ActionComposee ac : allActionsComposees) {
            if (ac.getLibelle().equals(libelle)) {
                Map<String, Float> composition = new HashMap<>();
                for (Map.Entry<ActionSimple, Float> entry : ac.mapPanier.entrySet()) {
                    composition.put(entry.getKey().getLibelle(), entry.getValue());
                }
                return composition;
            }
        }
        return null;
    }
    
    @Override
    public float valeur(Jour j) {
        float valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur += (as.valeur(j) * this.mapPanier.get(as));
        }
        return valeur;
    }

    @Override
    public double getPrixAction() {
        // À implémenter
        return 0;
    }

    @Override
    public int soustraireQuantite(int quantite) {
        // À implémenter
        return 0;
    }
}