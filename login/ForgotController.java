package login;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ForgotController implements Initializable {
    @FXML 
    private AnchorPane fgot;

    @FXML
    private JFXTextField recemail;

    @FXML
    private JFXTextField recusername;
    
    @FXML
    private Label showPassword;

    
    private Connection conn = null;
    private PreparedStatement pst = null;
    //private String ps;
    ResultSet rs;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ForgotController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    } 
    @FXML
    private void handleRecover(ActionEvent event) throws IOException{
            String username;
            try {
            pst = conn.prepareStatement("select Password from loginInfo where User_Name=? and Email=?");
            pst.setString(1,recusername.getText());
            pst.setString(2,recemail.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                username = rs.getString("Password");
                showPassword.setText(username);
                rs.close();
            }
            else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid User Name or Email");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid User Name or Email to get back your Password.");
            alert.showAndWait();
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        



    @FXML
    private void handleret(javafx.scene.input.MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        fgot.getChildren().setAll(pane);
    }
    
}
