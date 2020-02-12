/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.gform;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionBD;

/**
 *
 * @author taieb
 */
public class crudform {
     private Connection con = ConnectionBD.getInstance().getCnx();

    public void ajouterPersonne(gform p) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into formateur values (" + p.getId() + "," + p.getFname() + "," + p.getLname() + "," + p.getEmail() + "," + p.getPassword() +"," + p.getPicture() + " )";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(gform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherPersonne() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from formateur");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Formateur [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+", NumTel"+ rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(gform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierPersonne(int id, String Fname) {
        try {
            PreparedStatement pt = con.prepareStatement("update formateur set Fname=?where id=?");
            pt.setString(1, Fname);
            pt.setInt(2, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(gform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerPersonne(gform p) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from formateur where id=? ");
            pt.setInt(1, p.getId());
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(gform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
