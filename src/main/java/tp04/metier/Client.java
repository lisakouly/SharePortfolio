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
import java.util.*;

/**
 *
 * @author mazhuo
 */
public class Client {
   
    /**
    * If a client wants to know all of the "Action Composee," 
    * they should call the following method
    * @return A list of all available "Action Composee" instances.
    */
    public List<ActionComposee> getAllComposedActions() {
         return ActionComposee.getAllActionsComposees();
    }
}
