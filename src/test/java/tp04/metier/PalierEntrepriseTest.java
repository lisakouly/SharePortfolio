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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Imane
 */

public class PalierEntrepriseTest {
      private Portefeuille portefeuille;
    private Entreprise entreprise;

    @BeforeEach
    public void setUp() {
        entreprise = new Entreprise("Entreprise A", 1000, 50); // Nom, nombre d'actions total, palier de blocage
        portefeuille = new Portefeuille();
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00, entreprise);
        ActionSimple action2 = new ActionSimple("Action 2", 20, 250.00, entreprise);
        portefeuille.acheter(action1, 10);
        portefeuille.acheter(action2, 10);
    }

    @Test
    public void testBlocageVenteAction() {
        // Vérifier que la vente d'une quantité inférieure ou égale au palier de blocage est autorisée
        ActionSimple action1 = new ActionSimple("Action 1", 10, 100.00, entreprise);
        portefeuille.vendreEntreprise(action1, 10);
        assertEquals(0, portefeuille.getQuantite(action1));
 

        // Vérifier que la vente d'une quantité supérieure au palier de blocage est bloquée
        ActionSimple action2 = new ActionSimple("Action 2", 20, 250.00, entreprise);
        portefeuille.vendreEntreprise(action2, 50); // Tentative de vente de 30 actions
        assertEquals(10, portefeuille.getQuantite(action2)); // La quantité de vente est bloquée à 20
    }
}