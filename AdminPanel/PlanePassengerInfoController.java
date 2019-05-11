package AdminPanel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import login.DBConnection;

/**
 * FXML Controller class
 *
 * @author root
 */
public class PlanePassengerInfoController implements Initializable {

    @FXML
    private TableView<Plane> tableplanepassenger;
    @FXML
    private TableColumn<Plane, String> planepassname;
    @FXML
    private TableColumn<Plane, String> planepassfrom;
    @FXML
    private TableColumn<Plane, String> planepassto;
    @FXML
    private TableColumn<Plane, String> planepassdate;
    @FXML
    private TableColumn<Plane, String> planepassmobile;
    @FXML
    private TableColumn<Plane, String> planepasspayment;
    @FXML
    private TableColumn<Plane, String> planepassemail;
    
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs;
    private ObservableList <Plane> data3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PlanePassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         data3 = FXCollections.observableArrayList();
                try {
            rs = conn.createStatement().executeQuery("select * from planeInfo");
            while(rs.next()){
                data3.add(new Plane(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanePassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        planepassfrom.setCellValueFactory(new PropertyValueFactory<>("planepassfrom"));
        planepassto.setCellValueFactory(new PropertyValueFactory<>("planepassto"));
        planepassname.setCellValueFactory(new PropertyValueFactory<>("planepassname"));
        planepassdate.setCellValueFactory(new PropertyValueFactory<>("planepassdate"));
        planepassmobile.setCellValueFactory(new PropertyValueFactory<>("planepassmobile"));
        planepasspayment.setCellValueFactory(new PropertyValueFactory<>("planepasspayment"));
        planepassemail.setCellValueFactory(new PropertyValueFactory<>("planepassemail"));

        tableplanepassenger.setItems(null);
        tableplanepassenger.setItems(data3);

        
    }    
 

 }
