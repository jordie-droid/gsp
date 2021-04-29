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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordie
 */
public class ListeEntre extends javax.swing.JDialog {

    ControleurTailleMaximale c = new ControleurTailleMaximale();
    private DefaultTableModel dtm;
    private Statement st;
    private ResultSet rs;
    Coeur_Gsp cg = new Coeur_Gsp();
    public String madate;

    /**
     * Creates new form ListeEntre
     */
    public ListeEntre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        String[] entete = {"Code barre", "Caisse", "Produit", "Quantité", "Date fabrication"};
        dtm = new DefaultTableModel(null, entete);
        tabFac.setDefaultRenderer(Object.class, new SubJTable());
        tabFac.setModel(dtm);
        tabFac.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabFac.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabFac.getColumnModel().getColumn(2).setPreferredWidth(300);
        tabFac.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabFac.getColumnModel().getColumn(4).setPreferredWidth(150);
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
        tabFac = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbProd = new javax.swing.JComboBox<>();
        chAct = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        chUneDate = new javax.swing.JCheckBox();
        chDeuxDate = new javax.swing.JCheckBox();
        chDateY = new javax.swing.JCheckBox();
        chDateX = new javax.swing.JCheckBox();
        txtDate1 = new com.toedter.calendar.JDateChooser();
        txtDate2 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jLabel5.setText("Liste de factures");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 0, 230, 40);

        jLabel4.setBackground(new java.awt.Color(104, 151, 215));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 840, 40);

        tabFac.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabFac.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabFac.setRowHeight(45);
        tabFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabFac);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 680, 310);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paramétrage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        cmbProd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbProd.setEnabled(false);

        chAct.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chAct.setText("Activer");
        chAct.setOpaque(false);
        chAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chAct)
                    .addComponent(cmbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chAct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        chUneDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chUneDate.setText("Une date");
        chUneDate.setOpaque(false);
        chUneDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chUneDateActionPerformed(evt);
            }
        });

        chDeuxDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chDeuxDate.setText("Deux date");
        chDeuxDate.setOpaque(false);
        chDeuxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chDeuxDateActionPerformed(evt);
            }
        });

        chDateY.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chDateY.setText("Avant date x");
        chDateY.setOpaque(false);
        chDateY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chDateYActionPerformed(evt);
            }
        });

        chDateX.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chDateX.setText("Après date x");
        chDateX.setOpaque(false);
        chDateX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chDateXActionPerformed(evt);
            }
        });

        txtDate1.setDateFormatString("yyyy-MM-dd");
        txtDate1.setEnabled(false);
        txtDate1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtDate2.setDateFormatString("yyyy-MM-dd");
        txtDate2.setEnabled(false);
        txtDate2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chUneDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chDeuxDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chDateY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chDateX)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chUneDate)
                    .addComponent(chDeuxDate)
                    .addComponent(chDateY)
                    .addComponent(chDateX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 50, 680, 130);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.setText("Annuler");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/b_print.png"))); // NOI18N
        jButton3.setText("Imprimer");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.gif"))); // NOI18N
        jButton2.setText("Voir");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(710, 70, 110, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cg.remplirCombo("libprod", "produit", cmbProd);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tabFacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFacMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabFacMouseClicked

    private void chActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActActionPerformed
        if (chAct.isSelected()) {
            cmbProd.setEnabled(true);
            chAct.setText("Désactiver");
        } else {
            cmbProd.setEnabled(false);
            chAct.setText("Activer");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chActActionPerformed

    private void chUneDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chUneDateActionPerformed
        if (chUneDate.isSelected()) {
            txtDate1.setEnabled(true);
            txtDate2.setEnabled(false);
            chDeuxDate.setSelected(false);
            chDateY.setSelected(false);
            chDateX.setSelected(false);
        } else {
            txtDate1.setEnabled(false);
            txtDate2.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chUneDateActionPerformed

    private void chDeuxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chDeuxDateActionPerformed
        if (chDeuxDate.isSelected()) {
            txtDate1.setEnabled(true);
            txtDate2.setEnabled(true);
            chUneDate.setSelected(false);
            chDateY.setSelected(false);
            chDateX.setSelected(false);
        } else {
            txtDate1.setEnabled(false);
            txtDate2.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chDeuxDateActionPerformed

    private void chDateYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chDateYActionPerformed
        if (chDateY.isSelected()) {
            txtDate1.setEnabled(true);
            txtDate2.setEnabled(false);
            chDeuxDate.setSelected(false);
            chUneDate.setSelected(false);
            chDateX.setSelected(false);
        } else {
            txtDate1.setEnabled(false);
            txtDate2.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chDateYActionPerformed

    private void chDateXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chDateXActionPerformed
        if (chDateX.isSelected()) {
            txtDate1.setEnabled(true);
            txtDate2.setEnabled(false);
            chDeuxDate.setSelected(false);
            chUneDate.setSelected(false);
            chDateY.setSelected(false);
        } else {
            txtDate1.setEnabled(false);
            txtDate2.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chDateXActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String[] entete = {"Code barre", "Caisse", "Produit", "Quantité", "Date fabrication"};
            Object[] row = new Object[5];
            dtm = new DefaultTableModel(null, entete);
            st = new ConnectDataBase().getConnexion().createStatement();
            if (chAct.isSelected() && chUneDate.isSelected() == false && chDeuxDate.isSelected() == false && chDateY.isSelected() == false && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where produit.libprod='" + cmbProd.getSelectedItem() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() && chUneDate.isSelected() && chDeuxDate.isSelected() == false && chDateY.isSelected() == false && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where produit.libprod='" + cmbProd.getSelectedItem() + "' and stocker.datestock='" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() == false && chUneDate.isSelected() && chDeuxDate.isSelected() == false && chDateY.isSelected() == false && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where stocker.datestock='" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() == false && chUneDate.isSelected() == false && chDeuxDate.isSelected() && chDateY.isSelected() == false && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where stocker.datestock between '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "' and '" + ((JTextField)txtDate2.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() && chUneDate.isSelected() == false && chDeuxDate.isSelected() && chDateY.isSelected() == false && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where produit.libprod='" + cmbProd.getSelectedItem() + "' and stocker.datestock between '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "' and '" + ((JTextField)txtDate2.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() == false && chUneDate.isSelected() == false && chDeuxDate.isSelected() == false && chDateY.isSelected() && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where stocker.datestock < '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() && chUneDate.isSelected() == false && chDeuxDate.isSelected() == false && chDateY.isSelected() && chDateX.isSelected() == false) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where produit.libprod='" + cmbProd.getSelectedItem() + "' and stocker.datestock < '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() == false && chUneDate.isSelected() == false && chDeuxDate.isSelected() == false && chDateY.isSelected() == false && chDateX.isSelected()) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where stocker.datestock > '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            } else if (chAct.isSelected() && chUneDate.isSelected() == false && chDeuxDate.isSelected() == false && chDateY.isSelected() == false && chDateX.isSelected()) {
                rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod where produit.libprod='" + cmbProd.getSelectedItem() + "' and stocker.datestock > '" + ((JTextField)txtDate1.getDateEditor().getUiComponent()).getText() + "'");
                        while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    dtm.addRow(row);
                }
            }
            tabFac.setModel(dtm);
            tabFac.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabFac.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabFac.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabFac.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabFac.getColumnModel().getColumn(4).setPreferredWidth(150);
            rs.close();
            st.close();
        } catch (SQLException e) {
            cg.boiteDeDialogue(e.toString(), "erreur");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void arrayFacture() {
        try {
            String[] entete = {"Code barre", "Caisse", "Produit", "Quantité", "Date fabrication"};
            Object[] row = new Object[5];
            dtm = new DefaultTableModel(null, entete);
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select stocker.codebar,utilisateur.noms,produit.libprod,stocker.qte,stocker.datestock from stocker inner join utilisateur on utilisateur.coduti=stocker.coduti inner join produit on produit.codprod=stocker.codprod");
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[2] = rs.getObject(5);
                dtm.addRow(row);
            }
            tabFac.setModel(dtm);
            tabFac.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabFac.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabFac.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabFac.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabFac.getColumnModel().getColumn(4).setPreferredWidth(150);
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
            java.util.logging.Logger.getLogger(ListeEntre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeEntre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeEntre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeEntre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListeEntre dialog = new ListeEntre(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox chAct;
    private javax.swing.JCheckBox chDateX;
    private javax.swing.JCheckBox chDateY;
    private javax.swing.JCheckBox chDeuxDate;
    private javax.swing.JCheckBox chUneDate;
    private javax.swing.JComboBox<String> cmbProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFac;
    private com.toedter.calendar.JDateChooser txtDate1;
    private com.toedter.calendar.JDateChooser txtDate2;
    // End of variables declaration//GEN-END:variables
}
