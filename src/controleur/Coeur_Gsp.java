/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordie
 */
public class Coeur_Gsp {

    Statement st;
    ResultSet rs;
    int nouvelleLigne;
    int ligne;
    private int identifiant;
    private String codprod, verdate = "";
    String entete[] = {"", "", "", "", "", "", "", ""};
    Object row[] = new Object[8];
    private DefaultTableModel dtm;

    public String optimiser(JTextField mazone) {
        return mazone.getText().toUpperCase().replace("'", "''");
    }

    public void boiteDeDialogue(String message, String type) {
        if (type.equalsIgnoreCase("erreur")) {
            JOptionPane.showMessageDialog(null, message, "GSP : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else if (type.equalsIgnoreCase("information")) {
            JOptionPane.showMessageDialog(null, message, "GSP : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, message, "GSP : AVERTISSEMENT", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void initialisationFiche(String madate) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            dtm = new DefaultTableModel(null, entete);
            rs = st.executeQuery("select * from produit");
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
            for (int i = 0; i < dtm.getRowCount(); i++) {
                rs = st.executeQuery("select max(dateenr) from fichedestock where codprod= '" + dtm.getValueAt(i, 0) + "'");
                while (rs.next()) {
                    verdate = rs.getString(1);
                }
                if (verdate.equals(madate)) {

                } else {
                    st.executeUpdate("insert into fichedestock values('" + nouvelleLigne("codnum", "fichedestock") + "','" + dtm.getValueAt(i, 0) + "','" + madate + "','" + 0 + "','" + getPaUnitaire(Integer.parseInt(dtm.getValueAt(i, 0).toString())) + "','" + 0 + "','" + getPvUnitaire(Integer.parseInt(dtm.getValueAt(i, 0).toString())) + "','" + 0 + "','" + 0 + "')");
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public String getCodrod(String codebar) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select produit.codprod from produit inner join stocker on stocker.codprod=produit.codprod where stocker.codebar ='" + codebar + "'");
            while (rs.next()) {
                codprod = rs.getString(1);
            }
            rs.close();
            st.close();
            return codprod;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return "";
        }
    }

    public int nouvelleLigne(String colonne, String table) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select max(" + colonne + ") from " + table + "");
            while (rs.next()) {
                nouvelleLigne = rs.getInt(1);
            }
            rs.close();
            st.close();
            return nouvelleLigne + 1;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0;
        }
    }

    public void remplirCombo(String colonne, String table, JComboBox monCombo) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select " + colonne + " from " + table + "");
            while (rs.next()) {
                monCombo.addItem(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public void remplirComboDevPrin(String colonne, String table, JComboBox monCombo) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select " + colonne + " from " + table + " where base = 1");
            while (rs.next()) {
                monCombo.addItem(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public void remplirComboClient(String colonne, String table, JComboBox monCombo) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select " + colonne + " from " + table + " where codcli != 0");
            while (rs.next()) {
                monCombo.addItem(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public int retournerIdentifiant(String colonne, String clef, String table, JComboBox monCombo) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select " + colonne + " from " + table + " where " + clef + "='" + monCombo.getSelectedItem().toString().replace("'", "''") + "'");
            while (rs.next()) {
                identifiant = rs.getInt(1);
            }
            rs.close();
            st.close();
            return identifiant;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0;
        }
    }

    public int ligne(String colonne, String table, String noms, String clef) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select " + colonne + " from " + table + " where " + clef + "='" + noms + "'");
            while (rs.next()) {
                ligne = rs.getInt(1);
            }
            rs.close();
            st.close();
            return ligne;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0;
        }
    }

    public void miseAjour(String req) {
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            st.executeUpdate(req);
            st.close();
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
        }
    }

    public double getPaUnitaire(String valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu * produit.tva/100)) from produit where libprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPvUnitaireHT(String valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu*produit.mb/100)) from produit where libprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPvUnitaire(String valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu*produit.mb/100)) + (produit.pu+(produit.pu*produit.mb/100))*produit.tva/100 from produit where libprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPvUnitaire(int valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu*produit.mb/100)) + (produit.pu+(produit.pu*produit.mb/100))*produit.tva/100 from produit where produit.codprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPaUnitaireCodebarre(String valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu * produit.tva/100)) from produit inner join stocker on stocker.codprod=produit.codprod where stocker.codebar='" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPvUnitaireCodebarre(String valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu*produit.mb/100)) + (produit.pu+(produit.pu*produit.mb/100))*produit.tva/100 from produit inner join stocker on stocker.codprod=produit.codprod where stocker.codebar='" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPaUnitaire(int valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu * produit.tva/100)) from produit where produit.codprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPvUnitaireHT(int valeur) {
        try {
            double pu = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select (produit.pu+(produit.pu*produit.mb/100)) from produit where libprod = '" + valeur + "'");
            while (rs.next()) {
                pu = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pu;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getTaux(String myrech) {
        try {
            double taux = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select devise.taux from devise where devise.libdev='" + myrech + "'");
            while (rs.next()) {
                taux = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return taux;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getTauxBase() {
        try {
            double taux = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select devise.taux from devise where devise.base='" + 1 + "'");
            while (rs.next()) {
                taux = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return taux;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public double getPTTC(String valeur) {
        try {
            double pt = 0.0;
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select sum(((produit.pu+(produit.pu*produit.mb/100)) + (produit.pu+(produit.pu*produit.mb/100))*produit.tva/100) * tmvm.qte) from tmvm inner join stocker on stocker.codebar=tmvm.codbar inner join produit on produit.codprod=stocker.codprod");
            while (rs.next()) {
                pt = rs.getDouble(1);
            }
            rs.close();
            st.close();
            return pt;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return 0.0;
        }
    }

    public String getDevBase() {
        try {
            String dev = "";
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select libdev from devise where base = '" + 1 + "'");
            while (rs.next()) {
                dev = rs.getString(1);
            }
            rs.close();
            st.close();
            return dev;
        } catch (SQLException e) {
            boiteDeDialogue(e.toString(), "erreur");
            return "";
        }
    }
}
