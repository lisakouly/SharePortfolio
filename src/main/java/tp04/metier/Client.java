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


/**
 *
 * @author mazhuo
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
     
     
    public void addPortefeuille(Portefeuille portefeuille) {
    this.portefeuilles.add(portefeuille);}

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
    
    
    
   
}
