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
 * Représente un client qui possède un ou plusieurs portefeuilles d'actions.
 * Un client peut acheter, vendre et gérer des actions dans ses portefeuilles.
 * Le client peut également consulter son capital et son solde de compte pour une journée donnée.
 * @author Zhuo,Yaning
 */
public class Client {
    private List<Portefeuille> portefeuilles;
    private Float capital;
    private LocalDate birthDate;
    private String nom;

    /**
     * Constructeur par défaut de la classe Client.
     * Initialise la liste des portefeuilles du client.
     */
    public Client() {
        this.portefeuilles = new ArrayList<>();
    }

    /**
     * Obtient le capital du client.
     * @return le capital du client
     */
    public Float getCapital() {
        return capital;
    }

    /**
     * Définit le capital du client.
     * @param capital le capital du client à définir
     */
    public void setCapital(Float capital) {
        this.capital = capital;
    }

    /**
     * Ajoute un portefeuille à la liste des portefeuilles du client.
     * Vérifie d'abord si la valeur totale des portefeuilles est supérieure à zéro.
     * @param portefeuille le portefeuille à ajouter
     * @return true si le portefeuille est ajouté avec succès, sinon false
     */
    public boolean addPortefeuille(Portefeuille portefeuille) {
        LocalDate dateDuJour = LocalDate.now();
        int noJour = dateDuJour.getDayOfYear();
        int annee = dateDuJour.getYear();
        Jour j = new Jour(annee, noJour);
        if (getTotalPortfolioValue(j) > 0) {
            this.portefeuilles.add(portefeuille);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcule la valeur totale du portefeuille d'actions du client pour un jour donné.
     * Parcourt tous les portefeuilles et additionne leur valeur individuelle pour obtenir la valeur totale.
     * @param j l'objet Jour représentant la date
     * @return la valeur totale du portefeuille d'actions à la date spécifiée
     */
    public float getTotalPortfolioValue(Jour j) {
        float totalValue = 0;
        for (Portefeuille portefeuille : portefeuilles) {
            totalValue += portefeuille.valeur(j);
        }
        return totalValue;
    }

    /**
     * Obtient la liste des portefeuilles du client.
     * @return la liste des portefeuilles du client
     */
    public List<Portefeuille> getPortefeuilles() {
        return portefeuilles;
    }

    /**
     * Obtient le solde du compte du client pour un jour donné.
     * Calcule la différence entre le capital du client et la valeur totale de son portefeuille d'actions.
     * @param j l'objet Jour représentant la date
     * @return le solde du compte du client pour la date spécifiée
     */
    public Float getAccountBalance(Jour j) {
        float totalPortfolioValue = 0;
        for (Portefeuille portefeuille : portefeuilles) {
            totalPortfolioValue += portefeuille.valeur(j);
        }
        return capital - totalPortfolioValue;
    }

    /**
     * Constructeur de la classe Client avec une date de naissance.
     * @param year l'année de naissance du client
     * @param month le mois de naissance du client
     * @param day le jour de naissance du client
     */
    public Client(int year, int month, int day) {
        if (dateNaissanceConforme(year, month, day)) {
            LocalDate birthdate = LocalDate.of(year, month, day);
            if (estMajeur(birthdate)) {
                this.birthDate = birthdate;
            }
        }
    }
   
    /**
     * Vérifie si le client est majeur.
     * @param birthDate la date de naissance du client
     * @return true si le client est majeur, sinon false
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
     * Fonction pour vérifier si la date de naissance est conforme.
     * Vérifie si l'année est supérieure à 1900, si le mois est entre 1 et 12, et si le jour est entre 1 et 31.
     * @param year l'année de naissance
     * @param month le mois de naissance
     * @param day le jour de naissance
     * @return true si la date de naissance est valide, sinon false
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
        System.out.println("Syntaxe de la date de naissance valide");
        return true;
    }
    
    /**
     * Obtient la date de naissance du client.
     * @return la date de naissance du client
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    /**
     * Modifie la date de naissance du client.
     * @param birthDate la nouvelle date de naissance à définir
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" + "birthDate=" + birthDate + '}';
    }    
    
    // Constructeur
    /**
     * Constructeur de la classe Client.
     * @param nom le nom du client
     */
    public Client(String nom) {
        this.nom = nom;
    }

    // Méthodes
    /**
     * Obtient le nom du client.
     * @return le nom du client
     */
    public String getNom() {
        return this.nom;
    }
}


