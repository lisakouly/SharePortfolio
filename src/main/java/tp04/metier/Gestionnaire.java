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
 *
 * @author zhuo, yaning 
import java.util.Map;

/**
 * Cette classe représente un gestionnaire qui permet de consulter les actions achetées par les clients
 * et les quantités détenues dans un portefeuille.
 * 
 * @author mazhu
 */
public class Gestionnaire {
   
    
    
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
