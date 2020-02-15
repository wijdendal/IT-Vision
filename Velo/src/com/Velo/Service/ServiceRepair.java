package com.Velo.Service;

import com.Velo.Entite.Repair;
import com.Velo.Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepair {



    private Connection con;
    private Statement ste;

    public ServiceRepair() {
        con = DataBase.getInstance().getConnection();

    }

    // add Repair :
    public void ajouterRep(Repair rep) throws SQLException
    {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `apres_vente`.`repair` ( `IdRepair`, `IdBike`) VALUES ( ?, ?);");
        pre.setInt(1, rep.getIdRepair());
        pre.setInt(2, rep.getIdBike());
        pre.executeUpdate();
        System.out.println("Repair was added successfully !!! ");
    }

    //update Repair :
    public void updateRep(int IdBike, int IdRepair) throws SQLException {

        String query = "UPDATE `apres_vente`.`repair` SET IdBike = ? "
                + " where IdRepair = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(2, IdRepair);
            preparedStatement.setInt(1, IdBike);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println(" Repair  Number →  " + IdRepair + "  was Updated successfully !!! :  " + con.getAutoCommit());
        }catch(SQLException e){e.printStackTrace();}}


    //delete repair :
    public void deleteRep(int IdRepair) throws SQLException {

        String deletequery = "DELETE FROM `apres_vente`.`repair` where IdRepair = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(deletequery);
            preparedStatement.setInt(1, IdRepair);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Repair Number" + IdRepair +" WAS DELETED SUCCESSFULLY !!! : " + con.getAutoCommit());

        } catch (SQLException e) { e.printStackTrace(); }
    }



    //Afficher Repair :
    public List<Repair> readAllRep() throws SQLException{
        List<Repair> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from repair");
        while (rs.next()) {
            int IdRepair=rs.getInt(1);
            int IdBike=rs.getInt(2);

            Repair rep=new Repair(IdRepair, IdBike);
            arr.add(rep);
        }
        return arr;
    }

}
