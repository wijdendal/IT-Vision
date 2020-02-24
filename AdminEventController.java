/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Event;
import Services.ServiceEvent;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class AdminEventController implements Initializable {

    /**@FXML   * Initializes the controller class.
     */
    @FXML
    private javafx.scene.control.TextField title;
    @FXML
    private javafx.scene.control.TextField description;
       
    @FXML
    private DatePicker date1;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Button ajouter;
    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Charity;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<?, ?> titre1;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> date;
   
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> pic;
    @FXML
    private TableColumn<?, ?> etat;
    @FXML
    private TableColumn<?, ?> capa;
   
    @FXML
    private TableColumn<?, ?> h1;
    @FXML
    private TableColumn<?, ?> h2;
   
    @FXML
    private Button img;
    @FXML
    private Label imgl;
 
    @FXML
    private TableColumn<?, ?> lieu1;
    @FXML
    private TextField ou;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TextField Rechercher;
    @FXML
    private Button weekly;
   @FXML
       JFXTimePicker H1 = new JFXTimePicker();
   @FXML
       JFXTimePicker H2 = new JFXTimePicker();
       
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
            ObservableList<String> options =
                   FXCollections.observableArrayList(
                           "Tournée",
                            "Compet" );
            combo.setItems(options);
            ServiceEvent srv = new ServiceEvent();
                img.setOnAction(this::upload_1);

          
        try {
 

afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    
    public void afficher()throws IOException, SQLException{
        ServiceEvent srv = new ServiceEvent();
        
            ObservableList obeListe = FXCollections.observableList(srv.readAll());
            
ServiceEvent Ev = new ServiceEvent();
int idd= Ev.id();

        titre.setCellValueFactory(new PropertyValueFactory<>("title"));
                titre1.setCellValueFactory(new PropertyValueFactory<>("Description"));

                       date.setCellValueFactory(new PropertyValueFactory<>("Date"));
               id.setCellValueFactory(new PropertyValueFactory<>("id"));

        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        pic.setCellValueFactory(new PropertyValueFactory<>("pic"));
        lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        capa.setCellValueFactory(new PropertyValueFactory<>("Capacite"));
 h1.setCellValueFactory(new PropertyValueFactory<>("heur_deb"));
        h2.setCellValueFactory(new PropertyValueFactory<>("heure_fin"));

                            

        table.setItems(obeListe);}
          
    @FXML
    public void ok(ActionEvent event) {
        
        

        String titre5 ;
                titre5=titre.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
                                          title.setText(titre5);
                 String a ;
                a=titre1.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        
                        description.setText(a);
                 String b ;
                b=lieu1.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        
        
                ou.setText(b);
                
               
         String h ;
                h=pic.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        imgl.setText(h);
                        
        String hi2 ;
                hi2=date.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate dateTime = LocalDate.parse(hi2, formatter);
String he ;
                he=h1.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        imgl.setText(h);
                        
        String he2 ;
                he2=h2.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               


date1.setValue(dateTime);

               
              
        
                

    }
    @FXML
     private void ajouter(ActionEvent event) throws IOException, SQLException {
        
        ServiceEvent srv = new ServiceEvent (); 
        System.out.println(imgl.getText());
        if (title.getText().isEmpty() || description.getText().isEmpty() || combo.getValue().isEmpty() || imgl.getText().isEmpty())
        {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Vous n'avez pas saisi tous les champs");
        Optional<ButtonType> action = alert.showAndWait();
     
        }
        
               LocalDate localDate = LocalDate.now();
 if(localDate.compareTo(date1.getValue())>0 )
         {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez saisi une mauvaise date");
        Optional<ButtonType> action = alert.showAndWait();
         }
                       String MSG = " l'évenement  " + titre1.getText() + "  qui est une  " + combo.getValue() + "  est consacré pour " + date1.getValue().toString() + "du" +H1.getValue().toString() + "jusqu'au" +H2.getValue().toString()  ;
                              
mail m =new mail();
  if(localDate.compareTo(date1.getValue())<0 && (!(title.getText().isEmpty() || description.getText().isEmpty() || combo.getValue().isEmpty() || imgl.getText().isEmpty())))
  { Event E = new Event(srv.id(),title.getText(),date1.getValue().toString(), "", "", description.getText(),combo.getValue(),"",imgl.getText(),0,ou.getText(),4);

        srv.ajouterEvent(E);
        afficher();
        
        m.mail(MSG);
  }
        
    }
     @FXML
     private void Rechercher() {

        Rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ServiceEvent sn = new ServiceEvent();
                ObservableList obeListe = FXCollections.observableList(sn.RA(newValue));
                table.setItems(obeListe);
            } catch (SQLException ex) {
                Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       

        });
    }

    @FXML
    private void upload_1(ActionEvent event) {
    
        FileChooser F = new FileChooser();
        F.setTitle("image drapeaue");
        F.getExtensionFilters().addAll();
        File selectedFile = F.showOpenDialog(imgl.getScene().getWindow());
        
        if(selectedFile != null){
            
            imgl.setText(selectedFile.getName());
        }
        
    }
      /*@FXML
  public static void choose(ActionEvent event) throws Exception
        {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null)
        {
            String fileExtension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."),selectedFile.getName().length());
           
            File source = new File(selectedFile.getPath());
            File dest = new File("C:\\wamp64\\www\\pi_bascla\\"+selectedFile.getName());
            System.out.println(selectedFile.getName());
                                       String filee ; 

                filee=selectedFile.getName();
                imgl.setText(filee);
               
           
        }}*/
@FXML
    private void supprimerF(ActionEvent event) {
        try {
            int idd ;
            idd=Integer.parseInt(id.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            ServiceEvent E = new ServiceEvent();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Comfirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            E.supprimerEvent(idd);
           
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void update(ActionEvent event) throws ParseException {
  


        try {
            
           int  id_ev =  Integer.parseInt(id.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            String t =title.getText();
            String t2=description.getText();
            String t3 =ou.getText();
            String t4 =combo.getValue();
            String t5 =date1.getValue().toString();
            String t6 =imgl.getText();
            Event E = new Event(id_ev,t, t5, "", "", t2, t4, "", t6, 0, t3, 6);

            ServiceEvent Ev = new ServiceEvent();
          
        mail1 m = new mail1() ;
        String newD = "" ;
        newD= Ev.reporter(id_ev);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate dateTime = LocalDate.parse(newD, formatter);
       String md = "l'evenement" +titre1.getText()+ "a été reporté pour le" +date1.getValue().toString();
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de Modifier?");
       Optional<ButtonType> action2 = alert.showAndWait();

       if( dateTime.compareTo(date1.getValue())!=0 )
 
       {
             LocalDate localDate = LocalDate.now();
 if(localDate.compareTo(date1.getValue())>0 )
         {
             Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("info");
        alert2.setHeaderText(null);
        alert2.setContentText("Vous avez saisi une mauvaise date");
       alert2.showAndWait();
         }
       else
 {  
                        Alert alert3 = new Alert(Alert.AlertType.INFORMATION);

        
     alert3.setTitle("Reporter");
           alert3.setHeaderText(null);
           alert3.setContentText("Votre evenement a été reporté");
           alert3.showAndWait();


            
                         Ev.modifierEvent(id_ev, E);             

             afficher();                    
             m.mail(md);  

 }  }
       else


                        
       {    Ev.modifierEvent(id_ev, E);             

             afficher();}

        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }

    @FXML
    private void weekly(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Weekly.fxml"));
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
