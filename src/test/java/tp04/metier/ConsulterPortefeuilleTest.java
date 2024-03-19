/*
 * Copyright 2024 Yassine Alouini.
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

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Yassine Alouini
 */
public class ConsulterPortefeuilleTest {

    @Test
    public void testConsultationPortefeuille() {
        System.out.println("Début du Test");
        Portefeuille portefeuille = new Portefeuille("Mon Portefeuille");

        Action action1 = new ActionSimple("Action1") {
            @Override
            public float valeur(Jour j) {
                return 10;
            }
        };

        Action action2 = new ActionComposee("Action2") {
            @Override
            public float valeur(Jour j) {
                return 20 * 5;
            }
        };

        portefeuille.acheter(action1, 5);
        portefeuille.acheter(action2, 2);
        
        ConsulterPortefeuille.consulterPortefeuille(portefeuille);
        System.out.println("Fin du Test");
    }
}

