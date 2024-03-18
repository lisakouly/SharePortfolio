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
 * @author somebody
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;
    private int quantite;
    private double prix;

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
    }
    
    /**
     * Redéfinition de la méthode pour obtenir la quantité disponible 
     * @return 
     */
    @Override
    public int getQuantite() {
        return quantite;
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
}
