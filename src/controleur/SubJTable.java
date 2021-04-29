/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Pascal_De_Marie
 */
public class SubJTable extends DefaultTableCellRenderer {

    Component component;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        if (row % 2 == 0) {
            component.setBackground(new Color(255, 255, 255));
        } else {
            component.setBackground(new Color(104,151,215));
            //component.setBackground(new Color(156, 181, 225));
            //component.setBackground(new Color(199,235,209));
            component.setForeground(new Color(255, 255, 255));
        }
        if (isSelected) {
            component.setBackground(new Color(204, 204, 204));
            component.setForeground(new Color(0, 0, 0));
        }
        return component;
    }
}
