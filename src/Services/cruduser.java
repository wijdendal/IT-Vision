/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.ConnexionBD;
import entities.GUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taieb
 */
public class cruduser {
        private Connection con = ConnexionBD.getinstance().getcnx();

    public void ajouterPersonne(GUser p) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into personne values (" + p.getId() + "," + p.getFname() + "," + p.getLname() + "," + p.getEmail() + "," + p.getPassword() +"," + p.getPicture() + " )";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherPersonne() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from personne");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Personne [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierPersonne(int identifiant, String nom) {
        try {
            PreparedStatement pt = con.prepareStatement("update personne set nom=?where identifiant=?");
            pt.setString(1, nom);
            pt.setInt(2, identifiant);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerPersonne(GUser p) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from personne where identifiant=? ");
            pt.setInt(1, p.getId());
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
