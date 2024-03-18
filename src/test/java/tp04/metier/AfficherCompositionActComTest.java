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

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Classe de test permettant de valider la fonction de requête de composition pour les comportements composites.
 * @author zhuo,Yaning
 */
public class AfficherCompositionActComTest {
    
    @Test
    protected void testGetAllActionsComposees() {
        // Arrange
        ActionSimple as1 = new ActionSimple("Action 1");
        ActionSimple as2 = new ActionSimple("Action 2");

        ActionComposee ac1 = new ActionComposee("Composed Action 1");
        ac1.enrgComposition(as1, 0.6f); // 60%的Action 1
        ac1.enrgComposition(as2, 0.4f); // 40%的Action 2

        // Act
        Map<String, Float> composition = ActionComposee.getComposition("Composed Action 1");

        // Assert
        Assertions.assertNotNull(composition, "La composition doit être présente");
        Assertions.assertEquals(2, composition.size(), "Il doit y avoir deux comportements");
        Assertions.assertEquals(0.6f, composition.get("Action 1"), 0.0001, "Action 1，0.6");
        Assertions.assertEquals(0.4f, composition.get("Action 2"), 0.0001, "Action 2，0.4");

    }
}
