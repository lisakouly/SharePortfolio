/*
 * Copyright 2024 Imane.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente une ligne dans un portefeuille, associée à une action.
 * Elle contient des informations sur la quantité de l'action détenue et son prix.
 * Elle peut également contenir une liste de clients associés à cette ligne.
 * @author Imane
 */
public class LignePortefeuille {
    
    // Variables d'instance
    private Action action;
    private int qte;
    private double prix;
    private List<Client> clients;

    // Constructeur
    /**
     * Constructeur de la classe LignePortefeuille.
     * @param action l'action associée à cette ligne
     * @param qte la quantité de l'action détenue dans le portefeuille
     */
    public LignePortefeuille(Action action, int qte) {
        this.action = action;
        this.qte = qte;
        this.clients = new ArrayList<>();
    }
          
    // Méthodes
    
    /**
     * Méthode pour obtenir la quantité de l'action détenue dans le portefeuille.
     * @return la quantité de l'action
     */
    public int getQte() {
        return qte;
    }

    /**
     * Méthode pour définir la quantité de l'action détenue dans le portefeuille.
     * @param qte la quantité à définir
     */
    public void setQte(int qte) {
        this.qte = qte;
    }
        
    /**
     * Méthode pour obtenir le prix associé à cette ligne de portefeuille.
     * @return le prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Méthode pour définir le prix associé à cette ligne de portefeuille.
     * @param prix le prix à définir
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Méthode pour obtenir l'action associée à cette ligne de portefeuille.
     * @return l'action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Méthode pour ajouter un client à cette ligne de portefeuille.
     * @param client le client à ajouter
     */
    public void addClient(Client client) {
        clients.add(client);
    }
     
    /**
     * Méthode pour récupérer la liste des clients associés à cette ligne de portefeuille.
     * @return la liste des clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Redéfinition de la méthode toString pour afficher la quantité de l'action.
     * @return une chaîne de caractères représentant la quantité
     */
    @Override
    public String toString() {
        return Integer.toString(qte);
    }
}
