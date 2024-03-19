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
        super(libelle);
        this.quantite = quantite;
        this.prix = prix;
        this.mapCours = new HashMap<>();
        this.availableActions = new ArrayList<>();
    }
    
    public ActionSimple() {
        super(null);
    }
    

    public void addToAvailableActions() {
        this.availableActions.add(this);
    }

    @Override
    public int getQuantite() {
        return quantite;
    }

    /**
     * 
     * @param quantite
     * @return 
     */
    @Override
    public int soustraireQuantite(int quantite) {
        this.quantite -= quantite;
        return quantite;
    }

    /**
     * 
     * @param quantite 
     */
    public void ajouterQuantite(int quantite) {
        this.quantite += quantite;
    }

    @Override
    public double getPrixAction() {
        return prix;
    }

    /**
     * 
     * @param j
     * @param v 
     */
    public void enrgCours(Jour j, float v) {
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    /**
     * 
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
     * 
     * @param availableActions 
     */
    public void afficherActionsSimples(List<Action> availableActions) {
        System.out.println("Actions disponibles :");
        for (Action action : availableActions) {
            System.out.println(action);
        }
    }

    /**
     * 
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
     * 
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
     * 
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