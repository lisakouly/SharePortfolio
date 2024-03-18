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
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author mazhu
 */
public class ClientTest {
    
    @Test
    void testAddPortefeuilleAndGetTotalPortfolioValue() {

        Client client = new Client();


        Portefeuille portefeuille1 = new Portefeuille();
        Portefeuille portefeuille2 = new Portefeuille();


        client.addPortefeuille(portefeuille1);
        client.addPortefeuille(portefeuille2);


        Jour j = new Jour();


        portefeuille1.acheter(new ActionSimple("pll"), 10); // Assume 10 actions are added
        portefeuille2.acheter(new ActionComposee("CJS"), 20); // Assume 20 actions are added

        assertEquals(2, client.getPortefeuilles().size());


        float totalValueActionSimple = 10 * new ActionSimple("ActionSimple").valeur(j);

        float totalValueActionComposee = 20 * new ActionComposee("ActionComposee").valeur(j);

        float expectedTotalValue = totalValueActionSimple + totalValueActionComposee;

        assertEquals(expectedTotalValue, client.getTotalPortfolioValue(j), 0.01);
    }

    @Test
    void testGetAccountBalance() {

        Client client = new Client();
        client.setCapital(1000.0f); 
        Jour j = new Jour(2022, 4); 
        Portefeuille portefeuille1 = new Portefeuille();
        Portefeuille portefeuille2 = new Portefeuille();
        client.addPortefeuille(portefeuille1);
        client.addPortefeuille(portefeuille2);
        portefeuille1.acheter(new ActionSimple("Action 1"), 500); 
        portefeuille2.acheter(new ActionSimple("Action 2"), 300);


        float totalPortfolioValue = portefeuille1.valeur(j) + portefeuille2.valeur(j);


        float expectedBalance = client.getCapital() - totalPortfolioValue;


        Float actualBalance = client.getAccountBalance(j);


        Assertions.assertEquals(expectedBalance, actualBalance, 0.01f);
    }
    
}
