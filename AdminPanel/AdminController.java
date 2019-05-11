/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author root
 */
public class AdminController implements Initializable {

    
    
    @FXML
    private AnchorPane adminsubpane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

  @FXML
    void busPassenger(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("BusPassengerInfo.fxml"));
        adminsubpane.getChildren().setAll(pane);

    }

    @FXML
    void planePassenger(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PlanePassengerInfo.fxml"));
        adminsubpane.getChildren().setAll(pane);

    }

    @FXML
    void trainPassenger(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TrainPassengerInfo.fxml"));
        adminsubpane.getChildren().setAll(pane);

    }

    @FXML
    void vehicleadd(ActionEvent event) {

    }
    
}
