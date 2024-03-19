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
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ActionnaireMajoritaireTest {
        
    private ActionSimple action;
    private Portefeuille portefeuille;
    
    @BeforeEach
    public void setUp() {
        // Création d'une action avec des clients associés
        action = new ActionSimple("Action 1", 0, 0.0);
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        Client client3 = new Client("Client 3");
        // Ajout des clients à l'action
        action.addClient(client1);
        action.addClient(client2);
        action.addClient(client3);
        // Création du portefeuille
        portefeuille = new Portefeuille();
        // Achat d'actions dans le portefeuille pour les clients
        portefeuille.acheter(action, 10, client1);
        portefeuille.acheter(action, 15, client2);
        portefeuille.acheter(action, 5, client3);
    }

    @Test
    public void testActionnaireMajoritaire() {
        // Appel de la méthode à tester
        Client actionnaireMajoritaire = portefeuille.actionnaireMajoritaire(action);

        System.out.println("ActionnaireMajoritaire : "+ actionnaireMajoritaire.getNom());
        
        // Vérifier que le client n'est pas null
        assertNotNull(actionnaireMajoritaire, "Le client actionnaire majoritaire ne doit pas être null.");

        // Vérifier que le client retourné est bien celui qui détient le maximum d'actions
        assertEquals("Client 2", actionnaireMajoritaire.getNom());
    }
}