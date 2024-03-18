/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zhuo,Yaning
 */
public class Portefeuille {
    
    private String nomPortefeuille;
    
    Map<Action, LignePortefeuille> mapLignes;

    private class LignePortefeuille {

        private Action action;

        private int qte;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public Action getAction() {
            return this.action;
        }

        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }
     public Portefeuille(String nomPortefeuille) {
        this.mapLignes = new HashMap();
        this.nomPortefeuille = nomPortefeuille;
    }
    
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
    public Map<Action, LignePortefeuille> getMapLignes() {
		return mapLignes;
    }

    public void setMapLignes(Map<Action, LignePortefeuille> mapLignes) {
            this.mapLignes = mapLignes;
    }
    /**
    * Function pour vendre la totalité de portefeuille
    * 
    * @param nomPortefeuille Nom du portefeuille à vendre
    */
    public void vendrePortefeuille(String nomPortefeuille){
        
        for (LignePortefeuille lp : this.mapLignes.values()){
            Action action = lp.getAction();
            int quantite = lp.getQte();
            if (action instanceof ActionSimple) {
                int quantiteNewSimple= ((ActionSimple) action).getQuantite()+ quantite;
                ((ActionSimple) action).setQuantite(quantiteNewSimple);
            } else if (action instanceof ActionComposee){
                int quantiteNewComposee = ((ActionComposee) action).getQuantite()+ quantite;
                ((ActionComposee) action).setQuantite(quantiteNewComposee);
            }
                 
        }
        mapLignes.clear();
    }
}
