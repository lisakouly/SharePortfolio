/*
 * Copyright 2024 mazhu.
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
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
/**
 *
 * @author zhuo,yaning

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author widad
 */
public class GestionnaireTest {
    
    @Test
    void testEstClientSolvable() {
         
        /**Arrange*/
        Client client = new Client();
        client.setCapital(2000.0f);

        Jour j = new Jour(2024, 3);

        Portefeuille portefeuille1 = new Portefeuille();
        Portefeuille portefeuille2 = new Portefeuille();

        client.addPortefeuille(portefeuille1);
        client.addPortefeuille(portefeuille2);

        portefeuille1.acheter(new ActionSimple("Action 1"), 500);
        portefeuille2.acheter(new ActionSimple("Action 2"), 300);

        Action action = new ActionSimple("Action 3");
        
        /** Act */
        Gestionnaire gestionnaire = new Gestionnaire();
        boolean solvable = gestionnaire.estClientSolvable(client, j, action, 100000);
        
         /** Assert
          * Vérification que le client est solvable
          */
        Assertions.assertTrue(solvable);
    }
    void testConstructeurParDefaut() {
        Gestionnaire gestionnaire = new Gestionnaire();

        // Verifie que les attributs sont initialisés à null
        assertEquals(null, gestionnaire.getNom());
        assertEquals(null, gestionnaire.getPrenom());
    }

    @Test
    void testConstructeurAvecParametres() {
        // Arrange
        String nom = "Nom";
        String prenom = "Prénom";
        
        // Act
        Gestionnaire gestionnaire = new Gestionnaire(nom, prenom);

        // Assert
        assertEquals(nom, gestionnaire.getNom());
        assertEquals(prenom, gestionnaire.getPrenom());
    }
    
    @Test
    void testGetterSetterNom() {
        // Arrange
        Gestionnaire gestionnaire = new Gestionnaire();
        String nom = "NomTest";
        
        // Act
        gestionnaire.setNom(nom);

        // Assert
        assertEquals(nom, gestionnaire.getNom());
    }
    
    @Test
    void testGetterSetterPrenom() {
        Gestionnaire gestionnaire = new Gestionnaire();
        String prenom = "PrénomTest";
        
        gestionnaire.setPrenom(prenom);

        assertEquals(prenom, gestionnaire.getPrenom());
    }
    
}
