/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Services.ServiceEvent;
import Services.ServiceParticipants_com;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.teamdev.jxbrowser.dom.Document;
import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class AdminParticController implements Initializable {

    @FXML
    private TableColumn<?, ?> NomP;
    @FXML
    private TableColumn<?, ?> PrenomP;
    @FXML
    private TableColumn<?, ?> NomE;
    @FXML
    private TableColumn<?, ?> Type;
    @FXML
    private Button Ok;
    @FXML
    private Button NO;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> idP;
    @FXML
    private TableColumn<?, ?> idE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher ();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    public void Ok(ActionEvent event) throws AWTException {
        
        

        try {
           // table.getSelectionModel().getSelectedIndex();
            
            String ide ;
            ide=idE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            
            int id_ev  = Integer.parseInt(ide);
            
          
      
           
            String idc;
            idc=idP.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            String nom;
            nom=NomE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            
            int idcc  = Integer.parseInt(idc);
            
            ServiceParticipants_com SP = new ServiceParticipants_com();
            SP.modifieretat(id_ev, idcc);
            Notif n = new Notif();
            n.displayTray("Approvement","Vous avez été choisir pour participer à l'evenement" +nom);
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                

    }
    
  
        public void afficher()throws IOException, SQLException{
            ServiceParticipants_com srv = new ServiceParticipants_com();
        
            ObservableList obeListe = FXCollections.observableList(srv.afficherParticipant());
            
ServiceEvent Ev = new ServiceEvent();
int idd= Ev.id();
 idE.setCellValueFactory(new PropertyValueFactory<>("id_ev"));
                idP.setCellValueFactory(new PropertyValueFactory<>("id_cl"));
        NomP.setCellValueFactory(new PropertyValueFactory<>("nomP"));
                PrenomP.setCellValueFactory(new PropertyValueFactory<>("prenomP"));

                       NomE.setCellValueFactory(new PropertyValueFactory<>("nomE"));
               Type.setCellValueFactory(new PropertyValueFactory<>("Type"));

        
                            

        table.setItems(obeListe);
    }
        @FXML
    private void CreatePdf(ActionEvent event) throws Exception {
        try {
         Document document = new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\pablo\\Documents\\NetBeansProjects\\PInote\\src\\pdf\\note.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(5);
       table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(2);
       table.addCell("id_Note");
       table.addCell("Nom");
       table.addCell("Prenom");
              table.addCell("Matiere");
                     table.addCell("Note");
    
      
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Liste Des Notes");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
                  // document.add(com.itextpdf.text.Image.getInstance("C:/Users/pablo/Documents/NetBeansProjects/Pi_dev/src/Images/bank.png"));

       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/it-vision", "root", "");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("SELECT  FROM participant");
       while(rs.next()){
       table.addCell(rs.getString("NomE"));
       table.addCell(rs.getString("PrenomP"));

       table.addCell(rs.getString("NomP"));
       table.addCell(rs.getString("matiere"));
       table.addCell(rs.getString("Type"));
       }
       document.add(table);
        JOptionPane.showMessageDialog(
                null, " données exportées en pdf avec succés ");
               document.close();
           
            

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
   
    }
    @FXML
    private void NO(ActionEvent event) throws AWTException {
        try {
            table.getSelectionModel().getSelectedIndex();
            
            String ide ;
            ide=idE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            
            int id_ev  = Integer.parseInt(ide);
            
            
            String idc;
            idc=idP.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            
            int idcc  = Integer.parseInt(idc);
            
            ServiceParticipants_com SP = new ServiceParticipants_com();
            SP.supprimerpersonne(id_ev, idcc);
               Notif n = new Notif();
            n.displayTray("refus","Vous n'avez pas été adhérer pour des raisons professionnelles");
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
