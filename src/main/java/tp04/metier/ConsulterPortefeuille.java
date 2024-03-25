/*
 * Copyright 2024 Yassine Alouini.
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
 * Cette classe permet de consulter les actions contenues dans un portefeuille.
 * 
 * @author Yassine Alouini
 */
public class ConsulterPortefeuille {
    
    /**
     * Fonction pour consulter les actions contenues dans un portefeuille.
     * 
     * @param portefeuille Le portefeuille à consulter.
     */
    public static void consulterPortefeuille(Portefeuille portefeuille) {
        Map<Action, LignePortefeuille > mapLignes = portefeuille.getMapLignes();

        if (mapLignes.isEmpty()) {
            System.out.println("Le portefeuille est vide.");
        } else {
            System.out.println("Résumé du contenu du portefeuille :");

            for (Map.Entry<Action, LignePortefeuille> entry : mapLignes.entrySet()) {
                Action action = entry.getKey();
                LignePortefeuille lignePortefeuille = entry.getValue();
                int quantite = lignePortefeuille.getQte();
                float valeur = quantite * action.valeur(new Jour());

                String message = String.format("Action : %s | Quantité : %d | Valeur totale : %.2f", action.getLibelle(),
                        quantite, valeur);
                System.out.println(message);
            }
        }
    }
}

