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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mazhuo
 */
public class GetAvailableComposedActionsTest {
    
    @Test
    protected void testGetAvailableComposedActions() {
        // Arrange
        List<Action> actions = new ArrayList<>();
        Gestionnaire gestionnaire = new Gestionnaire();
        
        ActionComposee franceTelevision = new ActionComposee("France télévision");
        
        ActionSimple france2 = new ActionSimple("France 2");
        ActionSimple france3 = new ActionSimple("France 3");
        ActionSimple france5 = new ActionSimple("France 5");
        
        franceTelevision.enrgComposition(france2, 0.35f);
        franceTelevision.enrgComposition(france3, 0.50f);
        franceTelevision.enrgComposition(france5, 0.15f);
        
        actions.add(franceTelevision);
        final String expectedMessage = "France télévision";
        
         // Act
        List<ActionComposee> composedActions = gestionnaire.getAvailableComposedActions(actions);
         final String currentMessage = composedActions.get(0).getLibelle();
        
        // Assert
        Assertions.assertTrue(!composedActions.isEmpty(), "Il doit y avoir au moins une action composée");
        Assertions.assertEquals(expectedMessage, currentMessage, "Error: Get Action composée");
    }
}
