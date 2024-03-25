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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

/**
 *Test class for the ActionSimple class.
 * @author zhuo,yaning
 */
public class ActionSimpleTest {
    
    ActionSimple france2 = new ActionSimple("France 2");
    
    /**
    * Teste la méthode enrgCours() pour vérifier si elle enregistre correctement les cours des actions à des dates spécifiques.
    * <p>
    * Ce test suit plusieurs étapes :
    * 1. Enregistrement d'un premier cours pour une date donnée
    * 2. Tentative d'enregistrement d'un nouveau cours pour la même date, vérifiant qu'il n'écrase pas le cours existant.
    * 3. Enregistrement d'un cours pour une nouvelle date et vérification de ce nouvel enregistrement.
    * </p>
    */
    @Test 
    void testEnrgCours() {
        
        /**Arrange*/
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
    
    @Test
    void testSetPourcentageMaxVente() {
        
        /** 1. Définissez un pourcentage de vente valide et vérifiez que la configuration a réussi */
        france2.setPourcentageMaxVente(66.6);
        Assertions.assertEquals(66.6, france2.getPourcentageMaxVente(), "Le pourcentage maximal de vente devrait être 66.6");
        
        /** 2. Essayez de définir un pourcentage des ventes inférieur à 0 et d’intercepter les exceptions */
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            france2.setPourcentageMaxVente(-1.1);
        });
        Assertions.assertEquals("Le pourcentage doit être compris entre 0 et 100", exception1.getMessage(), "IllegalArgumentException : le message correct");
        
        /** 3. Essayez de définir un pourcentage de ventes supérieur à 100 et d’intercepter les exceptions */
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            france2.setPourcentageMaxVente(101.0);
        });
        Assertions.assertEquals("Le pourcentage doit être compris entre 0 et 100", exception2.getMessage(), "IllegalArgumentException : le message correct");

/*import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Imane
 */
/*public class ActionSimpleTest {
    private ActionSimple actionSimple;

    @BeforeEach
    public void setUp() {
        actionSimple = new ActionSimple("ActionTest", 100, 50);
    }

    @Test
    public void testConstructor() {
        assertEquals("ActionTest", actionSimple.getLibelle());
        assertEquals(100, actionSimple.getQuantite());
        assertEquals(50, actionSimple.getPrixAction());
        assertNotNull(actionSimple.getMapCours());
        assertTrue(actionSimple.getMapCours().isEmpty());
        assertNotNull(actionSimple.getAvailableActions());
        assertTrue(actionSimple.getAvailableActions().isEmpty());
    }

    @Test
    public void testEnrgCours() {
        actionSimple.enrgCours(new Jour(2024, 3, 19), 60.0f);
        Map<Jour, Cours> expectedMap = new HashMap<>();
        expectedMap.put(new Jour(2024, 3, 19), new Cours(new Jour(2024, 3, 19), 60.0f));
        assertEquals(expectedMap, actionSimple.getMapCours());
    }

    @Test
    public void testValeur() {
        actionSimple.enrgCours(new Jour(2024, 3, 19), 60.0f);
        assertEquals(60.0f, actionSimple.valeur(new Jour(2024, 3, 19)));
    }

    @Test
    public void testAcheterActionSimple() {
        Portefeuille portfolio = new Portefeuille();
        portfolio.acheter(actionSimple, 10);
        assertEquals(10, portfolio.getQuantite(actionSimple));
        assertEquals(90, actionSimple.getQuantite());
    }

    @Test
    public void testVendreActionSimple() {
        Portefeuille portfolio = new Portefeuille();
        portfolio.acheter(actionSimple, 100);
        assertEquals(100, portfolio.getQuantite(actionSimple));
        assertEquals(0, actionSimple.getQuantite());

        portfolio.vendre(actionSimple, 50);
        assertEquals(50, portfolio.getQuantite(actionSimple));
        assertEquals(50, actionSimple.getQuantite());
    }*/
}
