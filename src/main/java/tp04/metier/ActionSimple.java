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
 * Cette classe représente une action simple, qui est un type spécifique d'action.
 * @author somebody
 */
public class ActionSimple extends Action {

    /** 
     * attributs 
     */
    private Map<Jour, Cours> mapCours;
    private int quantite;
    private double prix;
    
    /**l'attribut pour stocker le pourcentage maximal d'actions 
     * disponibles à la vente
    */
    private double pourcentageMaxVente;
    private List<Action> availableActions;
    private Portefeuille portfolio = new Portefeuille();

    /**
     * Constructeur de la classe ActionSimple.
     * @param libelle le libellé de l'action simple
     * @param quantite la quantité initiale de l'action simple
     * @param prix le prix unitaire de l'action simple
     */
    public ActionSimple(String libelle, int quantite, double prix) {
        super(libelle);
        this.mapCours = new HashMap();
        this.pourcentageMaxVente = 100;
        this.quantite = quantite;
        this.prix = prix;
        this.mapCours = new HashMap<>();
        this.availableActions = new ArrayList<>();
    }
    
    /**
     * Constructeur de la classe ActionSimple avec entreprise.
     * @param libelle le libellé de l'action simple
     * @param quantite la quantité initiale de l'action simple
     * @param prix le prix unitaire de l'action simple
     * @param entreprise l'entreprise associée à l'action simple
     */
    public ActionSimple(String libelle, int quantite, double prix, Entreprise entreprise) {
        super(libelle);
        this.quantite = quantite;
        this.prix = prix;
        this.entreprise = entreprise;
    }

    ActionSimple(String libelle) {
        super(libelle);
        this.mapCours = new HashMap<>();
    }

    public ActionSimple() {
        super(null);
    }
    
    
    // Méthodes
    /**
     * Méthode pour ajouter cette action à la liste des actions disponibles.
     */
    public void addToAvailableActions() {
        this.availableActions.add(this);
    }
    
    public Map<Jour, Cours> getMapCours() {
    return mapCours;
}

    public List<Action> getAvailableActions() {
        return availableActions;
    }

   

    /**
     * Méthode pour soustraire une quantité donnée de la quantité disponible de cette action.
     * @param quantite la quantité à soustraire
     * @return la quantité restante
     */
    @Override
    public int soustraireQuantite(int quantite) {
        this.quantite -= quantite;
        return quantite;
    }

    /**
     * Méthode pour ajouter une quantité donnée à la quantité disponible de cette action.
     * @param quantite la quantité à ajouter
     */
    public void ajouterQuantite(int quantite) {
        this.quantite += quantite;
    }

    /**
     * Méthode pour obtenir le prix d'une unité de cette action.
     * @return le prix unitaire de l'action
     */
    @Override
    public double getPrixAction() {
        return prix;
    }
    
    /**
     * 
     * @param availableActions 
     */  
    public void setAvailableActions(List<Action> availableActions) {
    this.availableActions = availableActions;
    }

    /**
     * Enregistrement de la valeur d'une action à une date donnée
     * 
     * @param j une date donnée
     * @param v valeur
     */
    public void enrgCours(Jour j, float v) {
        if (this.mapCours == null) {
            // Si mapCours est null, initialiser un nouveau HashMap
            this.mapCours = new HashMap<>();
        }
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }
    
      /**
     * Méthode pour obtenir la quantité disponible de cette action.
     * @return la quantité disponible de l'action
     */
    @Override
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


    public void setMapCours(Map<Jour, Cours> mapCours) {
            this.mapCours = mapCours;
    }

    /**
     * Méthode pour obtenir la valeur de cette action pour un jour donné.
     * @param j le jour pour lequel calculer la valeur
     * @return la valeur de l'action pour le jour donné
     */
    @Override
    public float valeur(Jour j) {
        if (this.mapCours != null && this.mapCours.containsKey(j)) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0;
        }
    }

    /**
     * Méthode pour afficher les actions simples disponibles.
     * @param availableActions la liste des actions disponibles
     */
    public void afficherActionsSimples(List<Action> availableActions) {
        System.out.println("Actions disponibles :");
        for (Action action : availableActions) {
            System.out.println(action);
        }
    }

    /**
     * Méthode pour acheter une quantité donnée de cette action dans un portefeuille.
     * @param portfolio le portefeuille dans lequel acheter l'action
     * @param selectedAction l'action à acheter
     * @param quantity la quantité à acheter
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
     * Méthode pour vendre une quantité donnée de cette action dans un portefeuille.
     * @param portefeuille le portefeuille dans lequel vendre l'action
     * @param actionToSell l'action à vendre
     * @param quantityToSell la quantité à vendre
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
                    System.out.println("Quantité de " + action.getLibelle() + " dans mon portefeuille avant la vente : " + portefeuille.getQuantite(action));
                    portefeuille.vendre(action, quantityToSell);
                    System.out.println("Quantité de " + action.getLibelle() + " dans mon portefeuille après la vente : " + portefeuille.getQuantite(action));
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
     * Méthode privée pour mettre à jour la quantité disponible de cette action après une vente.
     * @param action l'action vendue
     * @param quantitySold la quantité vendue
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
    
    /**
     * Méthode pour faire une recherche en fonction du libelle (une partie ou le nom en entier)
     * @param nom
     * @return 
     */
     public List<ActionSimple> rechercherParNom(String nom) {
        System.out.println("Recherche par nom, nom recherché : " + nom);
        List<ActionSimple> resultats = new ArrayList<>();
        for (Action action : availableActions) {
            if (action instanceof ActionSimple) {
                ActionSimple actionSimple = (ActionSimple) action;
                if (actionSimple.getLibelle().toLowerCase().contains(nom.toLowerCase())) {
                    resultats.add(actionSimple);
                }
            }
        }
        return resultats;
    }
     
   
}
