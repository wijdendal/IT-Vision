/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import Entities.Event;
import Services.ServiceEvent;
import Services.ServiceParticipants_com;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class EventController implements Initializable {

    public HBox cat;
    @FXML
    private VBox affiche;
    public Spinner Sp = new Spinner();
    private JFXButton bt;
    private JFXButton bt2;
    public HBox HB;
    public HBox hbu;

    String content = "participer";
    String attente = "attente";
    String annuler = "annuler";
    int donia = 0;
    JFXButton fbt; 
    @FXML
    private CheckBox comp;
    @FXML
    private CheckBox tour;
List<Event> compe ;
List<Event>  tourne;
List<Event> us; 
    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            hbu = null;
            ServiceEvent EV = new ServiceEvent();
            int k = EV.GetterId();
            ServiceEvent Ev = new ServiceEvent();
            
            Label titre = new Label("Les evenements");
            titre.setFont(new Font("Alex Brush", 46));

            us = EV.readAll();
            afficher(us);          


            

            

            //final Mapa example = new Mapa("test");
            //example.generateMarker(example.getMap().getCenter());
        } catch (SQLException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void participer(int id) {
        System.out.println(id);

    }

    public void set(String l, JFXButton bt) {
        bt.setText(l);
    }
    public void afficher (List <Event> us)
    {
        List<Integer> List = new ArrayList();
            List<Integer> List2 = new ArrayList();

            ServiceParticipants_com SV = new ServiceParticipants_com();
            List = SV.etat(1);
            List2 = SV.etat2(1);
        ServiceEvent Ev = new ServiceEvent();
        for (int i = 0; i < us.size(); i++) {
                hbu = new HBox(10);
                    hbu.setSpacing(20); // espace horizontal entre deux images

                    Label li = new Label();

                    li.setText(us.get(i).getTitle());
                    li.setFont(new Font("Alex Brush", 60));
                    ImageView img = new ImageView(new Image(getClass().getResource("images/" + us.get(i).getPic()).toString()));
                    img.setFitHeight(150);
                    img.setFitWidth(150);
                    hbu.setPrefWidth(300);
                    // hbu.setMaxWidth(700);
                    hbu.setMinWidth(600);
                    bt = new JFXButton();
                     fbt = new JFXButton("en attente");
                    bt.setMaxWidth(100.0);
                    bt.setMinWidth(100.0);
                    fbt.setMaxWidth(100.0);
                    fbt.setMinWidth(100.0);
                    bt2 = new JFXButton("Details");
                    bt2.setMaxWidth(100.0);
                    bt2.setMinWidth(100.0);
                    hbu.getStyleClass().add("hbu");
                    bt.getStyleClass().add("parti");
                    bt2.getStyleClass().add("det");
                    li.getStyleClass().add("li");
                    bt.setText(content);
                                        Label idL = new Label();

                    for (int j = 0; j < List.size(); j++) {

                        if (List.get(j) == us.get(i).getId()) {
                            System.out.println("List des etats 0 " + List.get(j));
                            idL.setText("demande envoyée");
                        }

                    }
                    for (int j1 = 0; j1 < List2.size(); j1++) {

                        if (List2.get(j1) == us.get(i).getId()) {
                        }

                    }
                    affiche.getStyleClass().add("root");
                    Label Desc = new Label();
                    Desc.setFont(new Font("Alex Brush", 40));
                    String Lab = us.get(i).getDescription();
                    Desc.setText(Lab);
                    Label Date = new Label(us.get(i).getDate());
                    int id = (us.get(i).getId());
                    String date = us.get(i).getDate();
                    bt2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                            setStage(Lab, date);
                            
                        }
                    });
                    int ip = us.get(i).getId();
                    String idd = "" + ip;
                    bt.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            System.out.println("lbara");
                                                System.out.println("l id courant est " +ip);
bt2.setVisible(false);

                            if (bt.getText().equals(content)) {
                                if (ajout_partic(ip)) {
                                    //set(attente, bt);
bt.setText(attente);
idL.setText("demande envoyée");
                                    System.out.println("walet en attente");
                                    //button(ip,1);
                                }
                            } else if (bt.getText().equals(attente) || bt.getText().equals(annuler)) {
                                System.out.println(ip);
                                bt.setText(content);
idL.setText("");

                                    //button(ip,1);
                                SV.supprimerpersonne(ip, 1);
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Sorry !!");
                                alert.setHeaderText(null);
                                alert.setContentText("Tfaskhet");
                                alert.showAndWait();
                                System.out.println("en attente wala annuler");
                            }
                        
                        }
                        
                    });
     
                    System.out.println("donia walet " + donia);

                    hbu.setMargin(hbu, new Insets(100, 50, 50, 100));
                    hbu.setMargin(bt, new Insets(100, 50, 50, 50));
                    hbu.setMargin(bt2, new Insets(100, 50, 50, 50));

                    hbu.setMargin(img, new Insets(20, 50, 50, 50));
                    hbu.getChildren().add(li);
                    hbu.getChildren().add(img);
                    hbu.getChildren().add(bt);
                    hbu.getChildren().add(bt2);
                    hbu.getChildren().add(idL);

                
                affiche.setMargin(hbu, new Insets(100, 100, 100, 100));
                //affiche.getChildren().add(titre);
                affiche.getChildren().add(hbu);
            }
    }
public void button (int id_ev , int id_cl)
{
    ServiceParticipants_com SP =new ServiceParticipants_com();
    if (SP.retouretat(id_ev, id_cl)==1)
    {
        System.out.println("c le " + SP.retouretat(id_ev, id_cl));
        bt.setText(annuler);
                                            System.out.println("walet en annuler");

    }
    else
    {
        bt.setText(attente);
                                                    System.out.println("fel fonction boutton attente");

    }
    
}
    private void setStage(String l, String date) {
        try {
            //dim overlay on new stage opening
            Region veil = new Region();
            veil.setPrefSize(1100, 650);
            veil.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("details.fxml"));
            Parent root = loader.load();
            DetailsController DC = loader.getController();
            DC.setLabel(l, date);
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.getScene().getRoot().setEffect(new DropShadow());
            newStage.showingProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    hbu.getChildren().add(veil);
                } else if (hbu.getChildren().contains(veil)) {
                    hbu.getChildren().removeAll(veil);
                }

            });
            newStage.centerOnScreen();
            newStage.show();

        } catch (IOException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setDonia(int a) {
        donia = a;
    }

    public boolean ajout_partic(int id) {
        int id_cl = 1;
        ServiceParticipants_com SP = new ServiceParticipants_com();

        if (SP.ajouterParticipant_com(id, id_cl)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Merci d'attendre");
            alert.setHeaderText(null);
            alert.setContentText("Une demande a été envoyée au responsable merci d'attendre une notification");
            alert.showAndWait();

            return (true);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sorry !!");
            alert.setHeaderText(null);
            alert.setContentText("Désolée mais l'evenement a atteint le nombre maximal");
            alert.showAndWait();

            final Image image = new Image(getClass().getResource("logo-bascla.png").toExternalForm());
            final ImageView icon = new ImageView(image);

            final Tooltip tooltip = new Tooltip("Au revoir!");
            //Tooltip.install(rectangle, tooltip);

            tooltip.setGraphic(icon);
            return (false);

        }

    }

    @FXML
    private void picked(ActionEvent event) {
        try {
            if (comp.isSelected())
            {System.out.println("dkhalna");
            affiche.getChildren().clear();
            ServiceEvent EV =new ServiceEvent ();
            compe  = EV.Type("Compet");
            
            //affiche.getChildren().remove(1);
            // hbu.getChildren().removeAll();
            afficher(compe);}
            else if (tour.isSelected())
            {
                System.out.println("dkhalna");
            affiche.getChildren().clear();
            ServiceEvent EV =new ServiceEvent ();
            tourne  = EV.Type("Tournée");
            afficher(tourne);
            }
            else 
            {ServiceEvent ev = new ServiceEvent();
            List<Event> uss =  ev.readAll();
            afficher(uss);}
        
        } catch (SQLException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
