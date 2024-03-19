/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette classe représente un portefeuille qui contient des lignes de portefeuille
 * @author somebody
 */

public class Portefeuille {

    private Map<Action, LignePortefeuille> mapLignes;
    private List<Action> availableActions;
    private Map<ActionSimple, Map<Client, Integer>> actionsClient;

    /**
     * Constructeur de la classe Portefeuille
     */
    public Portefeuille() {
        this.mapLignes = new HashMap<>();
        this.actionsClient = new HashMap<>();

    }

    /**
     * Méthode pour acheter une certaine quantité d'une action donnée et l'ajouter au portefeuille
     * @param a
     * @param q 
     */
    
   
    public void acheter(Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }
    
    /**
     * @param action
     * @param nombreActions
     * @param client 
     */
    public void acheter(ActionSimple action, int nombreActions, Client client) {
         // Vérifier si l'action est déjà présente dans le portefeuille
         if (!actionsClient.containsKey(action)) {
             actionsClient.put(action, new HashMap<>());
         }

         // Ajouter l'achat au portefeuille
         actionsClient.get(action).put(client, nombreActions);
     }
   

    /**
     * Méthode pour vendre une certaine quantité d'une action donnée du portefeuille
     * Si la quantité à vendre est supérieure à la quantité détenue dans le portefeuille,
     * l'action est retirée du portefeuille.
     * @param a
     * @param q 
     */
    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a)) {
            int currentQuantity = this.mapLignes.get(a).getQte();
            if (currentQuantity >= q) {
                this.mapLignes.get(a).setQte(currentQuantity - q);
            } else if (currentQuantity == q) {
                this.mapLignes.remove(a);
            }
        }
    }
    
   public void vendreEntreprise(ActionSimple action, int quantite) {
    if (action != null && mapLignes.containsKey(action)) {
        int palierBlocage = action.getEntreprise().getPalierBlocage();
        if (quantite <= palierBlocage) {
            int currentQuantity = mapLignes.get(action).getQte();
            if (currentQuantity >= quantite) {
                mapLignes.get(action).setQte(currentQuantity - quantite);
                System.out.println("La vente a été realisée");
            } else {
                System.out.println("La vente de cette quantité est bloquée.");
            }
        } else {
            System.out.println("La vente de cette quantité est bloquée.");
        }
    } else {
        System.out.println("Action non trouvée dans le portefeuille.");
    }
}

    public String toString() {
        return this.mapLignes.toString();
    }

    /**
     * 
     * @param j
     * @return 
     */
    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += lp.getQte() * lp.getAction().valeur(j);
        }
        return total;
    }

    /**
     * 
     * @param action
     * @return 
     */
    public int getQuantite(Action action) {
        return mapLignes.containsKey(action) ? mapLignes.get(action).getQte() : 0;
    }

    /**
     * 
     * @return 
     */
    public Map<Action, LignePortefeuille> getMapLignes() {
        return mapLignes;
    }

    
    
    /**
     * 
     * @return 
     */
    public List<Action> getAvailableActions() {
        return availableActions;
    }

    /**
     * 
     * @param availableActions 
     */
    public void setAvailableActions(List<Action> availableActions) {
        this.availableActions = availableActions;
    }

    /**
     * 
     * @param action
     * @param quantity 
     */
    public void soustraire(Action action, int quantity) {
        LignePortefeuille ligne = mapLignes.get(action);
        if (ligne != null) {
            ligne.setQte(ligne.getQte() - quantity);
        }
    }

    /**
     * 
     * @param action
     * @param quantity 
     */
    public void ajouter(Action action, int quantity) {
        LignePortefeuille ligne = mapLignes.get(action);
        if (ligne != null) {
            ligne.setQte(ligne.getQte() + quantity);
        }
    }
    
    /**
     * 
     * @param action
     * @return 
     */
    public Client actionnaireMajoritaire(ActionSimple action) {
        if (!actionsClient.containsKey(action)) {
            return null; // L'action n'est pas présente dans le portefeuille
        }

        Map<Client, Integer> ownership = actionsClient.get(action);
        Client actionnaireMajoritaire = null;
        int maxActions = 0;

        for (Map.Entry<Client, Integer> entry : ownership.entrySet()) {
            if (entry.getValue() > maxActions) {
                maxActions = entry.getValue();
                actionnaireMajoritaire = entry.getKey();
            }
        }

        return actionnaireMajoritaire;
    }

    
    /**
     * Méthode pour obtenir la quantité détenue par un client pour une action donnée
     * @param action
     * @param client
     * @return 
     */
    private int getQuantite(Action action, Client client) {
        for (LignePortefeuille lignePortefeuille : mapLignes.values()) {
            // Vérifier si la ligne de portefeuille concerne l'action spécifiée et si elle contient le client donné
            if (lignePortefeuille.getAction().equals(action) && lignePortefeuille.getClients().contains(client)) {
                return lignePortefeuille.getQte(); // Retourner la quantité détenue par le client
            }
        }
        return 0; // Retourner 0 si le client n'est pas associé à cette action dans le portefeuille
    }

}
