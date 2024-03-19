/*
 * Copyright 2024 Nathan.
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

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test de la fonction d'ajout d'un portefeuille dans une liste de portefeuille client
 * @author Nathan
 */
public class AjouterPortefeuilleTest {
    
     @Test
    protected void testAddPortefeuille() {
        //Arrange
        Portefeuille p1 = new Portefeuille("PortefeuilleTest");
        Client c1 = new Client();
        
        //Action
        c1.addPortefeuille(p1);
        boolean status = true;
        if (c1.getPortefeuilles().contains(p1)) {
            status = true;
        }
       
        //Assert
        assertTrue(status, "Le portefeuille ajouté n'est pas présent dans la liste des portefeuilles du client");
    }
    
     @Test
    protected void testPortefeuilleNegatif() {
        //Arrange
        float valeurAction = -50;
        Portefeuille p2 = new Portefeuille("PortefeuilleTest2");
        ActionSimple a1 = new ActionSimple("ActionTest");
        Jour j1 = new Jour(1999, 30);
        
        Client c2 = new Client();
        
        //Action
        a1.enrgCours(j1, valeurAction);
        p2.acheter(a1, 5);
        boolean status = c2.addPortefeuille(p2);
      
        //Assert
        assertTrue(status, "Le portefeuille ne peut pas detenir d'actions lorsque sa valeur est négative");
    }
}