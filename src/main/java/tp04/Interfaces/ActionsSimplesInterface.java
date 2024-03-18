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
    private List<Action> actionsDisponibles;
    private Portefeuille portefeuille;

    /**
     * Constructeur de la classe ActionsSimplesInterface.
     */
    public ActionsSimplesInterface() {

        // Création d'une liste d'actions disponibles
        actionsDisponibles = new ArrayList<>();
        actionsDisponibles.add(new ActionSimple("Action 1", 10, 100.00));
        actionsDisponibles.add(new ActionSimple("Action 2", 20, 250.00));
        actionsDisponibles.add(new ActionSimple("Action 3", 30, 320.00));

        // Initialisation du portefeuille
        portefeuille = new Portefeuille();

        // Création de la table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Libellé");
        tableModel.addColumn("Quantité disponible");
        tableModel.addColumn("Prix d'une action");
        for (Action action : actionsDisponibles) {
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
            Action actionSelectionnee = actionsDisponibles.get(selectedRow);
            System.out.println("Vous avez sélectionné l'action : " + actionSelectionnee.getLibelle());

            // Demander à l'utilisateur de saisir la quantité à acheter
            String quantiteStr = JOptionPane.showInputDialog("Entrez la quantité à acheter : ");
            if (quantiteStr != null && !quantiteStr.isEmpty()) {
                int quantite = Integer.parseInt(quantiteStr);

                // Acheter l'action et mettre à jour le portefeuille
                portefeuille.acheter(actionSelectionnee, quantite);

                // Mettre à jour la quantité disponible de l'action achetée dans la liste des actions disponibles
                actionSelectionnee.soustraireQuantite(quantite);

                // Mettre à jour le modèle de la table avec les données du portefeuille
                updateTableModel();

                // Afficher la fenêtre du portefeuille avec l'action achetée en plus
                PortefeuilleInterface portefeuilleInterface = new PortefeuilleInterface(portefeuille);
                portefeuilleInterface.setVisible(true);
            } else {
                System.out.println("Quantité invalide.");
            }
        } else {
            System.out.println("Aucune action sélectionnée.");
        }
    }
});


        // Création du conteneur pour les boutons d'action
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(acheterButton, BorderLayout.NORTH);

        // Création du conteneur principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tableView), BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH); // Ajout du panel des boutons en bas

        // Configuration de la fenêtre
        setTitle("Actions Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Met à jour le modèle de la table avec les données du portefeuille.
     */
    private void updateTableModel() {
        tableModel.setRowCount(0); // Effacer les lignes existantes de la table
        for (Action action : actionsDisponibles) {
            tableModel.addRow(new Object[]{action.getLibelle(), action.getQuantite(), action.getPrixAction()});
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
