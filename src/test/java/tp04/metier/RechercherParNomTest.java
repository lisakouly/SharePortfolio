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
public class RechercherParNomTest {
     @Test
    public void testRechercherParNom() {
        List<Action> availableActions = new ArrayList<>();

        // Création de quelques actions simples pour le test
        ActionSimple action1 = new ActionSimple("Google", 100, 150.0);
        ActionSimple action2 = new ActionSimple("Microsoft", 200, 200.0);
        ActionSimple action3 = new ActionSimple("Apple", 150, 180.0);
        ActionSimple action4 = new ActionSimple("Amazon", 300, 300.0);

        // Création d'une instance d'ActionSimple
        ActionSimple actionSimple = new ActionSimple();
        
        
        // Ajout des actions à la liste availableActions
        availableActions.add(action1);
        availableActions.add(action2);
        availableActions.add(action3);
        availableActions.add(action4);

        System.out.println("Actions disponibles : " + availableActions);

        // Affectation de la Map des actions disponibles à l'instance d'ActionSimple
       actionSimple.setAvailableActions(availableActions);

        // Test 1 : Vérifie que la recherche renvoie une liste vide lorsque aucun nom correspondant n'est trouvé
        List<ActionSimple> resultatsRecherche1 = actionSimple.rechercherParNom("Introuvable");
        System.out.println("Résultat du test 1 : " + resultatsRecherche1);
        assertEquals(0, resultatsRecherche1.size(), "La recherche avec un nom introuvable doit renvoyer une liste vide");

        // Test 2 : Vérifie que la recherche renvoie une liste contenant une seule action lorsque le nom recherché correspond à celui d'une action
        List<ActionSimple> resultatsRecherche2 = actionSimple.rechercherParNom("Google");
        System.out.println("Résultat du test 2 : " + resultatsRecherche2);
        assertEquals(1, resultatsRecherche2.size(), "La recherche avec un nom correspondant exactement à une action doit renvoyer une liste contenant cette action");

        // Test 3 : Vérifie que la recherche renvoie une liste contenant plusieurs actions lorsque le nom recherché correspond au début de plusieurs noms d'actions
        List<ActionSimple> resultatsRecherche3 = actionSimple.rechercherParNom("A");
        System.out.println("Résultat du test 3 : " + resultatsRecherche3);
        assertEquals(2, resultatsRecherche3.size(), "La recherche avec un nom correspondant au début de plusieurs actions doit renvoyer une liste contenant toutes ces actions");

        // Test 4 : Vérifie que la recherche ne prend pas en compte les minuscules majuscules en comparant les noms
        List<ActionSimple> resultatsRecherche4 = actionSimple.rechercherParNom("aPpLe");
        System.out.println("Résultat du test 4 : " + resultatsRecherche4);
        assertEquals(1, resultatsRecherche4.size(), "La recherche doit ignorer les minuscules/majuscules lors de la comparaison des noms");
    }
}
