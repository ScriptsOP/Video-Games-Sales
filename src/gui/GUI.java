package gui;

import bl.TableModel;
import bl.TableRenderer;
import bl.VideoGame;
import database.DataBase;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends javax.swing.JFrame {

    private File file = new File("src\\data\\VideoGamesSales2016.csv");
    private TableModel model = new TableModel();
    private VideoGame vg = new VideoGame();
    private DataBase dataBase;

    public GUI() throws SQLException {
        initComponents();
        init();
        tableVideoGames.setModel(model);
        tableVideoGames.setDefaultRenderer(Object.class, new TableRenderer());
    }

    public void init() throws SQLException {
        try {
            vg.readInCSV(file);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            dataBase = DataBase.getInstance();
            dataBase.listAllDepartments();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i <= vg.getVideogames().size() - 1; i++) {
            model.add(vg.getVideogames().get(i));
            dataBase.insertYear(vg.getYear_of_release(), 0);
            dataBase.insertSales(vg.getName(), 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVideoGames = new javax.swing.JTable();
        btYearWithMostReleases = new javax.swing.JButton();
        btGameWithMostSales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tableVideoGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableVideoGames);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 368;
        gridBagConstraints.ipady = 239;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.1;
        gridBagConstraints.weighty = 1.1;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btYearWithMostReleases.setText("Year with most releases");
        btYearWithMostReleases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btYearWithMostReleasesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(btYearWithMostReleases, gridBagConstraints);

        btGameWithMostSales.setText("Game with most sales");
        btGameWithMostSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGameWithMostSalesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(btGameWithMostSales, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btYearWithMostReleasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btYearWithMostReleasesActionPerformed
        try {
            dataBase.getYearWithMostReleases();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btYearWithMostReleasesActionPerformed

    private void btGameWithMostSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGameWithMostSalesActionPerformed
        try {
            dataBase.getGameWithMostSales();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btGameWithMostSalesActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGameWithMostSales;
    private javax.swing.JButton btYearWithMostReleases;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVideoGames;
    // End of variables declaration//GEN-END:variables
}
