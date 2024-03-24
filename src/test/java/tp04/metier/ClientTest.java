/*
 * Copyright 2024 mazhuo.
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
 * Cette classe contient les tests unitaires pour la classe Client.
 * @author zhuo,Yaning
 */
public class ClientTest {
    
    /**
     * Méthode de test pour vérifier le calcul de la valeur totale du portefeuille.
     */
    @Test
    void testGetTotalPortfolioValue() {
        //Arrange
        Client client = new Client();
        Portefeuille portefeuille1 = new Portefeuille();
        Portefeuille portefeuille2 = new Portefeuille(); 
        Jour j = new Jour();
    
        ActionSimple as1 = new ActionSimple("pll",1, 33.0);
        ActionSimple as2 = new ActionSimple("p12",1, 22.0);
        ActionComposee ac1 = new ActionComposee("ac1");
        ac1.enrgComposition(as2, 0.65f);
        ac1.enrgComposition(as1, 0.35f);
        
        // Achat de 10 actions simples dans le premier portefeuille
        portefeuille1.acheter(as1, 10); 
        // Ajout du premier portefeuille au client
        client.addPortefeuille(portefeuille1);
        portefeuille2.acheter(ac1, 20);
        client.addPortefeuille(portefeuille2);
        
         // Calcul de la valeur totale des actions simples dans le premier portefeuille
        float totalValueActionSimple = 10 * as1.valeur(j);
        // Calcul de la valeur totale des actions composées dans le deuxième portefeuille
        float totalValueActionComposee = 20 * ac1.valeur(j);
        // Calcul de la valeur totale attendue du portefeuille
        float expectedTotalValue = totalValueActionSimple + totalValueActionComposee;
        
        // Vérification que la valeur totale du portefeuille est correcte
        assertEquals(expectedTotalValue, client.getTotalPortfolioValue(j), 0.01);
        
    }
    
    /**
     * Méthode de test pour vérifier le solde du compte du client.
     * @author yaning
     */
    @Test
    void testGetAccountBalance() {
        // Création d'un client
        Client client = new Client();
        // Configuration du capital du client
        client.setCapital(1000.0f); 
        // Définition de la date pour la valorisation des portefeuilles
        Jour j = new Jour(2022, 4); 
        // Création de deux portefeuilles pour le client
        Portefeuille portefeuille1 = new Portefeuille();
        Portefeuille portefeuille2 = new Portefeuille();
        // Ajout des portefeuilles au client
        client.addPortefeuille(portefeuille1);
        client.addPortefeuille(portefeuille2);
        // Achat d'actions dans les portefeuilles
        portefeuille1.acheter(new ActionSimple("Action 1"), 500); 
        portefeuille2.acheter(new ActionSimple("Action 2"), 300);
        
        // Calcul de la valeur totale des portefeuilles
        float totalPortfolioValue = portefeuille1.valeur(j) + portefeuille2.valeur(j);

        // Calcul du solde attendu du compte du client
        float expectedBalance = client.getCapital() - totalPortfolioValue;
        
        // Obtention du solde réel du compte du client
        Float actualBalance = client.getAccountBalance(j);
        
        // Vérification que le solde réel correspond au solde attendu avec une marge d'erreur de 0.01
        Assertions.assertEquals(expectedBalance, actualBalance, 0.01f);
    }
    
}
