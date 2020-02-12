/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Order;
import Utiles.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ServiceOrder {
     Connection c=ConnexionBD.getinstance().getcnx();
        public void ajouterOrder(Order o) {
        Statement st;
        try {
            st = c.createStatement();
            String req = " INSERT INTO `order`(`nbr_Order`, `Ide_Bike`, `Ide_Panier`, `Ide_Equipement`,`Id_Client`, `Date`) VALUES(" +o.getnbr_Order()  + ",'" + o.getIde_Bike()+ "','" + o.getIde_Equipement()+"','"+ o.getIde_Panier()+"','"+ o.getId_Client()+"','" + o.getDate()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
        public void afficherOrder() {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("SELECT * FROM `order`");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("order [Id_Order :" + rs.getInt(1) + ",nbr_Order:" + rs.getInt(2) + ",Ide_Equipement:" + rs.getInt(3)+ ",Ide_Bike:" + rs.getInt(4)+ ",Ide_Panier:" + rs.getInt(5)+",Id_Client:" + rs.getInt(6)+ ",Date:" + rs.getString(7)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

   
    }
         public void modifierOrder(int Id_Order, int nbr_Order, int Ide_Equipement, int Ide_Bike,int Ide_Panier,int Id_Client,String Date) {
        try {
            PreparedStatement pt = c.prepareStatement("UPDATE `order` SET `nbr_Order`=? , `Ide_Equipement`=? , `Ide_Bike`=? , `Ide_Panier`=? ,`Id_Client`=? , `Date`=? where Id_Order=?");
            pt.setInt(1, nbr_Order);
            pt.setInt(2, Ide_Equipement);
            pt.setInt(3, Ide_Bike);
            pt.setInt(4, Ide_Panier);
            pt.setInt(5, Id_Client);
            pt.setString(6, Date);
            pt.setInt(7, Id_Order);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void supprimerOrder(int Id_Order) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("DELETE FROM `order` WHERE Id_Order=? ");
            pt.setInt(1,Id_Order);
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
     

