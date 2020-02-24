/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class DetailsController implements Initializable {

    @FXML
    private Button close;
    @FXML
    private Label Desc;
    @FXML
    private Label Date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void close(ActionEvent event) {
                close.getScene().getWindow().hide();

    }
    public  void setLabel(String l, String d)
    {
        this.Desc.setText(l);
        this.Date.setText(d);
    }

    
    
}
