/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsp;

import controleur.Coeur_Gsp;
import java.sql.Statement;

/**
 *
 * @author Jordie
 */
public class Produit extends javax.swing.JDialog {

    Coeur_Gsp cg = new Coeur_Gsp();
    public String operation = "";
    public int ligne;
    private Statement st;
    private Statement rs;
    private int codprod;
    public String madate;

    /**
     * Creates new form Produit
     */
    public Produit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbCat = new javax.swing.JComboBox<>();
        txtTva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMb = new javax.swing.JTextField();
        txtQte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbDev = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        chExp = new javax.swing.JCheckBox();

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
        jLabel5.setText("Mise ?? jour produit");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 0, 230, 40);

        jLabel4.setBackground(new java.awt.Color(104, 151, 215));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 460, 40);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("TVA");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 180, 90, 16);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Produit");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 60, 90, 16);

        txtProd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(txtProd);
        txtProd.setBounds(80, 80, 290, 30);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.setText("Annuler");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 340, 110, 50);

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.gif"))); // NOI18N
        jButton2.setText("Enregistrer");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(80, 340, 110, 50);

        cmbCat.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(cmbCat);
        cmbCat.setBounds(80, 140, 290, 30);

        txtTva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtTva);
        txtTva.setBounds(180, 200, 90, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Cat??gorie");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 120, 90, 16);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Prix unitaire");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 180, 90, 16);

        txtPu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtPu);
        txtPu.setBounds(80, 200, 90, 30);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Marge b??n??f.");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(280, 180, 90, 16);

        txtMb.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtMb);
        txtMb.setBounds(280, 200, 90, 30);

        txtQte.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtQte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtQte);
        txtQte.setBounds(80, 260, 140, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Quantit?? min.");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(80, 240, 90, 16);

        cmbDev.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbDev.setEnabled(false);
        jPanel1.add(cmbDev);
        cmbDev.setBounds(230, 260, 140, 30);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Devise");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(230, 240, 90, 16);

        chExp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chExp.setText("Expirant");
        chExp.setOpaque(false);
        chExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chExpActionPerformed(evt);
            }
        });
        jPanel1.add(chExp);
        chExp.setBounds(80, 300, 100, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtProd.setText("");
        cmbCat.setSelectedIndex(0);
        txtPu.setText("");
        txtTva.setText("");
        txtMb.setText("");
        txtQte.setText("");
        cmbDev.setSelectedIndex(0);
        chExp.setSelected(false);
        txtProd.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtProd.getText().isEmpty() || txtPu.getText().isEmpty() || txtTva.getText().isEmpty() || txtMb.getText().isEmpty() || txtQte.getText().isEmpty()) {
            cg.boiteDeDialogue("Veuillez remplir toute les zones.", "erreur");
        } else {
            if (operation.equals("modifier")) {
                cg.miseAjour("update produit set codcat='" + cg.retournerIdentifiant("codcat", "libcat", "categories", cmbCat) + "',coddev='" + cg.retournerIdentifiant("coddev", "libdev", "devise", cmbDev) + "',libprod='" + cg.optimiser(txtProd) + "',pu='" + cg.optimiser(txtPu) + "',tva='" + cg.optimiser(txtTva) + "',mb='" + cg.optimiser(txtMb) + "',qtemin ='" + cg.optimiser(txtQte) + "' where codprod='" + ligne + "'");
                if (chExp.isSelected()) {
                } else {
                    cg.miseAjour("delete from expirant where numexp='" + ligne + "'");
                }
                cg.boiteDeDialogue("Produit modifi?? avec succ??s.", "information");
                txtProd.setText("");
                cmbCat.setSelectedIndex(0);
                txtPu.setText("");
                txtTva.setText("");
                txtMb.setText("");
                txtQte.setText("");
                cmbDev.setSelectedIndex(0);
                chExp.setSelected(false);
                txtProd.requestFocus();
            } else {
                codprod = cg.nouvelleLigne("codprod", "produit");
                cg.miseAjour("insert into produit values('" + codprod + "','" + cg.retournerIdentifiant("codcat", "libcat", "categories", cmbCat) + "','" + cg.retournerIdentifiant("coddev", "libdev", "devise", cmbDev) + "','" + cg.optimiser(txtProd) + "','" + cg.optimiser(txtPu) + "','" + cg.optimiser(txtTva) + "','" + cg.optimiser(txtMb) + "','" + cg.optimiser(txtQte) + "')");
                if (chExp.isSelected()) {
                    cg.miseAjour("insert into expirant values('" + cg.nouvelleLigne("numexp", "expirant") + "')");
                }
                cg.boiteDeDialogue("Produit enregistr?? avec succ??s.", "information");
                txtProd.setText("");
                cmbCat.setSelectedIndex(0);
                txtPu.setText("");
                txtTva.setText("");
                txtMb.setText("");
                txtQte.setText("");
                cmbDev.setSelectedIndex(0);
                chExp.setSelected(false);
                txtProd.requestFocus();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chExpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cg.remplirCombo("libcat", "categories", cmbCat);
        cg.remplirComboDevPrin("libdev", "devise", cmbDev);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Produit dialog = new Produit(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox chExp;
    private javax.swing.JComboBox<String> cmbCat;
    private javax.swing.JComboBox<String> cmbDev;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMb;
    private javax.swing.JTextField txtProd;
    private javax.swing.JTextField txtPu;
    private javax.swing.JTextField txtQte;
    private javax.swing.JTextField txtTva;
    // End of variables declaration//GEN-END:variables
}
