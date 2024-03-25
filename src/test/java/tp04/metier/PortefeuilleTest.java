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

    private Portefeuille portefeuille;
    private ActionSimple actionSimple;

    @Before
    public void setUp() {
        portefeuille = new Portefeuille();
        actionSimple = new ActionSimple("ActionTest", 100, 50.0);
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
    public void testToString() {
        portefeuille.acheter(actionSimple, 100);
        String expected = "{" + actionSimple.toString() + "=" + new LignePortefeuille(actionSimple, 100) + "}";
        assertEquals(expected, portefeuille.toString());
    }
}
