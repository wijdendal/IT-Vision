package com.Velo.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public  static DataBase db;
    public Connection con;

        String url = "jdbc:mysql://localhost:3306/apres_vente";
        String login = "root";
        String pwd = "root";

        private DataBase() {
            try {
                con=DriverManager.getConnection(url, login, pwd);
                System.out.println("YOU ARE CONNECTED TO DataBase  →  : " + con.getCatalog());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        public Connection getConnection()
        {
            return con;
        }
        public static DataBase getInstance()
        {if(db==null)
            db=new DataBase();
            return db;
        }
    }