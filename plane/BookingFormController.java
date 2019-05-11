package plane;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import login.DBConnection;

/**
 * FXML Controller class
 *
 * @author root
 */
public class BookingFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField from;

    @FXML
    private JFXTextField to;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BookingFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleReserve(ActionEvent event) throws SQLException {
        
    }
}
