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

/**
 * Cette classe représente un client.
 * @author mazhu
 */
public class Client {
    
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

    Client(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Méthodes
    /**
     * Méthode pour obtenir le nom du client.
     * @return le nom du client
     */
    public String getNom() {
        return this.nom;
    }
}
