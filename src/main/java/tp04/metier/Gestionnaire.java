/*
 * Copyright 2024 mazhu.
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

import java.util.Map;

/**
 * Cette classe représente un gestionnaire qui permet de consulter les actions achetées par les clients
 * et les quantités détenues dans un portefeuille.
 * 
 * @author mazhu
 */
public class Gestionnaire {
    private String nom;
    private String prenom;
    
    /**
     * Constructeur par défaut.
     */
    public Gestionnaire() {
    }
    
    
    /**
     * Constructeur avec paramètres
     * @param nom
     * @param prenom 
     */
    
    public Gestionnaire(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
    }

    // Getters et setters
    
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
     * @param portefeuille
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
