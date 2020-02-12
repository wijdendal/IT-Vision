/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_i;

import Entities.Bill;
import Entities.Order;
import Entities.ShoppingCart;
import Services.ServiceBill;
import Services.ServiceOrder;
import Utiles.ConnexionBD;
import java.sql.Connection;
import Services.ServiceShoppinCart;

import Utiles.mailing;
import java.sql.SQLException;
import javax.mail.MessagingException;

/**
 *
 * @author ACER
 */
public class Pi_i {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, MessagingException {
        // TODO code application logic here
        
        ShoppingCart SC=new ShoppingCart(2);
        ServiceShoppinCart srv =new ServiceShoppinCart();
        
        //srv.ajoutershoppingcart(SC);
       // srv.affichershoppingcart();
        //srv.modifiershoppingcart(2,5);
        //srv.supprimershoppingcart(4);
        
       Bill b=new Bill(200,125012,125689,2003500);
        ServiceBill srv1 =new ServiceBill();
        //srv1.ajouterBill(b);+
        //srv1.afficherBill();
        //srv1.modifierBill(205,1001568,1023589,4050254,8);
       // srv1.afficherBill();
        //srv1.supprimerBill(6);
        
       Order o1 =new Order(40,100225, 125075, 150256,10012998,"28/2/2020");
        ServiceOrder srv2 =new ServiceOrder();
       //srv2.ajouterOrder(o1);
      //srv2.supprimerOrder(3);
        //srv2.modifierOrder(2,20,"21/2/2020",200,5696,4254);
          //srv2.afficherOrder();
        
        mailing.sendMail("ines.jeddey@esprit.tn");
}} 
