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
 *
 * @author somebody
 */

public class Portefeuille {

    private Map<Action, LignePortefeuille> mapLignes;
    private List<Action> availableActions;

    public Portefeuille() {
        this.mapLignes = new HashMap<>();
    }

    /**
     * 
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
     * 
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
}
