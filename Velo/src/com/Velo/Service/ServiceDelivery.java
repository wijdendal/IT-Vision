package com.Velo.Service;

import com.Velo.Entite.Delivery;
import com.Velo.Utils.DataBase;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDelivery {

    private Connection con;
    private Statement ste;

    public ServiceDelivery() {
        con = DataBase.getInstance().getConnection();
    }


    // add delivery :
    public void ajouterDeliv(Delivery d) throws SQLException
    {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `apres_vente`.`delivery` ( `IdDelivery`, `IdClient`, `IdBike`, `description`) VALUES ( ?, ?, ?, ?);");
        pre.setInt(1, d.getIdDelivery());
        pre.setInt(2, d.getIdClient());
        pre.setInt(3, d.getIdBike());
        pre.setString(4,d.getDescription());
        pre.executeUpdate();
        System.out.println("delivery was added successfully  :  " + con.getAutoCommit());


    }
    // update delivery :
    public void updateDeliv( int IdClient, int IdBike, String description, int IdDelivery) throws SQLException {

        String query = "UPDATE `apres_vente`.`delivery` SET IdClient = ? , IdBike = ? , description = ? "
                + " where idDelivery = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, IdClient);
            preparedStatement.setInt(2, IdBike);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, IdDelivery);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("updated successfully : " + con.getAutoCommit() + "   Delivery id : " + IdDelivery);
        }catch(SQLException e){e.printStackTrace();}}


    // delete delivery :
    public void deleteDeliv(int iddeliv) throws SQLException {

        String deletequery = "DELETE FROM `apres_vente`.`delivery` where idDelivery = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(deletequery);
            preparedStatement.setInt(1, iddeliv);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("DELETED SUCCESSFULLY !!! →  " + iddeliv);

        } catch (SQLException e) { e.printStackTrace(); }
    }



    //afficher delivery :
    public List<Delivery> readAllDeliv() throws SQLException{
        List<Delivery> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from delivery");
        while (rs.next()) {
            int IdDelivery = rs.getInt(1);
            int IdClient = rs.getInt(2);
            int IdBike = rs.getInt(3);
            String description = rs.getString("description");
            Delivery deliv = new Delivery(IdDelivery, IdClient, IdBike, description);
            arr.add(deliv);
        }
        return arr;
    }
}
