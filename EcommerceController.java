/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class EcommerceController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
