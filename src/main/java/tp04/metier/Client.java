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
       if (dateNaissanceConforme(year,month,day) == true) {
           LocalDate birthdate = LocalDate.of(year, month, day); 
           if (estMajeur(birthdate) == true) {
               this.birthDate = birthdate;
           }
       }
    }
   
    /**
     * Fonction pour vérifier si le client est majeur ou non
     * @param birthDate
     * @return 
     */
    public boolean estMajeur(LocalDate birthDate) {
        LocalDate todayDate = LocalDate.now();
        
        // Calcul de l'âge en années
        int age = todayDate.getYear() - birthDate.getYear();
        
        if ((birthDate.getMonthValue() > todayDate.getMonthValue()) || 
           ((birthDate.getMonthValue() == todayDate.getMonthValue()) && 
            (birthDate.getDayOfMonth() > todayDate.getDayOfMonth()))) {
            age--;
        }
        
        if (age >= 18) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Fonction pour vérifier si la date de naissance est valide ou non
     * @param year
     * @param month
     * @param day
     * @return true si la date de naissance est valide et false si invalide
     */
    public boolean dateNaissanceConforme(int year, int month, int day) {
        if (year < 1900) {
            System.out.println("Le client doit avoir une année de naissance valide");
            return false;
        }
        if ((month > 12) || (month < 1)) {
            System.out.println("Le client doit avoir un mois de naissance valide");
            return false;
        }
        if ((day > 31) || (day < 1)) {
            System.out.println("Le client doit avoir un jour de naissance valide");
            return false;
        }
        System.out.println("Client créé avec succès");
        return true;
    }
    
    /**
     * @author Lisa
     * Récuperation de la date de naissance d'un client donné
     * @return LocalDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    /**
     * @author Lisa
     * Modification de la date de naissance d'un client donné
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" + "birthDate=" + birthDate + '}';
    }    
}
