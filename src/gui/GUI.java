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
import javax.swing.JOptionPane;

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

        btYearWithMostReleases.setText("Releases of Year");
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

        btGameWithMostSales.setText("Most Sold Game");
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
        /**
         * Calculates in which year most games got released
         * after entering a year.
         */
        try {
            int year = Integer.parseInt(JOptionPane.showInputDialog(this, "What year should be calculated"));
            int sales = model.getReleasedGames(year);
            dataBase.insertYear(year, sales);
            dataBase.getYearWithMostReleases();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btYearWithMostReleasesActionPerformed

    private void btGameWithMostSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGameWithMostSalesActionPerformed
//        try {
//            String game = JOptionPane.showInputDialog(this, "What game should be calculated");
//            VideoGame sales = model.getMostSoldGame();
//            dataBase.insertSales("Super Mario Bros.", vg.getVideogames().size());
//            dataBase.getGameWithMostSales();
//        } catch (SQLException ex) {
//            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        /**
         * The JOptionPane outputs the most sold game.
         */
        VideoGame sales = model.getMostSoldGame();
        JOptionPane.showMessageDialog(null, "The most sold game was " + sales.getName() + " for " + sales.getPlatform() + " and was developed by " + sales.getPublisher());
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
