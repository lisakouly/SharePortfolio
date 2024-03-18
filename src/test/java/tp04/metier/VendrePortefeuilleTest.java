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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mazhuo
 */
public class VendrePortefeuilleTest {
    
    Portefeuille por = new Portefeuille("p1");
    ActionSimple a1 = new ActionSimple("pll");
    ActionComposee a2 = new ActionComposee("CJS");
    
    /**
    * Test la méthode vendrePortefeuille de la classe Portefeuille,
    * qui vend toutes les actions d'un portefeuille spécifié et mise à jour la quantité vendue
    * à chaque action correspondante.
    * @author Zhuo,Yaning
    */
    @Test
    protected void testVendrePortefeuille(){
        // Arrange
        int a1Qte = a1.getQuantite();
        int a2Qte = a2.getQuantite();
        por.acheter(a1, 10); 
        por.acheter(a2, 20); 
        
        // Act
        por.vendrePortefeuille("p1");
        int a1QteAfter = a1.getQuantite();
        int a2QteAfter = a2.getQuantite();
        
        // Assert
        Assertions.assertEquals(a1Qte + 10, a1QteAfter, "Le nombre d'a1 augmenté");
        Assertions.assertEquals(a2Qte + 20, a2QteAfter, "Le nombre d'a2 devrait être augmenté");
        Assertions.assertTrue(por.getMapLignes().isEmpty(), "MapLignes doivent être vidées");
    
    }
    
}
