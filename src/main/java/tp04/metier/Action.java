/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.Objects;

/**
 * Classe représentant une action 
 * Attributs : libellé (string) et valeur (float)
 * @author somebody
 * 
 */
public abstract class Action {

    private String libelle;
    public abstract float valeur(Jour j);
    
    public Action(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Recupérer la valeur du libellé d'une action
     *
     * @return string (libelle)
     */
    public String getLibelle() {
        return libelle;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return true;
    }

    /** 
     * Fonction permettant d'afficher le libellé d'un action
     * @return String
     */
    public String toString() {
        return this.getLibelle();
    }
}
