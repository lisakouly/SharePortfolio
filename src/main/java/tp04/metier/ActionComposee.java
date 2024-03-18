/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author somebody
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;
    private int quantite;
    private double prix;
    
    private static final List<ActionComposee> allActionsComposees = new ArrayList<>();

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
        allActionsComposees.add(this);
    }

    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    
    /**
    *
    * function pour connaitre toutes les actions composées disponibles
    * @return une list de toutes Les Actions Composees
    */
    public static List<ActionComposee> getAllActionsComposees() {
        return allActionsComposees;
    }

    @Override
    public float valeur(Jour j) {
        float valeur;

        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }

        return valeur;
    }

}
