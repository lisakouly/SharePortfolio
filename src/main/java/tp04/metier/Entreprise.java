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
 *
 * @author widad
 */
public class Entreprise {
    private String nom;
    private int nombreActionsTotal;
    private int palierBlocage;


   public Entreprise(String nom, int nombreActionsTotal, int palierBlocage) {
        this.nom = nom;
        this.nombreActionsTotal = nombreActionsTotal;
        this.palierBlocage = palierBlocage;
    }


    // Getters et setters pour les attributs de l'entreprise

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreActionsTotal() {
        return nombreActionsTotal;
    }

    public void setNombreActionsTotal(int nombreActionsTotal) {
        this.nombreActionsTotal = nombreActionsTotal;
    }
    
     public int getPalierBlocage() {
        return palierBlocage;
    }

    public void setPalierBlocage(int palierBlocage) {
        this.palierBlocage = palierBlocage;
    }

    
}
