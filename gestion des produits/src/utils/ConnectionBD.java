/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mh
 */
public class ConnectionBD {

    private static String url = "jdbc:mysql://localhost:3306/Baskla";
    private static String utilisateur = "root";
    private static String motDePasse = "";
    private static Connection cnx;
    private static ConnectionBD cbd;
    
    public static Connection getCnx() {
        return cnx;
    }

    private ConnectionBD() {

        try {
            cnx = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connection etablie");
        } catch (SQLException ex) {
            System.out.println("erreur : " + ex.getMessage());
        }

    }
    public static ConnectionBD getInstance(){
        if (cbd==null)
            cbd = new ConnectionBD();
        return cbd;
    }

}
