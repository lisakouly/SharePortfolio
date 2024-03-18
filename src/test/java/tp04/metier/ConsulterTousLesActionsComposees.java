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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mazhuo
 */
public class ConsulterTousLesActionsComposees {
     /**
     * Represents a composite action for "France télévision" comprising multiple simple actions.
     */
    private static final ActionComposee franceTelevision = new ActionComposee("France télévision");
    
    /**
     * Vérifie que les actions composées sont correctement récupérées et contiennent les propriétés attendues.
     */
    @Test
    protected void testGetAllActionsComposees() {
        // Arrange
        franceTelevision.enrgComposition(ActionSimpleTest.france2, 0.35f);
        franceTelevision.enrgComposition(ActionSimpleTest.france3, 0.50f);
        franceTelevision.enrgComposition(ActionSimpleTest.france5, 0.15f);
       
        final String expectedMessage = "France télévision";
        
         // Act
        List<ActionComposee> composedActions = ActionComposee.getAllActionsComposees();
         final String currentMessage = composedActions.get(0).getLibelle();
        
        // Assert
        Assertions.assertEquals(expectedMessage, currentMessage, "Error: Get Action composée");
    }
}
