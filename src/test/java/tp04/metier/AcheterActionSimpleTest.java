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
 *
 * @author widad
 */
public class AcheterActionSimpleTest {
     @Test
    public void testAcheterAction() {
        // Création d'une liste d'actions disponibles
        List<Action> availableActions = new ArrayList<>();
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00);
        ActionSimple action2 = new ActionSimple("Action 2", 20, 250.00);
        availableActions.add(action1);
        availableActions.add(action2);

        // Création d'un portefeuille
        Portefeuille portfolio = new Portefeuille();
        // Mise à jour de la liste des actions disponibles dans le portefeuille
        portfolio.setAvailableActions(availableActions);
        // Acheter l'action
        action1.acheterActionSimple(action1, 5);
        
        // Vérifier que la quantité disponible a été mise à jour dans la liste availableActions
        System.out.println (action1.getQuantite());
        
        int quantite = action1.getQuantite(); 
        
         System.out.println (action1.soustraireQuantite(5));

        // Vérifier que la quantité disponible a été mise à jour dans l'action
        assertEquals(5, action1.getQuantite());
        
        // Vérifier que la quantité disponible a été mise à jour dans la liste availableActions

        assertEquals(5, portfolio.getAvailableActions().get(0).getQuantite());

        
        
    }

    
}
