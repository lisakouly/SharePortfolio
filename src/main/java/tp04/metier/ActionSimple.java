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
    private Portefeuille portfolio = new Portefeuille();

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
     * 
     * @param actionToSell
     * @param quantityToSell 
     */
    public void vendreActionSimple(Portefeuille portefeuille, Action actionToSell, int quantityToSell) {
        if (portefeuille != null && actionToSell != null && quantityToSell > 0) {
            Action action = null;
            for (Map.Entry<Action, LignePortefeuille> entry : portefeuille.getMapLignes().entrySet()) {
                if (entry.getKey().getLibelle().equals(actionToSell.getLibelle())) {
                    action = entry.getKey();
                    break;
                }
            }

            if (action != null) {
                int totalQuantity = portefeuille.getQuantite(action);
                if (quantityToSell <= totalQuantity) {
                    portefeuille.vendre(action, quantityToSell);
                    System.out.println("Vente réussie : " + quantityToSell + " actions de " + actionToSell.getLibelle() + " vendues.");
                    portfolio.setAvailableActions(availableActions);

                    // Mettre à jour les actions disponibles
                    updateQuantiteDisponible(action, quantityToSell);
                } else {
                    System.out.println("La quantité à vendre dépasse la quantité disponible dans le portefeuille.");
                }
            } else {
                System.out.println("Action non trouvée dans le portefeuille.");
            }
        } else {
            System.out.println("Paramètres invalides pour la vente d'une action.");
        }
        

    }

    /**
     * Méthode pour mettre à jour la quantité disponible d'une action.
     */
    private void updateQuantiteDisponible(Action action, int quantitySold) {
        // Assurez-vous que l'action est une instance d'ActionSimple
        if (action instanceof ActionSimple) {
            // Cast l'action en ActionSimple
            ActionSimple actionSimple = (ActionSimple) action;
            
            // Mettre à jour la quantité disponible en ajoutant la quantité vendue
            actionSimple.ajouterQuantite(quantitySold);
            
            // Affichez un message pour indiquer que la quantité disponible a été mise à jour
            System.out.println("Quantité de " + actionSimple.getLibelle() + " mise à jour : " + actionSimple.getQuantite());
        } else {
            // Si l'action n'est pas une instance d'ActionSimple, affichez un message d'erreur
            System.out.println("Action non disponible.");
        }
    }
}