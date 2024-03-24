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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zhuo,Yaning
 */
public class ConsulterTousActComTest {
    
    @BeforeEach
    void setUp() {
        // Cette méthode est exécutée avant chaque test.
        // Elle sert à réinitialiser la liste de toutes les actions composées
        // pour garantir que chaque test démarre avec une liste vide.
        ActionComposee.clearAllActionsComposees();
    }
    /**
     * Vérifie que les actions composées sont correctement récupérées et contiennent les propriétés attendues.
     */
    @Test
    void testGetAllActionsComposees() {
        // Arrange
        ActionSimple france2 = new ActionSimple("France 2");
        ActionSimple france3 = new ActionSimple("France 3");
        ActionSimple france5 = new ActionSimple("France 5");
        ActionComposee franceTelevision1 = new ActionComposee("France télévision1");
        ActionComposee franceTelevision2 = new ActionComposee("France télévision2");
        
        franceTelevision1.enrgComposition(france2, 0.35f);
        franceTelevision1.enrgComposition(france3, 0.50f);
        franceTelevision1.enrgComposition(france5, 0.15f);
        
        franceTelevision2.enrgComposition(france3, 0.50f);
        franceTelevision2.enrgComposition(france5, 0.50f);
       
        final String expectedMessage = "France télévision1";
        
         // Act
        List<ActionComposee> composedActions = ActionComposee.getAllActionsComposees();
        final String currentMessage = composedActions.get(0).getLibelle();
        
        // Assert
        // Vérification de la taille de la liste des actions composées
        Assertions.assertEquals(2, composedActions.size());
        // Vérification du libellé de la première action composée
        Assertions.assertEquals(expectedMessage, currentMessage, "Error: Get Action composée");
    }
}
