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
import java.util.*;

import java.time.LocalDate;

/**
 *
 * @author Zhuo,Yaning
 */
public class Client {
      private List<Portefeuille> portefeuilles;
      private Float capital;


     public Client() {
        this.portefeuilles = new ArrayList<>();
    }
     
    public Float getCapital() {
            return capital;
        }

    public void setCapital(Float capital) {
        this.capital = capital;
    }
     
    /**
     * @Author Nathan / Lisa
     * Fonction pour ajouter une action à une liste d'action (portefeuille client)
     * @param portefeuille
     * @param j 
     */ 
    public boolean addPortefeuille(Portefeuille portefeuille) {
        LocalDate dateDuJour = LocalDate.now();
        int noJour = dateDuJour.getDayOfYear();
        int annee = dateDuJour.getYear();
        System.out.println(noJour+" "+annee);
        Jour j = new Jour(annee, noJour);
        if (getTotalPortfolioValue(j) > 0) {
            this.portefeuilles.add(portefeuille);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
    * Calcule la valeur totale du portefeuille d'actions pour un jour donné.
    * Parcourt tous les portefeuilles et additionne leur valeur individuelle pour obtenir la valeur totale.
    * @author yaning
    * @param j L'objet Jour représentant la date 
    * @return La valeur totale du portefeuille d'actions à la date spécifiée.
    */
    public float getTotalPortfolioValue(Jour j) {
        float totalValue = 0;
        for (Portefeuille portefeuille : portefeuilles) {
            totalValue += portefeuille.valeur(j);
        }
        return totalValue;
    }
    
    public List<Portefeuille> getPortefeuilles() {
        return portefeuilles;
    }
     
    public Float getAccountBalance(Jour j) {
        float totalPortfolioValue = 0;
        for (Portefeuille portefeuille : portefeuilles) {
            totalPortfolioValue += portefeuille.valeur(j); 
        }
        return capital - totalPortfolioValue; 
    }
    

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
            System.out.println("Client majeur");
            return true;
        }
        else {
            System.out.println("Client mineur");
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
        System.out.println("Synthaxe de la date de naissance valide");
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
    // Variables d'instance
    private String nom;
    
    // Constructeur
    /**
     * Constructeur de la classe Client.
     * @param nom le nom du client
     */
    public Client(String nom) {
        this.nom = nom;
    }

    /*Client(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    // Méthodes
    /**
     * Méthode pour obtenir le nom du client.
     * @return le nom du client
     */
    public String getNom() {
        return this.nom;
    }
}
