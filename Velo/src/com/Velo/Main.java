package com.Velo;

import com.Velo.Entite.*;
import com.Velo.Service.*;

import java.sql.*;
import java.util.List;

import com.Velo.Utils.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;


                        //PI DEV Project Version 1.0
public class Main {

    public static void main(String[] args) {

                    /****↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  PERSONNE/DELIVERYMAN SERVICE ↓↓↓↓↓↓↓↓↓↓↓↓↓***/
                    ServicePersonne ser = new ServicePersonne();
                    Personne p1 = new Personne("Mohamed", "Amine", 22);
                    Personne p2 = new Personne("Michael", "Jackson", 70);
                    Personne p3 = new Personne("John","Wick",30);
                    int idd=15;

                    /****↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  APPOINTEMENT SERVICE ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓***/
                     ServiceAppointement serapp = new ServiceAppointement();
                     Appointement a = new Appointement("01/03/2020","Desciption d'un Appointement without idapp ");
                     Appointement a1 = new Appointement(1,"01/03/2020","Desciption d'un Appointement number → 1 ");
                     Appointement a2 = new Appointement(2,"29/04/2020","Rendez-Vous Num 2 ");
                     Appointement a3 = new Appointement(3,"10/05/2021","Appointement to be modified");
                     int idapp = 1;

                    /****↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ DELIVERY ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓***/
                    ServiceDelivery serdeliv = new ServiceDelivery();
                    Delivery d1 = new Delivery(1,122,53,"description de delivery ajouter !!! ");
                    int iddeliv = 1;

                    /****↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ Reclamation ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓***/
                    ServiceReclamation serrec = new ServiceReclamation();
                    Reclamation r1 = new Reclamation(2,"Description de reclamation");
                    int idrec = 1;

                    /****↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ Repair↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓***/
                    ServiceRepair serrep = new ServiceRepair();
                    Repair rep1 = new Repair(10,111);
                    int idrep = 1;


        try {
                     /***↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ Personne/DeliveryMan ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

                    //ser.ajouter(p2);
                    //ser.ajouter(p1);
                   // ser.delete(3);
                   // ser.delete(idd);
                   //ser.updateDB("Faouzi","jaidi",10,4);
                   List<Personne> list = ser.readAll();
                   System.out.println(list);


                   /***↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Appointement  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
                   // serapp.ajouterApp(a);
                   // serapp.ajouterApp(a1);
                   // serapp.updateApp("02/02/2020","descrip...was updated.",1);
                   // serapp.deleteApp(idapp);
                   // List<Appointement> listapp = serapp.readAllApp();
                   // System.out.println( "Appointement : id   +    date   +       description : \n"+ listapp); //table output print
                   // System.out.println(listapp); //print in sameline.


                   /***↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Delivery  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

                    // List<Delivery> listdeliv = serdeliv.readAllDeliv();
                   //  System.out.println(listdeliv);
                  // serdeliv.ajouterDeliv(d1);
                  // serdeliv.updateDeliv(111,111,"description has been updated !",1);
                  // serdeliv.deleteDeliv(1);



                   /***↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Reclamation  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

                    //serrec.ajouterRec(r1);
                    //serrec.updateRec("UPDATED DESCRIPTION !!! ",idrec);
                    //serrec.deleteRec(1);
                    //List<Reclamation> listrec = serrec.readAllRec();
                    //System.out.println(listrec);


                   /***↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Repair  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
                   //serrep.ajouterRep(rep1);
                   //serrep.updateRep(8173,10);
                   //serrep.deleteRep(10);
                   // List<Repair> listrep = serrep.readAllRep();
                   //System.out.println(listrep);



                } catch (SQLException ex) {   System.out.println(ex);    }
            }

        }

