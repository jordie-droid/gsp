/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jordie
 */
public class ConnectDataBase {

    Connection con;
    private Coeur_Gsp cg = new Coeur_Gsp();

    public Connection getConnexion() {
        try {
//            Class.forName("org.sqlite.JDBC");
//            con = DriverManager.getConnection("jdbc:sqlite:gsp.db");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gsp";
            con = DriverManager.getConnection(url);
//            , "jordie1", "a1z2e88r000"
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            cg.boiteDeDialogue(e.toString(), "erreur");
            System.exit(0);
            return null;
        }
    }

}
