package com.Velo.Service;


import com.Velo.Entite.Personne;
import com.Velo.IService.IService;
import com.Velo.Utils.DataBase;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;

import java.util.ArrayList;

public class ServicePersonne implements IService<Personne>{


    private Connection con;
    private Statement ste;

    public ServicePersonne() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter1(Personne t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `apres_vente`.personne (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "');";
        ste.executeUpdate(requeteInsert);
        System.out.println("Added successfully by ajouter1");
    }
    public void ajouter(Personne p) throws SQLException
    {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `apres_vente`.`personne` ( `nom`, `prenom`, `age`) VALUES ( ?, ?, ?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getPrenom());
        pre.setInt(3, p.getAge());
        pre.executeUpdate();
        System.out.println("Added successfully by ajouter()");
    }

    public void updateDB(String nom, String prenom, int age, int id) throws SQLException {

        String query = "UPDATE `apres_vente`.`personne` SET nom = ?, prenom = ?, age = ? "
                + " where id = ? ";
       try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("updated SUCCESSFULLY !!! →  " + id);
        }catch(SQLException e){e.printStackTrace();}}



        public void delete(int idd) throws SQLException {

            String deletequery = "DELETE FROM `apres_vente`.`personne` where id = ?";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(deletequery);

                preparedStatement.setInt(1, idd);
                preparedStatement.execute();
                preparedStatement.close();
                System.out.println("DELETED SUCCESSFULLY !!! " + idd);

            } catch (SQLException e) { e.printStackTrace(); }
        }



        @Override
        public List<Personne> readAll() throws SQLException{
            List<Personne> arr=new ArrayList<>();
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from personne");
            while (rs.next()) {
                int id=rs.getInt(1);
                String nom=rs.getString("nom");
                String prenom=rs.getString(3);
                int age=rs.getInt("age");
                Personne p=new Personne(id, nom, prenom, age);
                arr.add(p);
            }
            return arr;
        }
    }

