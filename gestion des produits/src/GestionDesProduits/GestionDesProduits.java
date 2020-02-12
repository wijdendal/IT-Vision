/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDesProduits;

import entities.Velo_a_louer;
import entities.Velo_a_vendre;
import entities.location;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import services.Service_velo_a_louer;
import services.Service_velo_a_vendre;
import services.Service_velo_location;


/**
 *
 * @author mh
 */
public class GestionDesProduits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date d3 = sd.parse("2019/2/22 12:05:12");
        Timestamp ts=new Timestamp(d3.getTime());  
       
        
Timestamp dd = new Timestamp(System.currentTimeMillis());       
Timestamp df = new Timestamp(System.currentTimeMillis());

        
        location l=new location(33, ts, df); 
        
        Velo_a_louer vl=new Velo_a_louer(33, 2, "lmo", "//kjhkkj/lmp", "kkk", 2);
        
        Velo_a_vendre vv=new Velo_a_vendre(2, 8, "kkk", "kkk", "llll", 45);
        
    Service_velo_location loc=new Service_velo_location();   
    Service_velo_a_louer ser=new Service_velo_a_louer();
    Service_velo_a_vendre serv =new Service_velo_a_vendre();
    
        //serv.ajoutervelo_a_louer(vv);
       // serv.supprimervelo_a_vendre(2);
    
        //ser.ajoutervelo_a_louer(vl);
        //ser.supprimervelo_a_louer(33);
        //ser.affichervelo_a_louer();
       ser.VerifierProduits();
        //ser.modifiervelo_a_louer(vl);
        //ser.maxproduit();
        //ser.rechercheparmarque();
        
        //loc.verifier_dispo_location(ts);
                //loc.ajoutervelo_a_louer(l);
               //loc.nombreheure(1);
               //loc.metrre_a_jour_location();
               //loc.supprimerlocation(33);

        
        
      
       
        
        
    }
    
}
