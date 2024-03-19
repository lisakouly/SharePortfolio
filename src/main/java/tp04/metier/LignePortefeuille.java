/*
 * Copyright 2024 Imane.
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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Imane
 */
public class LignePortefeuille {
    
        private Action action;
        private int qte;
        private double prix;
        
        //Imane +++
        private List<Client> clients;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }
        
        public double getPrix() {
            return prix;
        }

        public void setPrix(double prix) {
            this.prix = prix;
        }

        public Action getAction() {
            return action;
        }

        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
            this.clients = new ArrayList<>();

        }
          
    // Méthode pour ajouter un client à cette ligne de portefeuille
    public void addClient(Client client) {
        clients.add(client);
    }
     
    // Méthode pour récupérer la liste des clients associés à cette ligne de portefeuille
    public List<Client> getClients() {
        return clients;
    }


        @Override
        public String toString() {
            return Integer.toString(qte);
        }

    
}
