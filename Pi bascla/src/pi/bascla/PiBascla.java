/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.bascla;

import Entities.charity;
import Entities.participants;
import Entities.recycle;
import Entities.training;
import Services.servicecharity;
import Services.serviceparticipants;
import Services.servicerecycle;
import Services.servicetraining;
import Utils.ConnexionBD;
import Utils.mailing;
import java.sql.Connection;
import java.sql.SQLException;
import javax.mail.MessagingException;

/**
 *
 * @author Asus
 */
public class PiBascla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, MessagingException {
        // TODO code application logic here
       // training t1 = new training("13/12/12","Ari",1,"New training lessons");
       // servicetraining srv = new servicetraining();
      // srv.ajoutertraining(t1);
      //  srv.affichertraining();
        //srv.modifiertraining(7, "15/09/20", "tunis", 1, "jjj");
      //srv.supprimertraining(4);
     // srv.affichertraining();
   
    
    // srv.affichertraining();
      
   //participants p1 = new participants("wijden", 1 , 12);
    //serviceparticipants srv = new serviceparticipants();
  //  srv.search();
     // srv.maxpart();
      //srv.ajouterparticipants(p1);
     // srv.afficherparticipants();
   // srv.modifierparticipants(6,"iline",1,12);
   // srv.supprimerparticipants(6);
      //  srv.afficherparticipants();

      
   //  charity s1 = new charity(1,"xxx","desc","tunis") ;
   //  servicecharity srv = new servicecharity();
     
    //  srv.ajoutercharity(s1);
     // srv.affichercharity(); 
      //srv.modifiercharity(1, "vvv", "desc", "ariana");
     // srv.affichercharity();
     //srv.supprimercharity(1);
    // srv.affichercharity();
    
    
   // recycle r1 = new recycle(1,"xxx","ppp");
   // servicerecycle srv = new servicerecycle();
    
   // srv.ajouterrecycle(r1);
   // srv.afficherrecycle();
   //srv.modifierrecycle(1, "desc", "ppp");
  // srv.afficherrecycle();
 // srv.supprimerrecycle(1);
  //srv.afficherrecycle();
  
  //mailing.sendMail("wijden.dalhoumi@esprit.tn");
 
   
  
    }
    
}
