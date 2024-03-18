/*
 * Copyright 2024 lisak.
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

 /**
  * @Test de la validité de la date de naissance d'un client à la creation d'un nouveau client
  * @Author Lisa
  * 
  */
public class ClientBirthTest {
    /** @Test de la validité de la date de naissance :
     * - le mois ou le jour n'est pas égale à zero
     * - l'année est supérieur à 1900 (sinon faux âge)
     */
    Client c1 = new Client(1900,00,00);
    
    /** @Test de la validité de la date de naissance :
     * - le mois ne dépasse pas 12
     * - le jour ne dépasse pas 31
     * - l'année est en cours ou passée
     */
    Client c2 = new Client(2025,13,35);   
    
    /** @Test que le client est majeur */
    Client c3 = new Client(2010,8,6);
}