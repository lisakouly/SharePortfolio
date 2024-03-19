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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

/**
 *Test class for the ActionSimple class.
 * @author zhuo,yaning
 */
public class ActionSimpleTest {
    
    @Test
    void testEnrgCours() {
        /**Arrange*/
        ActionSimple france2 = new ActionSimple("France 2");
        Jour jour1 = new Jour(2024, 3); 
        /**Enregistrer le premier prix pour le jour1*/
        france2.enrgCours(jour1, 10.5f);
        
        /** Action and  Assert*/
        /**Vérifie si la carte mapCours contient des prix enregistrés.*/
        Assertions.assertTrue(france2.getMapCours().containsKey(jour1));
        Assertions.assertEquals(10.5f, france2.getMapCours().get(jour1).getValeur(), "La valeur doit être 10.5f");
        
        /**Arrange*/
        /**Essayez d’enregistrer à nouveau le prix pour la même date et il ne devrait pas être ajouté*/
        france2.enrgCours(jour1, 15.0f);
        
        /** Action and  Assert*/
        /**Vérifiez que la carte mapCours n’a toujours qu’une seule entrée et que le prix n’a pas changé */
        Assertions.assertEquals(1, france2.getMapCours().size());
        Assertions.assertEquals(10.5f, france2.getMapCours().get(jour1).getValeur());

        Jour jour2 = new Jour(2024, 4); 

        france2.enrgCours(jour2, 12.5f);

        /**Vérifiez si la carte mapCours contient le prix du nouvel enregistrement*/
        Assertions.assertTrue(france2.getMapCours().containsKey(jour2));
        Assertions.assertEquals(12.5f, france2.getMapCours().get(jour2).getValeur(),"La valeur doit être 12.5f");
    }
}
