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

    Map<Action, LignePortefeuille> mapLignes;
    private List<Action> availableActions;


    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
    
     public int getQuantite(Action action) {
        return mapLignes.containsKey(action) ? mapLignes.get(action).getQte() : 0;
    }

    
    public Map<Action, LignePortefeuille> getMapLignes() {
        return mapLignes;
    }
    
      public List<Action> getAvailableActions() {
        return availableActions;
    }
    
     public void setAvailableActions(List<Action> availableActions) {
        this.availableActions = availableActions;
    }
}

