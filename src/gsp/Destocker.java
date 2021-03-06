/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsp;

import controleur.Coeur_Gsp;
import controleur.ConnectDataBase;
import controleur.ControleurTailleMaximale;
import controleur.SubJTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordie
 */
public class Destocker extends javax.swing.JDialog {

    ControleurTailleMaximale c = new ControleurTailleMaximale();
    public String madate, pseudo;
    private DefaultTableModel dtm;
    private Statement st;
    private ResultSet rs;
    Coeur_Gsp cg = new Coeur_Gsp();
    String vide = "1111-11-11";
    private int count = 0;
    private String dateenr;
    private double qteent;
    private double puent;
    private double qtesor;
    private double pusor;
    private double qtedes;
    private double qtesto;
    private double qtestock;

    /**
     * Creates new form Destocker
     */
    public Destocker(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        c.TailleMaximale();
        //this.setSize(812, c.ysize);
        setLocationRelativeTo(null);
        tabExp.setDefaultRenderer(Object.class, new SubJTable());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabExp = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("D??stocker les produits expir??s");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 0, 320, 40);

        jLabel4.setBackground(new java.awt.Color(104, 151, 215));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 730, 40);

        tabExp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabExp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabExp.setRowHeight(45);
        tabExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabExpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabExp);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(22, 50, 680, 350);

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/options.gif"))); // NOI18N
        jButton3.setText("Destocker");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(300, 410, 100, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        arrayExpiration();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tabExpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabExpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabExpMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            for (int i = 0; i < tabExp.getRowCount(); i++) {
                cg.miseAjour("insert into destocker values('" + cg.nouvelleLigne("numdes", "destocker") + "','" + cg.ligne("codprod", "produit", tabExp.getValueAt(i, 1).toString(), "libprod") + "','" + cg.ligne("coduti", "utilisateur", pseudo, "pseudo") + "','" + tabExp.getValueAt(i, 0).toString() + "','" + tabExp.getValueAt(i, 2).toString() + "','" + madate + "')");
                st = new ConnectDataBase().getConnexion().createStatement();
                rs = st.executeQuery("select qte from stockCourant where codprod='" + cg.ligne("codprod", "produit", tabExp.getValueAt(i, 1).toString(), "libprod") + "'");
                while (rs.next()) {
                    qtestock = rs.getDouble(1);
                }
                if (qtestock == 0.0) {
                    cg.miseAjour("insert into stockCourant values('" + cg.ligne("codprod", "produit", tabExp.getValueAt(i, 1).toString(), "libprod") + "','" + tabExp.getValueAt(i, 2).toString() + "')");
                } else {
                    cg.miseAjour("update stockCourant set qte='" + (qtestock - Double.parseDouble(tabExp.getValueAt(i, 2).toString())) + "' where codprod='" + cg.ligne("codprod", "produit", tabExp.getValueAt(i, 1).toString(), "libprod") + "'");
                }
                rs.close();
                st.close();
            }
            cg.boiteDeDialogue("Stock destock?? avec succ??s.", "information");
            arrayExpiration();
        } catch (Exception e) {
            cg.boiteDeDialogue(e.toString(), "erreur");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void fiche_de_stock(String codebarre) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            for (int i = 0; i < tabExp.getRowCount(); i++) {
                rs = st.executeQuery("select fichedestock.dateenr,fichedestock.qteent,fichedestock.puent,fichedestock.qtesor,fichedestock.pusor,fichedestock.qtedes,fichedestock.qtesto from fichedestock inner join stocker on stocker.codebar=fichedestock.codebar inner join produit on produit.codprod=stocker.codebar where fichedestock.codebar='" + tabExp.getValueAt(i, 0) + "' and dateenr='" + madate + "'");
                while (rs.next()) {
                    dateenr = rs.getString(1);
                    qteent = rs.getDouble(2);
                    puent = rs.getDouble(3);
                    qtesor = rs.getDouble(4);
                    pusor = rs.getDouble(5);
                    qtedes = rs.getDouble(6);
                    qtesto = rs.getDouble(7);
                }
                qtesto = qtesto - Double.parseDouble(tabExp.getValueAt(i, 2).toString());
                if (qtesto == 0.0) {
                    rs = st.executeQuery("select max(fichedestock.dateenr),fichedestock.qteent,fichedestock.puent,fichedestock.qtesor,fichedestock.pusor,fichedestock.qtedes,fichedestock.qtesto from fichedestock inner join stocker on stocker.codebar=fichedestock.codebar inner join produit on produit.codprod=stocker.codebar where fichedestock.codebar='" + tabExp.getValueAt(i, 0) + "'");
                    while (rs.next()) {
                        dateenr = rs.getString(1);
                        qteent = rs.getDouble(2);
                        puent = rs.getDouble(3);
                        qtesor = rs.getDouble(4);
                        pusor = rs.getDouble(5);
                        qtedes = rs.getDouble(6);
                        qtesto = rs.getDouble(7);
                    }
                    cg.miseAjour("insert into fichedestock values('" + cg.nouvelleLigne("codnum", "fichedestock") + "','" + tabExp.getValueAt(i, 0) + "','" + madate + "','" + 0 + "','" + cg.getPaUnitaire(tabExp.getValueAt(i, 1).toString()) + "','" + 0 + "','" + cg.getPvUnitaire(tabExp.getValueAt(i, 1).toString()) + "','" + tabExp.getValueAt(i, 2) + "','" + 0 + "')");
                } else {
                    cg.miseAjour("update fichedestock set '" + qteent + "','" + cg.getPaUnitaire(tabExp.getValueAt(i, 1).toString()) + "','" + qtesor + "','" + cg.getPvUnitaire(tabExp.getValueAt(i, 1).toString()) + "','" + tabExp.getValueAt(i, 2) + "','" + 0 + "' where dateenr='" + tabExp.getValueAt(i, 5) + "' and codebar='" + tabExp.getValueAt(i, 0) + "'");
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            cg.boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public void arrayExpiration() {
        try {
            String[] entete = {"Code barre", "Produit", "Quantit??", "Date de fabrication", "Date d'expiration", "Date de stockage"};
            Object[] row = new Object[6];
            dtm = new DefaultTableModel(null, entete);
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select count(*) from destocker");
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                rs = st.executeQuery("select stocker.codebar, produit.libprod, stocker.qte, stocker.datefab, stocker.dateexp, stocker.datestock from stocker inner join produit on produit.codprod=stocker.codprod where stocker.dateexp <= '" + madate + "' and stocker.dateexp != '" + vide + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else {
                rs = st.executeQuery("select stocker.codebar, produit.libprod, stocker.qte, stocker.datefab, stocker.dateexp, stocker.datestock from stocker inner join produit on produit.codprod=stocker.codprod inner join destocker on destocker.codebar != stocker.codebar where stocker.dateexp <= '" + madate + "' and stocker.dateexp != '" + vide + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            }
            tabExp.setModel(dtm);
            tabExp.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabExp.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabExp.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabExp.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabExp.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabExp.getColumnModel().getColumn(5).setPreferredWidth(200);
            rs.close();
            st.close();
        } catch (SQLException e) {
            cg.boiteDeDialogue(e.toString(), "erreur");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Destocker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Destocker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Destocker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Destocker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Destocker dialog = new Destocker(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabExp;
    // End of variables declaration//GEN-END:variables
}
