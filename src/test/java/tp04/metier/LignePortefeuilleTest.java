/*
 * Copyright 2024 widad.
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

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author widad
 */
public class LignePortefeuilleTest {
     @Test
    void testConstructeur() {
        ActionSimple action = new ActionSimple();
        int qteAttendue = 10;

        LignePortefeuille lignePortefeuille = new LignePortefeuille(action, qteAttendue);

        assertEquals(action, lignePortefeuille.getAction());
        //assertEquals(qteAttendue, lignePortefeuille.getQte());
        assertEquals(0, lignePortefeuille.getClients().size()); // Aucun client associé
    }

    @Test
    void testGettersSetters() {
        ActionSimple action = new ActionSimple();
          
        LignePortefeuille lignePortefeuille = new LignePortefeuille(action, 10);
        int qteAttendue = 20;
        double prixAttendu = 50.0;
        List<Client> clientsAttendus = new ArrayList<>();
        String resultatToString;


        lignePortefeuille.setQte(qteAttendue);
        lignePortefeuille.setPrix(prixAttendu);
        clientsAttendus.add(new Client("ClientTest"));
        lignePortefeuille.addClient(new Client("ClientTest"));
        
        resultatToString = lignePortefeuille.toString();
                
        assertEquals(Integer.toString(qteAttendue), resultatToString);
        assertEquals(qteAttendue, lignePortefeuille.getQte());
        assertEquals(prixAttendu, lignePortefeuille.getPrix());
        assertEquals(clientsAttendus.size(), lignePortefeuille.getClients().size());
        assertEquals(clientsAttendus.get(0).getNom(), lignePortefeuille.getClients().get(0).getNom());
    }
}
