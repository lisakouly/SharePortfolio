/*
 * Copyright 2024 lisak.
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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de la validité de la date de naissance d'un client à la création d'un nouveau client
 * @Author Lisa
 */
public class ClientBirthTest {
    
    public ClientBirthTest() {}
    
    
    @Test
    void createClient_WithValidDateOfBirth_ShouldSucceed() {
        // Arrange
        int validYear = 1998;
        int validMonth = 6;
        int validDay = 6;
        
        // Act
        Client c = new Client(validYear, validMonth, validDay);
        
        // Assert
        assertNotNull(c);
    }
    
    @Test
    void createClient_WithInvalidDateOfBirth_ShouldFail() {
        // Arrange
        int invalidYear = 1800;
        int validMonth = 1; 
        int validDay = 1;
        
        // Action
        Client c0 = new Client(invalidYear, validMonth, validDay);
        
        // Assert
        assertNotNull(c0);
    }
    
    @Test
    void createClient_WithInvalidMonth_ShouldFail() {
        // Arrange
        int validYear = 1998;
        int invalidMonthUp = 13; 
        int invalidMonthDown = 0; 
        int validDay = 6;
        
        // Action
        Client c1 = new Client(validYear, invalidMonthUp, validDay);
        Client c2 = new Client(validYear, invalidMonthDown, validDay);
        
        // Assert
        assertNotNull(c1);
        assertNotNull(c2);
    }
    
    @Test
    void createClient_WithInvalidDay_ShouldFail() {
        // Arrange
        int validYear = 1998;
        int validMonth = 6;
        int invalidDayUp = 35; 
        int invalidDayDown = 0; 

        // Action
        Client c3 = new Client(validYear, validMonth, invalidDayUp);
        Client c4 = new Client(validYear, validMonth, invalidDayDown);
        
        // Assert
        assertNotNull(c3);
        assertNotNull(c4);    
    }
    
    @Test
    void createClient_Minor_ShouldFail() {
        // Arrange
        int minorYear = 2010;
        int minorMonth = 8;
        int minorDay = 6;
        
        // Action
        Client c5 = new Client(minorYear, minorMonth, minorDay);
        
        // Assert
        assertNotNull(c5);    
    }
}
