/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Event;
import View.Launch;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Benny
 */
public class Test2Controller implements Initializable {

    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Forum;
    @FXML
    private Button Charity;
    @FXML
    private Pane pane1;

   

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        
    }

   


    
     

   /* @FXML
    private void OpenMehdi(ActionEvent event) {
         
             
 FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Ecommerce.fxml"));
            try {
                Parent root = loader.load();         
                Scene Mehdi = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Mehdi);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }*/  
    @FXML
    public void OpenEvents (ActionEvent event) throws SQLException
    {
       FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Event.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

   

   

    

}
    

