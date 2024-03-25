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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Imane
 */
public class CoursTest {

    @Test
    public void testGetValeur() {
        Jour jour = new Jour(2024, 3);
        float valeur = 2.3F;
        Cours cours = new Cours(jour, valeur);
        assertEquals(valeur, cours.getValeur(), 0.001);
    }

    @Test
    public void testGetJour() {
        Jour jour = new Jour(2024, 3);
        float valeur = 2.3F;
        Cours cours = new Cours(jour, valeur);
        assertEquals(jour, cours.getJour());
    }

    @Test
    public void testToString() {
        Jour jour = new Jour(2024, 3);
        float valeur = 2.3F;
        Cours cours = new Cours(jour, valeur);
        String expected = "Cours{jour=" + jour + ", valeur=" + valeur + '}';
        assertEquals(expected, cours.toString());
    }
}
