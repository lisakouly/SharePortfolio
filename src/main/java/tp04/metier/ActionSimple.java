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
 * Cette classe représente une action simple, qui est un type spécifique d'action
 * @author somebody
 */
public class ActionSimple extends Action {

    private Map<Jour, Cours> mapCours;
    private int quantite;
    private double prix;
    private List<Action> availableActions;
    private Portefeuille portfolio = new Portefeuille();

    /**
     * Constructeur de la classe ActionSimple
     * @param libelle
     * @param quantite
     * @param prix 
     */
    public ActionSimple(String libelle, int quantite, double prix) {
        super(libelle);
        this.quantite = quantite;
        this.prix = prix;
        this.mapCours = new HashMap<>();
        this.availableActions = new ArrayList<>();
    }
    
      public ActionSimple(String libelle, int quantite, double prix, Entreprise entreprise) {
        super(libelle);
        this.quantite = quantite;
        this.prix = prix;
        this.entreprise = entreprise;
    }
    
    /**
     * Constructeur par défaut de la classe ActionSimple
     */
    public ActionSimple() {
        super(null);
    }
    
    /**
     * Méthode pour ajouter cette action à la liste des actions disponibles
     */
    public void addToAvailableActions() {
        this.availableActions.add(this);
    }

    /**
     * Méthode pour obtenir la quantité disponible de cette action
     * @return 
     */
    @Override
    public int getQuantite() {
        return quantite;
    }

    /**
     * Méthode pour soustraire une quantité donnée de la quantité disponible de cette action
     * @param quantite
     * @return 
     */
    @Override
    public int soustraireQuantite(int quantite) {
        this.quantite -= quantite;
        return quantite;
    }

    /**
     * Méthode pour ajouter une quantité donnée à la quantité disponible de cette action
     * @param quantite 
     */
    public void ajouterQuantite(int quantite) {
        this.quantite += quantite;
    }

    /**
     * Méthode pour obtenir le prix d'une unité de cette action
     * @return 
     */
    @Override
    public double getPrixAction() {
        return prix;
    }

    /**
     * Méthode pour enregistrer un cours pour cette action pour un jour donné
     * @param j
     * @param v 
     */
    public void enrgCours(Jour j, float v) {
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    /**
     * Méthode pour obtenir la valeur de cette action pour un jour donné
     * @param j
     * @return 
     */
    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j)) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0;
        }
    }

    /**
     * Méthode pour afficher les actions simples disponibles
     * @param availableActions 
     */
    public void afficherActionsSimples(List<Action> availableActions) {
        System.out.println("Actions disponibles :");
        for (Action action : availableActions) {
            System.out.println(action);
        }
    }

    /**
     * Méthode pour acheter une quantité donnée de cette action dans un portefeuille
     * @param portfolio
     * @param selectedAction
     * @param quantity 
     */
    public void acheterActionSimple(Portefeuille portfolio, Action selectedAction, int quantity) {
        if (selectedAction instanceof ActionSimple) {
            ActionSimple selectedActionSimple = (ActionSimple) selectedAction;
            if (availableActions.contains(selectedActionSimple)) {
                portfolio.acheter(selectedActionSimple, quantity);
                availableActions = portfolio.getAvailableActions();
                selectedActionSimple.soustraireQuantite(quantity);
                System.out.println("Vous avez acheté " + quantity + " actions de " + selectedActionSimple.getLibelle());
                System.out.println("Quantité de " + selectedActionSimple.getLibelle() + " dans le portefeuille : " + portfolio.getQuantite(selectedActionSimple));
                System.out.println("Quantité de " + selectedActionSimple.getLibelle() + " disponible : " + selectedActionSimple.getQuantite());
            } else {
                System.out.println("Action non disponible.");
            }
        } else {
            System.out.println("La sélection n'est pas une action simple.");
        }
    }

    /**
     * Méthode pour vendre une quantité donnée de cette action dans un portefeuille
     * @param portefeuille
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
                    System.out.println("Quantité de " + action.getLibelle() + " dans mon portefeuille avant  la vente : " + portefeuille.getQuantite(action));
                    portefeuille.vendre(action, quantityToSell);
                    System.out.println("Quantité de " + action.getLibelle() + " dans mon portefeuille après  la vente : " + portefeuille.getQuantite(action));
                    System.out.println("Vente réussie : " + quantityToSell + " actions de " + actionToSell.getLibelle() + " vendues.");
                    portfolio.setAvailableActions(availableActions);
                    updateQuantiteDisponible(actionToSell, quantityToSell);
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
     * Méthode privée pour mettre à jour la quantité disponible de cette action après une vente
     * @param action
     * @param quantitySold 
     */
    private void updateQuantiteDisponible(Action action, int quantitySold) {
        if (action instanceof ActionSimple) {
            ActionSimple actionSimple = (ActionSimple) action;
            actionSimple.ajouterQuantite(quantitySold);
            portfolio.soustraire(actionSimple, quantitySold);
            System.out.println("Quantité de " + actionSimple.getLibelle() + " mise à jour : " + actionSimple.getQuantite());
        } else {
            System.out.println("Action non disponible.");
        }
    }
}