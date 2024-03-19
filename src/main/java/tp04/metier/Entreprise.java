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

/**
 * Cette classe représente une entreprise.
 * @author widad
 */
public class Entreprise {
    // Variables d'instance
    private String nom;
    private int nombreActionsTotal;
    private int palierBlocage;

    // Constructeur
    /**
     * Constructeur de la classe Entreprise.
     * @param nom le nom de l'entreprise
     * @param nombreActionsTotal le nombre total d'actions de l'entreprise
     * @param palierBlocage le palier de blocage des actions de l'entreprise
     */
    public Entreprise(String nom, int nombreActionsTotal, int palierBlocage) {
        this.nom = nom;
        this.nombreActionsTotal = nombreActionsTotal;
        this.palierBlocage = palierBlocage;
    }

    // Getters et setters
    /**
     * Méthode pour obtenir le nom de l'entreprise.
     * @return le nom de l'entreprise
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour définir le nom de l'entreprise.
     * @param nom le nom de l'entreprise
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour obtenir le nombre total d'actions de l'entreprise.
     * @return le nombre total d'actions de l'entreprise
     */
    public int getNombreActionsTotal() {
        return nombreActionsTotal;
    }

    /**
     * Méthode pour définir le nombre total d'actions de l'entreprise.
     * @param nombreActionsTotal le nombre total d'actions de l'entreprise
     */
    public void setNombreActionsTotal(int nombreActionsTotal) {
        this.nombreActionsTotal = nombreActionsTotal;
    }

    /**
     * Méthode pour obtenir le palier de blocage des actions de l'entreprise.
     * @return le palier de blocage des actions de l'entreprise
     */
    public int getPalierBlocage() {
        return palierBlocage;
    }

    /**
     * Méthode pour définir le palier de blocage des actions de l'entreprise.
     * @param palierBlocage le palier de blocage des actions de l'entreprise
     */
    public void setPalierBlocage(int palierBlocage) {
        this.palierBlocage = palierBlocage;
    }  
}
