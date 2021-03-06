/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsp;

import controleur.Coeur_Gsp;
import controleur.ConnectDataBase;
import controleur.SubJTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordie
 */
public class UpDateProduit extends javax.swing.JDialog {

    Coeur_Gsp cg = new Coeur_Gsp();
    public String operation = "";
    public int ligne;
    private DefaultTableModel dtm;
    private Statement st;
    private ResultSet rs;

    /**
     * Creates new form UpDateProduit
     */
    public UpDateProduit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tabProd.setDefaultRenderer(Object.class, new SubJTable());
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
        tabProd = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
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
        jLabel5.setText("Liste de produits");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 0, 230, 40);

        jLabel4.setBackground(new java.awt.Color(104, 151, 215));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 880, 40);

        tabProd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabProd.setRowHeight(45);
        tabProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabProd);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(22, 50, 830, 380);

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(730, 440, 100, 40);

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/b_edit_1.png"))); // NOI18N
        jButton3.setText("Modifier");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(50, 440, 100, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        arrayProduit();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tabProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabProdMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cg.miseAjour("delete from produit where codprod='" + tabProd.getValueAt(tabProd.getSelectedRow(), 0) + "'");
        cg.miseAjour("delete from expirant where numexp='" + tabProd.getValueAt(tabProd.getSelectedRow(), 0) + "'");
        cg.boiteDeDialogue("Produit supprim?? avec succ??s.", "information");
        arrayProduit();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Produit prod = new Produit(new javax.swing.JFrame(), true);
        prod.ligne = Integer.parseInt(tabProd.getValueAt(tabProd.getSelectedRow(), 0).toString());
        prod.operation = "modifier";
        prod.setVisible(true);
        arrayProduit();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void arrayProduit() {
        try {
            String[] entete = {"N??", "Cat??gorie", "Produit", "Prix unitaire", "Marge b??n??.", "TVA", "Qte. Min", "Devise"};
            Object[] row = new Object[8];
            dtm = new DefaultTableModel(null, entete);
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select produit.codprod,categories.libcat,produit.libprod,produit.pu,produit.mb,produit.tva,produit.qtemin,devise.libdev from produit inner join categories on categories.codcat=produit.codcat inner join devise on devise.coddev=produit.coddev");
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                row[5] = rs.getObject(6);
                row[6] = rs.getObject(7);
                row[7] = rs.getObject(8);
                dtm.addRow(row);
            }
            tabProd.setModel(dtm);
            tabProd.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabProd.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabProd.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabProd.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabProd.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabProd.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabProd.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabProd.getColumnModel().getColumn(7).setPreferredWidth(150);
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
            java.util.logging.Logger.getLogger(UpDateProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpDateProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpDateProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpDateProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpDateProduit dialog = new UpDateProduit(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabProd;
    // End of variables declaration//GEN-END:variables
}
