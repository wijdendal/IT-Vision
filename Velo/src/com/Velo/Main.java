package com.Velo;

import com.Velo.Entite.Personne;
import com.Velo.Service.ServicePersonne;
import java.sql.*;
import java.util.List;
import com.Velo.Utils.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;


                        //Project Version 1.0
public class Main {

    public static void main(String[] args) {

                ServicePersonne ser = new ServicePersonne();

                Personne p1 = new Personne("alex", "simpson", 10);
                Personne p2 = new Personne("john", "Wick", 28);
                Personne p3 = new Personne("james","Jordan",30);
                int idd=15;

                try {
                    //ser.ajouter(p2);
                   // ser.ajouter(p1);
                    ser.delete(idd);
                    ser.delete(idd);
                    ser.updateDB("Ammar","Marzougi",60,3);
                    List<Personne> list = ser.readAll();
                    System.out.println(list);




                } catch (SQLException ex) {   System.out.println(ex);    }
            }

        }

