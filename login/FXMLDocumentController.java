package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btn_s;
    @FXML
    private JFXTextField txt_username;
    @FXML
    private JFXPasswordField txt_password;
    @FXML
    private Label labelSignIn;
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Register.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadThird(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Forgot.fxml"));
        rootPane.getChildren().setAll(pane);
    }
     @FXML
    void loadfourth(ActionEvent event) {
      System.exit(0);
    }
    private String getUserName(){
        String uName = "";
        try {    
            pst = conn.prepareStatement("select User_Name from loginInfo where User_Name=? and Password=?");
            pst.setString(1,txt_username.getText());
            pst.setString(2,txt_password.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                uName = rs.getString(1);
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uName;
    }
    
    private String getPassword(){
        String pass = "";
        try {    
            pst = conn.prepareStatement("select Password from loginInfo where Password=? and User_Name=?");
            pst.setString(1,txt_password.getText());
            pst.setString(2,txt_username.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                pass = rs.getString(1);
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pass;
    }

    @FXML
    private void SignIn(ActionEvent event) throws IOException {
        //labelSignIn.setText("Sign In");
      
        if(txt_username.getText().equals(getUserName())&&txt_password.getText().equals(getPassword())){
                if(txt_username.getText().trim().isEmpty()||txt_password.getText().trim().isEmpty()){
                    labelSignIn.setText("Fill the Text Field");
                    labelSignIn.setStyle("-fx-font-size:15px;-fx-alignment:center");
                }else{
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("ChoosingForm.fxml"));
                    rootPane.getChildren().setAll(pane);
                }
            }else{
            if(txt_username.getText().trim().isEmpty()||txt_password.getText().trim().isEmpty()){
                labelSignIn.setText("Fill the Text Field");
                labelSignIn.setStyle("-fx-font-size:15px;-fx-alignment:center");
            }else{
                labelSignIn.setText("Invalid User Name or Password");
                labelSignIn.setStyle("-fx-font-size:15px;-fx-alignment:center");
            } 
        }
    }
}
