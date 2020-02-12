/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_i;

import com.sun.security.ntlm.Client;
import entities.GUser;
import entities.gclient;
import services.crudClient;
import entities.GUser;
import entities.gform;
import services.crudform;
import java.sql.Connection;

/**
 *
 * @author taieb
 */
public class pi_i {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    gclient p1 = new gclient (1,"ines","jeddey","ines@gmail.com","@pic",7459,"ariana");
    gform p2 = new gform (2,"wijden","dalhoumi","wijden@esprit.tn","@pic",7412,"ariana");
        crudClient srv = new crudClient();
        crudform srv1 = new crudform();
        srv.ajouterPersonne(p1);
       // srv1.ajouterPersonne(p2);
      //  System.out.println("affichage");
      //  srv.afficherPersonne();
       // srv.modifierPersonne(2, "hamadi");
        
      //  System.out.println("affichage");
        srv.afficherPersonne();
     //   srv.supprimerPersonne(p1);
    
    }
    
}
