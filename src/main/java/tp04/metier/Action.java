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

    // Variables d'instance
    private String libelle;
    protected Entreprise entreprise;
    private List<Client> clients;

    // Constructeur
    /**
     * Constructeur de la classe Action.
     * @param libelle le libellé de l'action
     */
    public Action(String libelle) {
        this.libelle = libelle;
        this.clients = new ArrayList<>();
    }

    // Méthodes abstraites
    /**
     * Méthode abstraite pour obtenir la quantité de cette action.
     * @return la quantité de l'action
     */
    public abstract int getQuantite();
    
    /**
     * Méthode abstraite pour obtenir le prix d'une unité de cette action.
     * @return le prix d'une unité de l'action
     */
    public abstract double getPrixAction();
 
    // Méthodes
    /**
     * Méthode pour ajouter un client à cette action.
     * @param client le client à ajouter
     */
    public void addClient(Client client) {
        clients.add(client);
    }
    
    /**
     * Méthode pour récupérer la liste des clients associés à cette action.
     * @return la liste des clients associés à cette action
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Méthode pour récupérer le libellé de cette action.
     * @return le libellé de l'action
     */
    public String getLibelle() {
        return libelle;
    }
    
    
    /**
     * Méthode pour récupérer l'entreprise associée à cette action.
     * @return l'entreprise associée à cette action
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     * Méthode pour définir l'entreprise associée à cette action.
     * @param entreprise l'entreprise à définir
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * Méthode pour soustraire la quantité achetée de la quantité disponible.
     * @param quantite la quantité à soustraire
     * @return la quantité restante
     */
    public abstract int soustraireQuantite(int quantite);

    /**
     * Méthode pour obtenir la valeur de l'action pour un jour donné.
     * @param j le jour pour lequel calculer la valeur
     * @return la valeur de l'action pour le jour donné
     */
    public abstract float valeur(Jour j);

    /**
     * Redéfinition de la méthode hashCode pour la classe Action.
     * @return le code de hachage de l'action
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    /**
     * Redéfinition de la méthode equals pour la classe Action.
     * @param obj l'objet à comparer
     * @return true si les objets sont égaux, false sinon
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
     * Redéfinition de la méthode toString pour la classe Action.
     * @return une représentation sous forme de chaîne de caractères de l'action
     */
    @Override
    public String toString() {
        return this.getLibelle();
    }
}