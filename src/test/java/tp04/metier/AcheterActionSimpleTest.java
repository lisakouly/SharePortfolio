/*
 * Copyright 2024 widad.
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Cette classe teste le processus d'achat d'une action simple.
 * Elle vérifie que la quantité disponible a été mise à jour correctement
 * dans l'action, dans le portefeuille et dans la liste des actions disponibles.
 * 
 * @author widad
 */
public class AcheterActionSimpleTest {
    private Portefeuille portefeuille;

    /**
     * Test de la méthode acheterActionSimple.
     */
    @Test
    public void testAcheterAction() {
        portefeuille = new Portefeuille();

        // Création d'une liste d'actions disponibles
        List<Action> availableActions = new ArrayList<>();
        ActionSimple action1 = new ActionSimple("Action 1", 20, 100.00);
        ActionSimple action2 = new ActionSimple("Action 2", 20, 250.00);
        availableActions.add(action1);
        availableActions.add(action2);
        action1.addToAvailableActions();

        // Mise à jour de la liste des actions disponibles dans le portefeuille
        portefeuille.setAvailableActions(availableActions);
        // Acheter l'action
        action1.acheterActionSimple(portefeuille, action1, 5);

        // Vérifier que la quantité disponible a été mise à jour dans l'action
        assertEquals(15, action1.getQuantite());
        
        // Vérifier que la quantité disponible a été mise à jour dans le portefeuille
        assertEquals(5, portefeuille.getQuantite(action1));

        // Vérifier que la quantité disponible a été mise à jour dans la liste availableActions
        assertEquals(15, portefeuille.getAvailableActions().get(0).getQuantite());
    }
}
