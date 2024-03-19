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
 * @author Zhuo
 */
public class ActionComposee extends Action {

    // attribut lien
    Map<ActionSimple, Float> mapPanier;
    private int quantite;
    
    private static final List<ActionComposee> allActionsComposees = new ArrayList<>();

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
        allActionsComposees.add(this);
    }

    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    
    public int getQuantite() {
            return quantite;
    }

    public void setQuantite(int quantite) {
            this.quantite = quantite;
    }

    
    /**
    *
    * function pour connaitre toutes les actions composées disponibles
    * @return une list de toutes Les Actions Composees
    */
    public static List<ActionComposee> getAllActionsComposees() {
        return allActionsComposees;
    }
    
    /**
     * Fonction pour obtenir  la composition de la action composée.
     * @author Zhuo,Yaning
     * @param libelle d'une action composée
     * @return la composition de la action composée,
     * contenant les Action Simple et son pourcentage.
     */
    public static Map<String, Float> getComposition(String libelle) {
        for (ActionComposee ac : allActionsComposees) {
            if (ac.getLibelle().equals(libelle)) {
                Map<String, Float> composition = new HashMap<>();
                for (Map.Entry<ActionSimple, Float> entry : ac.mapPanier.entrySet()) {
                    composition.put(entry.getKey().getLibelle(), entry.getValue());
                }
                return composition;
            }
        }
        return null;
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

    /*@Override
    public int getQuantite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    @Override
    public double getPrixAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int soustraireQuantite(int quantite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
