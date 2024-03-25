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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class ActionSimpleTest {
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
    }
}
