package bus;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import login.DBConnection;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author root
 */
public class DetailsFormController implements Initializable {

     @FXML
    private JFXTextField Dpayment;
    @FXML
    private JFXTextField Dfrom;
    @FXML
    private JFXTextField Dto;
    @FXML
    private JFXTextField Ddate;
    @FXML
    private JFXTextField Dname;
    @FXML
    private JFXTextField Demail;
    @FXML
    private JFXTextField Dmobile;
    @FXML
    private JFXTextField pass;
    @FXML
    private JFXButton confirm_button;
    
    @FXML
    private JFXButton cancel;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    ResultSet rs;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             conn = DBConnection.bookingDatabaseConnection();
         } catch (SQLException ex) {
             Logger.getLogger(DetailsFormController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    
    
    public void insertText(String Dfrom, String Dto, String Ddate,
     String Dname, String Demail, String Dmobile, String Dpayment,String pass)throws IOException {
        this.Dfrom.setText(Dfrom);
        this.Dto.setText(Dto);
        this.Ddate.setText(Ddate);
        this.Dpayment.setText(Dpayment);
        this.Dname.setText(Dname);
        this.Demail.setText(Demail); 
        this.Dmobile.setText(Dmobile);
        this.pass.setText(pass);
    }

    @FXML
    private void cancelReserve(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();

    }

    
    @FXML
    private void confirmReserve(ActionEvent event) throws SQLException {
        Image img4 = new Image("/notification/Checked Checkbox_48px.png");
        String sql = "insert into busInfo(from_bus,to_bus,name,dob,mobileno,busid,email,payment)values(?,?,?,?,?,?,?,?)";
        
        String from1 = Dfrom.getText();
        String to1 = Dto.getText();
        String date1 = Ddate.getText();
        String name1 = Dname.getText();
        String email1 = Demail.getText();
        String pay1 = Dpayment.getText();
        String mob1 = Dmobile.getText();
        String pass1=pass.getText();
        
          Notifications notificationBuilder = Notifications.create()
                    .title("Confirmation")
                    .text("Your Reservation is completed!")
                    .graphic(new ImageView(img4))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationBuilder.darkStyle();
            notificationBuilder.show(); 
        
       try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,from1);
            pst.setString(2,to1);
            pst.setString(3,name1);
            pst.setString(4,date1);
            pst.setString(5,mob1);
            pst.setString(6,pay1);
            pst.setString(7,email1);
            pst.setString(8,pass1);
            pst.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DetailsFormController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            pst.close();
        }
       
    }
}
    

