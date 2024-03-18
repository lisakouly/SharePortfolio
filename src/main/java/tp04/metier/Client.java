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
import java.time.LocalDate;

/**
 *
 * @author mazhu
 */
public class Client {
     /**
    * @author Lisa, Nathan, Yassine
    * Date de naissance du client
    */
   private LocalDate birthDate;

    /**
     * @author Lisa, Nathan, Yassine
     * @param year
     * @param month
     * @param day 
     * Constructeur de client, retourne un client avec comme attribut une date de naissance
     */
   public Client(int year, int month, int day) {
       LocalDate todayDate = LocalDate.now();
       
       if ((month > 12) || (month < 1)) {
            try {
                this.birthDate = LocalDate.of(year, month, day); 
            }
            catch(Exception e1) {
                System.out.println("Le client doit avoir un mois de naissance valide : "+e1);
            }
        }
        if ((day > 31) || (day < 1)) {
            try {
                this.birthDate = LocalDate.of(year, month, day); 
            }
            catch(Exception e2) {
                System.out.println("Le client doit avoir un jour de naissance valide : "+e2);
            }
        }
        if (year < 1900) {
            try {
                this.birthDate = LocalDate.of(year, month, day); 
            }
            catch(Exception e3) {
                System.out.println("Le client doit avoir une année de naissance valide : "+e3);
            }
        }
    }
}
