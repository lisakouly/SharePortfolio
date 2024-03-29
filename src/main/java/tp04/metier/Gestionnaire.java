/*
 * Copyright 2024 mazhuo.
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
import java.util.Map;



/**
 * Cette classe représente un gestionnaire qui permet de consulter les actions achetées par les clients
 * et les quantités détenues dans un portefeuille.
 * 
 * Auteur : Zhuo, Yaning
 */
public class Gestionnaire {
    private String nom;
    private String prenom;
    
    /**
     * Vérifie si le client est solvable pour l'achat d'une action donnée.
     * 
     * @param client Le client qui souhaite acheter l'action.
     * @param j Le jour auquel l'achat est effectué.
     * @param action L'action à acheter.
     * @param quantity La quantité d'actions à acheter.
     * @return True si le client est solvable, sinon false.
     */
     public boolean estClientSolvable(Client client, Jour j, Action action, int quantity) {
         /* Calculate total investments*/
         float totalInvestissements = 0.0f;
         for (Portefeuille portefeuille : client.getPortefeuilles()) {
             totalInvestissements += portefeuille.valeur(j);
         }
         /*Calculate total price of the action*/
         float prixTotalAction = action.valeur(j) * quantity;
         /*Check if the client is solvable*/
         return client.getCapital() >= (totalInvestissements + prixTotalAction);
     }

    /**
     * Constructeur par défaut.
     */
    public Gestionnaire() {
    }
    
    
    /**
     * Constructeur avec paramètres.
     * 
     * @param nom Le nom du gestionnaire.
     * @param prenom Le prénom du gestionnaire.
     */
    public Gestionnaire(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
    }

    
    /**
     * Getter pour l'attribut nom.
     * @return Le nom du gestionnaire.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour l'attribut nom.
     * @param nom Le nom du gestionnaire à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter pour l'attribut prenom.
     * @return Le prénom du gestionnaire.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter pour l'attribut prenom.
     * @param prenom Le prénom du gestionnaire à définir.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
     
     /**
     * Méthode pour consulter les actions achetées par les clients et les quantités détenues dans un portefeuille.
     * 
     * @param portefeuille Le portefeuille du client.
     */
    public void consulterActionsAchetees(Portefeuille portefeuille) {
        Map<Action, LignePortefeuille> mapLignes = portefeuille.getMapLignes();
        
        for (Map.Entry<Action, LignePortefeuille> entry : mapLignes.entrySet()) {
            Action action = entry.getKey();
            LignePortefeuille lignePortefeuille = entry.getValue();
            
            System.out.println("Action : " + action.getLibelle());
            System.out.println("Quantité détenue : " + lignePortefeuille.getQte());
            System.out.println("---------------------------------------");
        }
    }
}
