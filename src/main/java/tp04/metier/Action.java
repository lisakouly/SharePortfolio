/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cette classe abstraite représente une action générique.
 * @author somebody
 */
public abstract class Action {

    
    private String libelle;
    protected Entreprise entreprise;

    private List<Client> clients;

    /**
     * Constructeur de la classe Action.
     * @param libelle 
     */
    public Action(String libelle) {
        this.libelle = libelle;
         this.clients = new ArrayList<>();

    }
    
    /**
     * Méthode abstraite pour obtenir la quantité de cette action.
     * @return 
     */
    public abstract int getQuantite();
    
    /**
     * Méthode abstraite pour obtenir le prix d'une unité de cette action.
     * @return 
     */
    public abstract double getPrixAction();
 
    /**
     * Méthode pour ajouter un client à cette action
     * @param client 
     */
    public void addClient(Client client) {
        clients.add(client);
    }
    
    /**
     *Méthode pour récupérer la liste des clients associés à cette action
     * @return 
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Méthode pour récupérer le libellé de cette action.
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }
    
     public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     * Méthode pour définir l'entreprise associée à cette action.
     * @param entreprise 
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * Méthode pour soustraire la quantité achetée de la quantité disponible
     * @param quantite
     * @return 
     */
    public abstract int soustraireQuantite(int quantite);
    public abstract float valeur(Jour j);

    /**
     * Redéfinition de la méthode hashCode pour la classe Action.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    /**
     * Redéfinition de la méthode equals pour la classe Action
     * @param obj
     * @return 
     */
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
     * Redéfinition de la méthode toString pour la classe Action
     * @return 
     */
    public String toString() {
        return this.getLibelle();
    }
}
