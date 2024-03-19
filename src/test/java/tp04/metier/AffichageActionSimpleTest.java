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
import org.junit.jupiter.api.Test;

/**
 * Cette classe teste la méthode d'affichage des actions simples.
 * Elle crée une liste d'actions disponibles, affiche les actions
 * simples et vérifie si l'affichage est correct.
 * 
 * @author widad
 */
public class AffichageActionSimpleTest {
    
    /**
     * Test de la méthode afficherActionsSimples.
     */
    @Test
    public void testAfficherActionsSimples() {
        // Création d'une liste d'actions disponibles
        List<Action> availableActions = new ArrayList<>();
        availableActions.add(new ActionSimple("Action 1", 10, 100.00));
        availableActions.add(new ActionSimple("Action 2", 20, 250.00));
        availableActions.add(new ActionSimple("Action 3", 30, 320.00));

        ActionSimple actionSimple = new ActionSimple();
        System.out.println("Test afficherActionsSimples :");
        actionSimple.afficherActionsSimples(availableActions);
    }
}
