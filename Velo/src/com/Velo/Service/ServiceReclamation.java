package com.Velo.Service;

import com.Velo.Entite.Reclamation;
import com.Velo.Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceReclamation {



    private Connection con;
    private Statement ste;

    public ServiceReclamation() {
        con = DataBase.getInstance().getConnection();

    }



    // Add Reclamation :
    public void ajouterRec(Reclamation rec) throws SQLException
    {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `apres_vente`.`reclamation` ( `IdReclamation`, `description`) VALUES ( ?, ?);");
        pre.setInt(1, rec.getIdReclamation());
        pre.setString(2, rec.getDescription());
        pre.executeUpdate();
        System.out.println("Reclamation Added successfully !!! " + con.getAutoCommit());
    }

    //update Reclamation :
    public void updateRec(String description, int idReclamation) throws SQLException {

        String query = "UPDATE `apres_vente`.`reclamation` SET description = ? "
                + " where idReclamation = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, idReclamation);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("updated SUCCESSFULLY !!! →  " + idReclamation);

        }catch(SQLException e){e.printStackTrace();}}



    // delete reclamation :
    public void deleteRec(int idrec) throws SQLException {

        String deletequery = "DELETE FROM `apres_vente`.`reclamation` where idReclamation = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(deletequery);
            preparedStatement.setInt(1, idrec);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println(" Reclamation id : " + idrec + " was  deleted successfully !!!");

        } catch (SQLException e) { e.printStackTrace(); }
    }



    //afficher Reclamation :
        public List<Reclamation> readAllRec() throws SQLException{
            List<Reclamation> arr=new ArrayList<>();
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from reclamation");
            while (rs.next()) {
                int IdReclamation = rs.getInt(1);
                String description = rs.getString("description");


                Reclamation r=new Reclamation(IdReclamation, description);
                arr.add(r);
            }
            return arr;
    }


}
