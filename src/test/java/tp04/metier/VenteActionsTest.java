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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VenteActionsTest {
    private Portefeuille portefeuille;

    @BeforeEach
    public void setUp() {
        portefeuille = new Portefeuille();
        // Ajouter des actions au portefeuille
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00);
        portefeuille.acheter(action1, 10);
        // Vous pouvez ajouter d'autres actions au besoin
    }

    @Test
    public void testVenteAction() {
        // Création d'une liste d'actions disponibles
        List<Action> availableActions = new ArrayList<>();
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00);
        availableActions.add(action1);

        // Mise à jour de la liste des actions disponibles dans le portefeuille
        portefeuille.setAvailableActions(availableActions);

        // Appel de la méthode vendreActionSimple de la classe ActionSimple
        action1.vendreActionSimple(portefeuille, action1, 10);
        // Vérification que la quantité disponible a été mise à jour dans le portefeuille
        assertEquals(0, portefeuille.getQuantite(action1));
        // Vérification que la quantité disponible a été mise à jour dans l'action
        assertEquals(20, action1.getQuantite());
    }
}
