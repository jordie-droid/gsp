/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jordie
 */
public class ArrayClient {

    public ArrayClient() {

    }

    public ArrayList<Client> BindTable() {
        ArrayList<Client> list = new ArrayList<Client>();
        Statement st;
        ResultSet rs;
        try {
            st = new ConnectDataBase().getConnexion().createStatement();
            rs = st.executeQuery("select * from clients");
            Client c;
            while (rs.next()) {
                c = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                list.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {

        }
        return list;
    }
}
