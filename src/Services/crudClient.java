/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.ConnexionBD;
import entities.GUser;
import entities.gclient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author taieb
 */
public class crudClient {
        private Connection con = ConnexionBD.getinstance().getcnx();

    public void ajouterPersonne(gclient p) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into client values ("+ p.getId()+",'"+ p.getFname()+"','"+p.getLname()+"','"+p.getEmail()+"','"+p.getPassword()+"','"+p.getAddress()+"',"+p.getPhone()+",'"+p.getPicture()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(crudClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<gclient> getAll()
    {
        List<gclient> g = new ArrayList<>();
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from client");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                gclient c = new gclient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                g.add(c);
              //  System.out.println("Client [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+"Password"+rs.getString(5)+"addresse"+rs.getString(6)+", NumTel"+ rs.getInt(7)+"Image"+rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(crudClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    public void afficherPersonne() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from client");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Client [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+"Password"+rs.getString(5)+"addresse"+rs.getString(6)+", NumTel"+ rs.getInt(7)+"Image"+rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(crudClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 public void modifierPersonne(int id, gclient pm) {
        try {
            PreparedStatement pt = con.prepareStatement("update client set Fname=? , Lname = ? , email = ?, password = ?, phone=?, picture = ? where idClient=?");
            pt.setString(1, pm.getFname());
            pt.setString(2, pm.getLname());
            pt.setString(3,pm.getEmail());
            pt.setString(4,pm.getPassword());
            pt.setInt(5, pm.getPhone());
            pt.setString(6,pm.getPicture());
            
            pt.setInt(7, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(crudClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerPersonne(gclient p) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from client where idClient=? ");
            pt.setInt(1, p.getId());
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(crudClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    
    
}
