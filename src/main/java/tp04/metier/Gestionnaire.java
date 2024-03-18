/*
 * Copyright 2024 mazhu.
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

/**
 *
 * @author mazhu
 */
public class Gestionnaire {
    
   //function pour connaitre toutes les actions composées disponibles
   public List<ActionComposee> getAvailableComposedActions(List<Action> actions) {
        List<ActionComposee> composedActions = new ArrayList<>();

        // Interroger la liste afficher tous les actions combinées
        for (Action action : actions) {
            if (action instanceof ActionComposee) {
                composedActions.add((ActionComposee) action);
            }
        }
        return composedActions;
    }
}
