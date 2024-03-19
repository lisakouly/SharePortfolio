/*
 * Copyright 2024 Somebody.
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette classe représente un portefeuille qui contient des lignes de portefeuille.
 * Elle permet d'effectuer des opérations d'achat, de vente et de gestion des actions.
 * Elle peut également déterminer l'actionnaire majoritaire d'une action.
 * @author Somebody
 */
public class Portefeuille {

    // Variables d'instance
    private Map<Action, LignePortefeuille> mapLignes;
    private List<Action> availableActions;
    private Map<ActionSimple, Map<Client, Integer>> actionsClient;

    // Constructeur
    /**
     * Constructeur de la classe Portefeuille.
     */
    public Portefeuille() {
        this.mapLignes = new HashMap<>();
        this.actionsClient = new HashMap<>();
    }

    // Méthodes

    /**
     * Méthode pour acheter une certaine quantité d'une action donnée et l'ajouter au portefeuille.
     * @param a l'action à acheter
     * @param q la quantité à acheter
     */
    public void acheter(Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }
    
    /**
     * Méthode pour acheter une certaine quantité d'une action simple pour un client spécifique.
     * @param action l'action simple à acheter
     * @param nombreActions le nombre d'actions à acheter
     * @param client le client effectuant l'achat
     */
    public void acheter(ActionSimple action, int nombreActions, Client client) {
        if (!actionsClient.containsKey(action)) {
            actionsClient.put(action, new HashMap<>());
        }

        actionsClient.get(action).put(client, nombreActions);
    }

    /**
     * Méthode pour vendre une certaine quantité d'une action donnée du portefeuille.
     * Si la quantité à vendre est supérieure à la quantité détenue dans le portefeuille,
     * l'action est retirée du portefeuille.
     * @param a l'action à vendre
     * @param q la quantité à vendre
     */
    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a)) {
            int currentQuantity = this.mapLignes.get(a).getQte();
            if (currentQuantity >= q) {
                this.mapLignes.get(a).setQte(currentQuantity - q);
            } else if (currentQuantity == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    /**
     * Méthode pour vendre une certaine quantité d'une action simple d'une entreprise.
     * @param action l'action simple à vendre
     * @param quantite la quantité à vendre
     */
    public void vendreEntreprise(ActionSimple action, int quantite) {
        if (action != null && mapLignes.containsKey(action)) {
            int palierBlocage = action.getEntreprise().getPalierBlocage();
            if (quantite <= palierBlocage) {
                int currentQuantity = mapLignes.get(action).getQte();
                if (currentQuantity >= quantite) {
                    mapLignes.get(action).setQte(currentQuantity - quantite);
                    System.out.println("La vente a été réalisée.");
                } else {
                    System.out.println("La vente de cette quantité est bloquée.");
                }
            } else {
                System.out.println("La vente de cette quantité est bloquée.");
            }
        } else {
            System.out.println("Action non trouvée dans le portefeuille.");
        }
    }

    /**
     * Méthode pour obtenir la valeur totale du portefeuille pour un jour donné.
     * @param j le jour pour lequel calculer la valeur
     * @return la valeur totale du portefeuille
     */
    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += lp.getQte() * lp.getAction().valeur(j);
        }
        return total;
    }

    /**
     * Méthode pour obtenir la quantité détenue d'une action donnée dans le portefeuille.
     * @param action l'action dont on veut connaître la quantité
     * @return la quantité détenue
     */
    public int getQuantite(Action action) {
        return mapLignes.containsKey(action) ? mapLignes.get(action).getQte() : 0;
    }

    /**
     * Méthode pour obtenir la liste des lignes de portefeuille.
     * @return la liste des lignes de portefeuille
     */
    public Map<Action, LignePortefeuille> getMapLignes() {
        return mapLignes;
    }

    /**
     * Méthode pour obtenir la liste des actions disponibles.
     * @return la liste des actions disponibles
     */
    public List<Action> getAvailableActions() {
        return availableActions;
    }

    /**
     * Méthode pour définir la liste des actions disponibles.
     * @param availableActions la liste des actions disponibles à définir
     */
    public void setAvailableActions(List<Action> availableActions) {
        this.availableActions = availableActions;
    }

    /**
     * Méthode pour soustraire une certaine quantité d'une action du portefeuille.
     * @param action l'action à soustraire
     * @param quantity la quantité à soustraire
     */
    public void soustraire(Action action, int quantity) {
        LignePortefeuille ligne = mapLignes.get(action);
        if (ligne != null) {
            ligne.setQte(ligne.getQte() - quantity);
        }
    }

    /**
     * Méthode pour ajouter une certaine quantité d'une action au portefeuille.
     * @param action l'action à ajouter
     * @param quantity la quantité à ajouter
     */
    public void ajouter(Action action, int quantity) {
        LignePortefeuille ligne = mapLignes.get(action);
        if (ligne != null) {
            ligne.setQte(ligne.getQte() + quantity);
        }
    }

    /**
     * Méthode pour déterminer l'actionnaire majoritaire d'une action simple dans le portefeuille.
     * @param action l'action simple dont on veut déterminer l'actionnaire majoritaire
     * @return le client actionnaire majoritaire ou null s'il n'y a pas d'actionnaire majoritaire
     */
    public Client actionnaireMajoritaire(ActionSimple action) {
        if (!actionsClient.containsKey(action)) {
            return null; // L'action n'est pas présente dans le portefeuille
        }

        Map<Client, Integer> ownership = actionsClient.get(action);
        Client actionnaireMajoritaire = null;
        int maxActions = 0;

        for (Map.Entry<Client, Integer> entry : ownership.entrySet()) {
            if (entry.getValue() > maxActions) {
                maxActions = entry.getValue();
                actionnaireMajoritaire = entry.getKey();
            }
        }

        return actionnaireMajoritaire;
    }

    /**
     * Méthode pour obtenir la quantité détenue par un client pour une action donnée.
     * @param action l'action concernée
     * @param client le client concerné
     * @return la quantité détenue par le client pour l'action donnée
     */
    private int getQuantite(Action action, Client client) {
        for (LignePortefeuille lignePortefeuille : mapLignes.values()) {
            // Vérifier si la ligne de portefeuille concerne l'action spécifiée et si elle contient le client donné
            if (lignePortefeuille.getAction().equals(action) && lignePortefeuille.getClients().contains(client)) {
                return lignePortefeuille.getQte(); // Retourner la quantité détenue par le client
            }
        }
        return 0; // Retourner 0 si le client n'est pas associé à cette action dans le portefeuille
    }

    @Override
    public String toString() {
        return this.mapLignes.toString();
    }

}
