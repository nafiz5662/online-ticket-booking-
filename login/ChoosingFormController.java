package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author root
 */
public class ChoosingFormController implements Initializable {
    
    
    @FXML
    private AnchorPane mainPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBookPlaneAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/plane/Menu.fxml"));
        mainPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void handleBookBusAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/bus/Menu.fxml"));
        mainPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void handleBookTrainAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/train/Menu.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleExit(MouseEvent event) {
        System.exit(0);
    }

    
}
