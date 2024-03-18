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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import tp04.metier.ActionSimple;
import tp04.metier.Action;
import tp04.metier.Portefeuille;

/**
 * Cette classe représente une interface utilisateur (avec JFrame) pour afficher les actions simples disponibles.
 * Les actions simples sont affichées dans un tableau avec leurs quantités disponibles et leurs prix.
 *
 * @author Imane
 */
public class ActionsSimplesInterface extends JFrame {

    private JTable tableView;
    private DefaultTableModel tableModel;
    private List<Action> availableActions;
    private Portefeuille portfolio;
    ActionsSimplesInterface actionSimpleInterface=this;

    /**
     * Constructeur de la classe ActionsSimplesInterface.
     */
    public ActionsSimplesInterface() {

        // Création d'une liste d'actions disponibles
        availableActions  = new ArrayList<>();
        availableActions.add(new ActionSimple("Action 1", 10, 100.00));
        availableActions.add(new ActionSimple("Action 2", 20, 250.00));
        availableActions.add(new ActionSimple("Action 3", 30, 320.00));

        // Initialisation du portefeuille
        portfolio  = new Portefeuille();
        
       

    // Afficher la fenêtre du portefeuille avec l'action achetée en plus
           PortefeuilleInterface portefeuilleInterface = new PortefeuilleInterface(portfolio ,actionSimpleInterface);
           portefeuilleInterface.setVisible(true);
           
        // Création de la table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Libellé");
        tableModel.addColumn("Quantité disponible");
        tableModel.addColumn("Prix d'une action");
        for (Action action : availableActions) {
            tableModel.addRow(new Object[]{action.getLibelle(), action.getQuantite(), action.getPrixAction()});
        }
        tableView = new JTable(tableModel);

        // Création d'un bouton pour acheter l'action sélectionnée
JButton acheterButton = new JButton("Acheter");
acheterButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = tableView.getSelectedRow();
        if (selectedRow != -1) {
            Action selectedAction  = availableActions.get(selectedRow);
            System.out.println("Vous avez sélectionné l'action : " + selectedAction.getLibelle());

            // Demander à l'utilisateur de saisir la quantité à acheter
            String quantityStr = JOptionPane.showInputDialog("Entrez la quantité à acheter : ");
            if (quantityStr  != null && !quantityStr .isEmpty()) {
                int quantity = Integer.parseInt(quantityStr );

                // Acheter l'action et mettre à jour le portefeuille
                portfolio.acheter(selectedAction, quantity);

                // Mettre à jour la quantité disponible de l'action achetée dans la liste des actions disponibles
                selectedAction.soustraireQuantite(quantity);

                // Mettre à jour le modèle de la table avec les données du portefeuille
                updateTableModel(portfolio);

                // Afficher la fenêtre du portefeuille avec l'action achetée en plus
                PortefeuilleInterface portefeuilleInterface = new PortefeuilleInterface(portfolio,actionSimpleInterface);
                portefeuilleInterface.setVisible(true);
            } else {
                System.out.println("Quantité invalide.");
            }
        });

        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(acheterButton, BorderLayout.NORTH);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tableView), BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH); // Ajout du panel des boutons en bas

        setTitle("Actions Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

  
    /**
     * Méthode pour mettre à jour le modèle de la table avec les données du portefeuille
     * @param portefeuille 
     */
    
    private void updateTableModel(Portefeuille portefeuille) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Action action = availableActions.get(i);
            tableModel.setValueAt(action.getQuantite(), i, 1); // Mettre à jour la quantité dans la table
        }
    }
    
    /**
     * Mise à jour de la quantité disponible d'une action dans le modèle de la table
     * @param action
     * @param quantiteVendue 
     */
    
    public void updateQuantiteDisponible(ActionSimple action, int quantiteVendue) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Action a = availableActions.get(i);
            if (a instanceof ActionSimple && a.equals(action)) {
                ((ActionSimple) a).ajouterQuantite(quantiteVendue);
                tableModel.setValueAt(a.getQuantite(), i, 1); // Mettre à jour la quantité dans le modèle de la table
                break;
            }
        }
    }

    /**
     * Test de l'interface.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActionsSimplesInterface().setVisible(true);
            }
        });
    }
}
