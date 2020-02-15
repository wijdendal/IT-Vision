package com.Velo.Service;

import com.Velo.Entite.Appointement;
import com.Velo.Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppointement {


    private Connection con;
    private Statement ste;

    public ServiceAppointement() {
        con = DataBase.getInstance().getConnection();

    }

    /*
    public void ajouter1App(Appointement a) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `apres_vente`.`appointement` ( null,`date`, `description`) VALUES (null,'" + a.getDate() + "', '" + a.getDescription() + "');";
        ste.executeUpdate(requeteInsert);
        System.out.println("adding appointement was executed ? : " +  con.getAutoCommit());
    }
    */

    //add apointement
    public void ajouterApp(Appointement a) throws SQLException
    {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `apres_vente`.`appointement` (`idappointement`, `date`, `description`) VALUES ( ?, ?, ?);");
        pre.setInt(1, a.getIdAppointement());
        pre.setString(2, a.getDate());
        pre.setString(3, a.getDescription());
        pre.executeUpdate();
        System.out.println("Appointement was added  : " +  con.getAutoCommit());
    }

    //Update Appointement
    public void updateApp(String date, String description, int idappointement) throws SQLException {

        String query = "UPDATE `apres_vente`.`appointement` SET date = ?, description = ?"
                + " where idappointement = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, idappointement);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Appointement number → "+ idappointement +" was updated : " + con.getAutoCommit());
        }catch(SQLException e){e.printStackTrace();}}


    //Delete Appointement
    public void deleteApp(int idappointement) throws SQLException {

        String deletequery = "DELETE FROM `apres_vente`.`appointement` where idappointement = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(deletequery);

            preparedStatement.setInt(1, idappointement);
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Appointement number → " + idappointement + " was deleted successfully ? :    → "  + con.getAutoCommit());

        } catch (SQLException e) { e.printStackTrace(); }
    }

    //afficher Appointement

    public List<Appointement> readAllApp() throws SQLException{
        List<Appointement> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from appointement");
        while (rs.next()) {
            int idappointement=rs.getInt("idappointement");
            String date=rs.getString("date");
            String description=rs.getString("description");
            Appointement a = new Appointement(idappointement,date,description);
            arr.add(a);
        }
        return arr;
    }

}
