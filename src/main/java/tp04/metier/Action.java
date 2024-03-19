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
 *
 * @author somebody
 */
public abstract class Action {

    private String libelle;
    protected Entreprise entreprise;

    
    //IMANE +++
    private List<Client> clients;

    public Action(String libelle) {
        this.libelle = libelle;
         this.clients = new ArrayList<>();

    }
    
    public abstract int getQuantite();
    
    public abstract double getPrixAction();

    
    // Méthode pour ajouter un client à cette action 
    public void addClient(Client client) {
        clients.add(client);
    }
    
    // Méthode pour récupérer la liste des clients associés à cette action
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */

    public String getLibelle() {
        return libelle;
    }
    
     public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    // Méthode pour soustraire la quantité achetée de la quantité disponible IMANE
    public abstract int soustraireQuantite(int quantite);
    public abstract float valeur(Jour j);

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

    public String toString() {
        return this.getLibelle();
    }
}
