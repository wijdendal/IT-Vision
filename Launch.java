package View;

import com.jfoenix.controls.JFXDecorator;
import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Event.fxml")); 
                      //  Parent root = FXMLLoader.load(getClass().getResource("test2.fxml")); 
        JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);

 decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);         
        Scene scene = new Scene(decorator);
                    scene.getStylesheets().add(Launch.class.getResource("CSS/stylesheet.css").toExternalForm());

        stage.setScene(scene);  
        this.stage=stage;
        stage.setIconified(true);
    this.stage.getIcons().add(new Image("file:/resources/img/logo-bascla.png"));

        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
