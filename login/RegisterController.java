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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class RegisterController implements Initializable {
    @FXML
    private AnchorPane parent;

    @FXML
    private JFXTextField Fn,Ln,User,Phn,Email;
    
    @FXML
    private JFXButton btn_confirm;
    
    @FXML
    private JFXPasswordField Pass;
    

    /**
     *
     * @param url
     * @param rb
     */
    
      
    private Connection conn = null;
    private PreparedStatement pst = null;
    ResultSet rs;

      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleexit(MouseEvent event) {
        System.exit(0);
    }
    @FXML
    void handlHome(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        parent.getChildren().setAll(pane);
    }
    
     @FXML
    void handlereset(MouseEvent event) {
        Fn.setText(null);
        Ln.setText(null);
        User.setText(null);
        Pass.setText(null);
        Email.setText(null);
        Phn.setText(null);
    }
        private String getUserName(){
            String uName = "";
        try {
            pst = conn.prepareStatement("select User_name from loginInfo where User_Name=?");
            pst.setString(1,User.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                uName = rs.getString(1);
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uName;
    }
    
    private boolean validEmail(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)");
        Matcher m = p.matcher(Email.getText());
        if(m.find()&&m.group().equals(Email.getText())){
            return true;
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter a Valid Email Address");
            alert.showAndWait();
            return false;   
        }
    }
    private boolean validPass(){
        Pattern p = Pattern.compile(".{6,10}");
        Matcher m = p.matcher(Pass.getText());
        if(m.find()&&m.group().equals(Pass.getText())){
            return true;
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Password");
            alert.setHeaderText(null);
            alert.setContentText("Password length must be 6-10");
            alert.showAndWait();
            return false;   
        }
    }
   
    @FXML
    void handleconfirm(ActionEvent event) throws SQLException {
        Image img = new Image("/notification/Checked Checkbox_48px.png");
        Image img1 = new Image("/notification/Multiply_52px.png");
        if(Fn.getText().trim().isEmpty()||Ln.getText().trim().isEmpty()||User.getText().trim().isEmpty()||Pass.getText().trim().isEmpty()||Email.getText().trim().isEmpty()){
            
            Notifications notificationBuilder1 = Notifications.create()
                    .title("Wrong Input")
                    .text("Fill The From")
                    .graphic(new ImageView(img1))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationBuilder1.darkStyle();
            notificationBuilder1.show();
        }
            
        String sql = "insert into loginInfo(User_Name,Password,First_Name,Last_Name,Email,Phone_Number)values(?,?,?,?,?,?)";
        
        String uName = User.getText();
        String pass = Pass.getText();
        String firstName = Fn.getText();
        String lastName = Ln.getText();
        String email = Email.getText();
        String phone = Phn.getText();

        if(uName.equals("")||pass.equals("")||firstName.equals("")
                ||lastName.equals("")||email.equals("")||phone.equals("")){
            
        }else if(User.getText().equals(getUserName())){
            Notifications notificationBuilder = Notifications.create()
                    .title("User Name Already has Taken!")
                    .text("Try another One")
                    .graphic(new ImageView(img1))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
        else if(validEmail() && validPass()){
            Notifications notificationBuilder = Notifications.create()
                    .title("Confirmation")
                    .text("Account Created Succesfully")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
            notificationBuilder.darkStyle();
            notificationBuilder.show();
                try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, uName);
                pst.setString(2, pass);
                pst.setString(3, firstName);
                pst.setString(4, lastName);
                pst.setString(5, email);
                pst.setString(6, phone);
                pst.executeUpdate();
            }catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            pst.close();
           }
        }
        
    }
}