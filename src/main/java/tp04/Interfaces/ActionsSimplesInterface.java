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
package tp04.Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import tp04.metier.ActionSimple;
import tp04.metier.Action;


/**
 *
 * @author Imane
 */
public class ActionsSimplesInterface extends JFrame{
    
    private JTable tableView;
    private DefaultTableModel tableModel;
    private List<Action> actionsDisponibles;
  
    public ActionsSimplesInterface() {
        // Création d'une liste d'actions disponibles
        actionsDisponibles = new ArrayList<>();
        actionsDisponibles.add(new ActionSimple("Action 1", 10, 100.00)); 
        actionsDisponibles.add(new ActionSimple("Action 2", 20, 250.00)); 
        actionsDisponibles.add(new ActionSimple("Action 3", 30, 320.00)); 
        
        // Création de la table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Libellé");
        tableModel.addColumn("Quantité disponible"); 
        tableModel.addColumn("Prix d'une action"); 
        for (Action action : actionsDisponibles) {
            tableModel.addRow(new Object[]{action.getLibelle(), action.getQuantite(), action.getPrixAction()});
        }
        tableView = new JTable(tableModel);
        
        // Création du conteneur principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tableView), BorderLayout.CENTER);

        // Configuration de la fenêtre
        setTitle("Actions Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActionsSimplesInterface().setVisible(true);
            }
        });
    }
}
