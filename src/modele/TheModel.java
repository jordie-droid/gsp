/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jordie
 */
public class TheModel extends AbstractTableModel {

    String[] colonnes;
    Object[][] lignes;
    String table;

    public TheModel(String table) {
        this.table = table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public TheModel(String table, Object[][] donnees, String[] colonnes) {
        this.table = table;
        this.colonnes = colonnes;
        this.lignes = donnees;
    }

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public int getRowCount() {
        return this.lignes.length;
    }

    @Override
    public int getColumnCount() {
        return this.colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.lignes[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int col) {
        return this.colonnes[col];
    }

}
