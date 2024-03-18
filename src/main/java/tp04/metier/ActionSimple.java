/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author somebody
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;
    private int quantite;
    private double prix;
    private List<Action> availableActions;
    private Portefeuille portfolio;


    

    /**
     * 
     * @param libelle
     * @param quantite
     * @param prix 
     */

    public ActionSimple(String libelle, int quantite, double prix) {
        // Action simple initialisée comme 1 action
        super(libelle);
        this.quantite = quantite;
        this.prix = prix;
        // init spécifique
        this.mapCours = new HashMap();
        this.availableActions = new ArrayList<>();
    }
    
        public ActionSimple() {
        super(null);
    }
    
    /**
     * Redéfinition de la méthode pour obtenir la quantité disponible 
     * @return 
     */
    @Override
    public int getQuantite() {
        return quantite;
    }
 
    // Implémentation de la méthode soustraireQuantite IMANE
    @Override
    public int soustraireQuantite(int quantite) {
        this.quantite -= quantite;
        return quantite;
    }
    
     // Méthode pour ajouter une quantité à l'action après vente WIDAD
    public void ajouterQuantite(int quantite) {
        this.quantite += quantite;
    }
    /**
     * Redéfinition de la méthode pour obtenir le prix de l'action simple
     * @return 
     */
    @Override
    public double getPrixAction() {
        return prix;
    }
    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        if (this.mapCours.containsKey(j) == false) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j) == true) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; // definition d'une constante possible
        }
    }
    
    /**
     * Méthode pour afficher les actions disponibles.
     */
    public void afficherActionsSimples( List<Action> availableActions) {
        System.out.println("Actions disponibles :");
        for (Action action : availableActions) {
            System.out.println(action);
        }
    }
    
    /**
     * Méthode pour acheter une action.
     * @param selectedAction
     * @param quantity 
     */
      public void acheterActionSimple(Action selectedAction, int quantity) {
        if (availableActions.contains(selectedAction)) {
            portfolio.acheter(selectedAction, quantity);
            selectedAction.soustraireQuantite(quantity);
            portfolio.setAvailableActions(availableActions);

            System.out.println("Vous avez acheté " + quantity + " actions de " + selectedAction.getLibelle());
        } else {
            System.out.println("Action non disponible.");
        }
    }
     
      /**
       *  Méthode pour mettre à jour la quantité disponible d'une action.
       * @param action
       * @param quantiteVendue 
       */
     public void updateQuantiteDisponible(ActionSimple action, int quantiteVendue) {
        if (availableActions.contains(action)) {
            action.ajouterQuantite(quantiteVendue);
            System.out.println("Quantité de " + action.getLibelle() + " mise à jour : " + action.getQuantite());
        } else {
            System.out.println("Action non disponible.");
        }
    }
     
   
}

