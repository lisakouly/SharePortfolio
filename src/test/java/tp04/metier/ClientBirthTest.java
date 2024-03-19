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
 * @Author Lisa/Yassine/Nathan
 */
public class ClientBirthTest {
    
    public ClientBirthTest() {}
    
    @Test
    public void createClient_WithValidDateOfBirth_ShouldSucceed() {
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
    public void createClient_WithInvalidDateOfBirth_ShouldFail() {
        // Arrange
        int invalidYear = 1800;
        int invalidMonth = 0; // assuming month cannot be 0
        int invalidDay = 0; // assuming day cannot be 0
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Client(invalidYear, invalidMonth, invalidDay);
        });
    }
    
    @Test
    public void createClient_WithInvalidMonth_ShouldFail() {
        // Arrange
        int validYear = 1998;
        int invalidMonth = 13; // assuming month cannot be greater than 12
        int validDay = 6;
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Client(validYear, invalidMonth, validDay);
        });
    }
    
    @Test
    public void createClient_WithInvalidDay_ShouldFail() {
        // Arrange
        int validYear = 1998;
        int validMonth = 6;
        int invalidDay = 35; // assuming day cannot be greater than 31
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Client(validYear, validMonth, invalidDay);
        });
    }
    
    @Test
    public void createClient_Minor_ShouldFail() {
        // Arrange
        int minorYear = 2010;
        int minorMonth = 8;
        int minorDay = 6;
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Client(minorYear, minorMonth, minorDay);
        });
    }
}
