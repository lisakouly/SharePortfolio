/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

/**
 * Cette classe représente un jour dans le système.
 * 
 * Elle contient l'année et le numéro du jour.
 * 
 * Auteur : somebody
 */
public class Jour {

    private int annee;
    private int noJour;  
   

    /**
     * Get the value of annee
     *
     * @return the value of annee
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Get the value of noJour
     *
     * @return the value of noJour
     */
    public int getNoJour() {
        return noJour;
    }

    /**
     * Constructeur avec paramètres de la classe Jour.
     * 
     * @param annee L'année du jour.
     * @param noJour Le numéro du jour.
     */
    public Jour(int annee, int noJour) {
        this.annee = annee;
        this.noJour = noJour;
    }
    /**
     * Constructeur par défaut de la classe Jour.
     */
    public Jour(){}

    /**
     * Calcule le code de hachage pour cet objet.
     * 
     * @return Le code de hachage calculé.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.annee;
        hash = 61 * hash + this.noJour;
        return hash;
    }
      /**
     * Indique si un autre objet est "égal" à celui-ci.
     * 
     * @param obj L'objet à comparer avec celui-ci.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jour other = (Jour) obj;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.noJour != other.noJour) {
            return false;
        }
        return true;
    }

   /**
     * Retourne une chaîne de caractères représentant cet objet.
     * 
     * @return Une chaîne de caractères représentant cet objet.
     */
    @Override
    public String toString() {
        return "Jour{" + "annee=" + annee + ", noJour=" + noJour + '}';
    }

}
