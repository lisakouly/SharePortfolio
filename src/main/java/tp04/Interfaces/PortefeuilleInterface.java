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
import java.util.Map;
import tp04.metier.ActionSimple;
import tp04.metier.Portefeuille;
import tp04.metier.LignePortefeuille;
import tp04.metier.Action;

/**
 * Cette classe représente une interface utilisateur (avec JFrame) pour afficher le portefeuille d'un client.
 * Les actions dans le portefeuille sont affichées dans un tableau avec leurs quantités et prix actuels.
 * Les actions peuvent être vendues depuis cette interface.
 *
 * @author Imane
 */
public class PortefeuilleInterface extends JFrame {

    private DefaultTableModel tableModel;
    private JTable tableView;
    private Portefeuille portefeuille;
    private ActionsSimplesInterface actionSimpleInterface;

    /**
     * Constructeur de la classe PortefeuilleInterface.
     *
     * @param portefeuille Le portefeuille du client.
     * @param actionSimpleInterface L'interface des actions disponibles.
     */
    public PortefeuilleInterface(Portefeuille portefeuille, ActionsSimplesInterface actionSimpleInterface) {

        this.portefeuille = portefeuille;
        this.actionSimpleInterface = actionSimpleInterface;

        // Création du modèle de table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Libellé");
        tableModel.addColumn("Quantité");
        tableModel.addColumn("Prix d'une action");

        // Ajout des lignes au modèle de table à partir des données du portefeuille
        for (Map.Entry<Action, LignePortefeuille> entry : portefeuille.getMapLignes().entrySet()) {
            Action action = entry.getKey();
            LignePortefeuille lignePortefeuille = entry.getValue();
            tableModel.addRow(new Object[]{action.getLibelle(), lignePortefeuille.getQte(), lignePortefeuille.getPrix()});
        }

        tableView = new JTable(tableModel);

        // Création du bouton "Vendre"
        JButton sellButton  = new JButton("Vendre");
        sellButton .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableView.getSelectedRow();
                if (selectedRow != -1) {
                    Action selectedAction  = portefeuille.getMapLignes().keySet().toArray(new Action[0])[selectedRow];
                    int totalQuantity  = portefeuille.getQuantite(selectedAction );

                    // saisir la quantité à vendre
                    String quantityStr  = JOptionPane.showInputDialog("Entrez la quantité à vendre : ");
                    if (quantityStr  != null && !quantityStr.isEmpty()) {
                        int quantityToSell  = Integer.parseInt(quantityStr);
                        if (quantityToSell  > 0 && quantityToSell  <= totalQuantity ) {
                            portefeuille.vendre(selectedAction , quantityToSell);
                            updateTableModel();

                            updateQuantiteDisponible((ActionSimple) selectedAction , quantityToSell);  // Mise à jour de la quantité des actions disponibles
                        } else {
                            JOptionPane.showMessageDialog(null, "La quantité à vendre est invalide ou dépasse la quantité disponible.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité valide.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aucune action sélectionnée.");
                }
            }
        });

        // Création du bouton "Retour"
        JButton backButton  = new JButton("Retour aux actions disponibles");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                actionSimpleInterface.setVisible(true);
            }
        });

        setTitle("Portefeuille du client");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(tableView);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sellButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack(); 
        setLocationRelativeTo(null);
    }

    /**
     * Mise à jour de la quantité des actions disponibles dans l'interface des actions disponibles.
     *
     * @param action L'action vendue.
     * @param quantiteVendue La quantité de l'action vendue.
     */
    public void updateQuantiteDisponible(ActionSimple action, int quantiteVendue) {
        actionSimpleInterface.updateQuantiteDisponible(action, quantiteVendue);
    }

    /**
     * Met à jour le modèle de la table avec les données du portefeuille.
     */
    private void updateTableModel() {
        tableModel.setRowCount(0); // Effacer les lignes existantes de la table
        for (Map.Entry<Action, LignePortefeuille> entry : portefeuille.getMapLignes().entrySet()) {
            Action action = entry.getKey();
            LignePortefeuille lignePortefeuille = entry.getValue();
            tableModel.addRow(new Object[]{action.getLibelle(), lignePortefeuille.getQte(), lignePortefeuille.getPrix()});
        }
    }
}
