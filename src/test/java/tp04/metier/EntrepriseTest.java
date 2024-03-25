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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Imane
 */
public class EntrepriseTest {
    private Entreprise entreprise;

    @BeforeEach
    public void setUp() {
        entreprise = new Entreprise("NomEntreprise", 1000, 500);
    }

    @Test
    public void testGetNom() {
        assertEquals("NomEntreprise", entreprise.getNom());
    }

    @Test
    public void testSetNom() {
        entreprise.setNom("NewNom");
        assertEquals("NewNom", entreprise.getNom());
    }

    @Test
    public void testGetNombreActionsTotal() {
        assertEquals(1000, entreprise.getNombreActionsTotal());
    }

    @Test
    public void testSetNombreActionsTotal() {
        entreprise.setNombreActionsTotal(2000);
        assertEquals(2000, entreprise.getNombreActionsTotal());
    }

    @Test
    public void testGetPalierBlocage() {
        assertEquals(500, entreprise.getPalierBlocage());
    }

    @Test
    public void testSetPalierBlocage() {
        entreprise.setPalierBlocage(1000);
        assertEquals(1000, entreprise.getPalierBlocage());
    }
}
