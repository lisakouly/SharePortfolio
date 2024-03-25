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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Imane
 */

public class PortefeuilleTest {

    /*private Portefeuille portefeuille;
    private ActionSimple actionSimple;
    private Client client;

    @Before
    public void setUp() {
        portefeuille = new Portefeuille();
        actionSimple = new ActionSimple("ActionTest", 100, 50.0);
        //client = new Client("John Doe", "john.doe@example.com");
    }

    @Test
    public void testAcheter() {
        portefeuille.acheter(actionSimple, 50);
        assertEquals(50, portefeuille.getQuantite(actionSimple));
    }

    @Test
    public void testVendre() {
        portefeuille.acheter(actionSimple, 100);
        portefeuille.vendre(actionSimple, 50);
        assertEquals(50, portefeuille.getQuantite(actionSimple));
    }

    @Test
    public void testAcheterPourClient() {
        portefeuille.acheter(actionSimple, 100);
        portefeuille.acheter(actionSimple, 50, client);
        assertEquals(50, portefeuille.getQuantite(actionSimple, client));
    }

    @Test
    public void testVendreEntreprise() {
        portefeuille.acheter(actionSimple, 100);
        portefeuille.vendreEntreprise(actionSimple, 30);
        assertEquals(70, portefeuille.getQuantite(actionSimple));
    }

    @Test
    public void testValeur() {
        portefeuille.acheter(actionSimple, 100);
        float expectedValue = 100 * actionSimple.valeur(new Jour()); // Assuming Jour is properly implemented
        assertEquals(expectedValue, portefeuille.valeur(new Jour()), 0.001);
    }

    @Test
    public void testActionnaireMajoritaire() {
        portefeuille.acheter(actionSimple, 100);
        portefeuille.acheter(actionSimple, 50, client);
        assertEquals(client, portefeuille.actionnaireMajoritaire(actionSimple));
    }

    @Test
    public void testVendrePortefeuille() {
        portefeuille.acheter(actionSimple, 100);
        portefeuille.vendrePortefeuille("PortefeuilleTest");
        assertEquals(0, portefeuille.getQuantite(actionSimple));
    }

    @Test
    public void testToString() {
        portefeuille.acheter(actionSimple, 100);
        String expected = "{" + actionSimple.toString() + "=" + new LignePortefeuille(actionSimple, 100) + "}";
        assertEquals(expected, portefeuille.toString());
    }*/
}