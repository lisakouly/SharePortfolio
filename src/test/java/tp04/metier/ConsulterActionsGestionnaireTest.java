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

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Cette classe teste la méthode de consultation des actions achetées par le gestionnaire.
 * Elle vérifie si les actions et les quantités détenues correspondent aux attentes après consultation.
 * 
 * @author Imane
 */
public class ConsulterActionsGestionnaireTest {

    private Portefeuille portefeuille;
    private Gestionnaire gestionnaire;

    @BeforeEach
    public void setUp() {
        portefeuille = new Portefeuille();
        gestionnaire = new Gestionnaire();
        // Créer des actions pour le test
        Entreprise entreprise = new Entreprise("Entreprise A", 1000, 50);
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00, entreprise);
        ActionSimple action2 = new ActionSimple("Action 2", 20, 250.00, entreprise);
        // Ajouter les actions au portefeuille
        portefeuille.acheter(action1, 10);
        portefeuille.acheter(action2, 5);
    }

    /**
     * Test de la méthode consulterActionsAchetees.
     */
    @Test
    public void testConsulterActionsAchetees() {
        // Créer une map d'actions attendues avec leurs quantités détenues
        Map<Action, Integer> expectedActions = new HashMap<>();
        expectedActions.put(new ActionSimple("Action 1", 10, 100.00), 10);
        expectedActions.put(new ActionSimple("Action 2", 20, 250.00), 5);

        // Appeler la méthode pour consulter les actions achetées
        gestionnaire.consulterActionsAchetees(portefeuille);

        // Vérifier que les actions et quantités détenues correspondent aux attentes
        Map<Action, LignePortefeuille> mapLignes = portefeuille.getMapLignes();
        for (Map.Entry<Action, Integer> entry : expectedActions.entrySet()) {
            Action expectedAction = entry.getKey();
            int expectedQuantity = entry.getValue();

            assertTrue(mapLignes.containsKey(expectedAction));
            assertEquals(expectedQuantity, mapLignes.get(expectedAction).getQte());
        }
    }
    
}
