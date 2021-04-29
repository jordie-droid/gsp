/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsp;

import controleur.Coeur_Gsp;

/**
 *
 * @author Jordie
 */
public class Utilisateur extends javax.swing.JDialog {

    Coeur_Gsp cg = new Coeur_Gsp();
    public String operation = "";
    public int ligne;

    /**
     * Creates new form Stock
     */
    public Utilisateur(java.awt.Frame parent, boolean modal) {
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
        jLabel3 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtPseudo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        txtPass = new javax.swing.JPasswordField();

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
        jLabel5.setText("Mise à jour utilisateur");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 0, 230, 40);

        jLabel4.setBackground(new java.awt.Color(104, 151, 215));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 470, 40);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Pseudo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 110, 90, 16);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Noms");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 50, 90, 16);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Mot de passe");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 170, 90, 16);

        txtNom.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(txtNom);
        txtNom.setBounds(80, 70, 290, 30);

        txtPseudo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(txtPseudo);
        txtPseudo.setBounds(80, 130, 290, 30);

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
        jButton1.setBounds(260, 300, 110, 50);

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
        jButton2.setBounds(80, 300, 110, 50);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Rôle");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 230, 90, 16);

        cmbRole.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRATEUR", "GESTIONNAIRE DE STOCK", "CAISSE" }));
        jPanel1.add(cmbRole);
        cmbRole.setBounds(80, 250, 290, 30);
        jPanel1.add(txtPass);
        txtPass.setBounds(80, 190, 290, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtNom.setText("");
        txtPseudo.setText("");
        txtPass.setText("");
        cmbRole.setSelectedIndex(0);
        txtNom.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtNom.getText().isEmpty() || txtPseudo.getText().isEmpty() || txtPass.getText().isEmpty()) {
            cg.boiteDeDialogue("Veuillez remplir toute les zones.", "erreur");
        } else {
            if (operation.equals("modifier")) {
                cg.miseAjour("update utilisateur set noms ='" + cg.optimiser(txtNom) + "', pseudo='" + cg.optimiser(txtPseudo) + "', password='" + cg.optimiser(txtPass) + "', role='" + cmbRole.getSelectedItem().toString().replace("'", "''") + "' where coduti='" + ligne + "'");
                cg.boiteDeDialogue("Utilisateur modifié avec succès.", "information");
                txtNom.setText("");
                txtPseudo.setText("");
                txtPass.setText("");
                cmbRole.setSelectedIndex(0);
                txtNom.requestFocus();
            } else {
                cg.miseAjour("insert into utilisateur values ('" + cg.nouvelleLigne("coduti", "utilisateur") + "','" + cg.optimiser(txtNom) + "','" + cg.optimiser(txtPseudo) + "','" + cg.optimiser(txtPass) + "','" + cmbRole.getSelectedItem().toString().replace("'", "''") + "')");
                cg.boiteDeDialogue("Utilisateur enregistré avec succès.", "information");
                txtNom.setText("");
                txtPseudo.setText("");
                txtPass.setText("");
                cmbRole.setSelectedIndex(0);
                txtNom.requestFocus();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Utilisateur dialog = new Utilisateur(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNom;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPseudo;
    // End of variables declaration//GEN-END:variables
}