/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPanel;

import com.jfoenix.controls.JFXButton;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import login.DBConnection;

/**
 * FXML Controller class
 *
 * @author root
 */
public class BusPassengerInfoController implements Initializable {

    @FXML
    private TableView <Bus> tablebuspassenger;
    @FXML
    private TableColumn<Bus,String> buspassname;
    @FXML
    private TableColumn<Bus,String> buspassid;
    @FXML
    private TableColumn<Bus,String> buspassfrom;
    @FXML
    private TableColumn<Bus,String> buspassto;
    @FXML
    private TableColumn<Bus,String> buspassdate;
    @FXML
    private TableColumn<Bus,String> buspassemail;
    @FXML
    private TableColumn<Bus,String> buspassmobile;
    @FXML
    private TableColumn<Bus,String> buspasspayment;

    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs;
    private ObservableList <Bus> data;

    @FXML
    private JFXButton btn_delete;
    @FXML
    private TextField searching;

    @FXML
    private TextField txt_id;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BusPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        data = FXCollections.observableArrayList();
       try {
            rs = conn.createStatement().executeQuery("select * from busInfo");
            while(rs.next()){
                data.add(new Bus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buspassfrom.setCellValueFactory(new PropertyValueFactory<>("buspassfrom"));
        buspassto.setCellValueFactory(new PropertyValueFactory<>("buspassto"));
        buspassname.setCellValueFactory(new PropertyValueFactory<>("buspassname"));
        buspassdate.setCellValueFactory(new PropertyValueFactory<>("buspassdate"));
        buspassmobile.setCellValueFactory(new PropertyValueFactory<>("buspassmobile"));
        buspasspayment.setCellValueFactory(new PropertyValueFactory<>("buspasspayment"));
        buspassemail.setCellValueFactory(new PropertyValueFactory<>("buspassemail"));
        buspassid.setCellValueFactory(new PropertyValueFactory<>("buspassid"));

        tablebuspassenger.setItems(null);
        tablebuspassenger.setItems(data);
        
        searchinfo();
        setvaluetosearchbox();
        
    }    
     
   private void refreshtable(){
       data = FXCollections.observableArrayList();
        try {
            rs = conn.createStatement().executeQuery("select * from busInfo");
            while(rs.next()){
                data.add(new Bus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buspassfrom.setCellValueFactory(new PropertyValueFactory<>("buspassfrom"));
        buspassto.setCellValueFactory(new PropertyValueFactory<>("buspassto"));
        buspassname.setCellValueFactory(new PropertyValueFactory<>("buspassname"));
        buspassdate.setCellValueFactory(new PropertyValueFactory<>("buspassdate"));
        buspassmobile.setCellValueFactory(new PropertyValueFactory<>("buspassmobile"));
        buspasspayment.setCellValueFactory(new PropertyValueFactory<>("buspasspayment"));
        buspassemail.setCellValueFactory(new PropertyValueFactory<>("buspassemail"));

        tablebuspassenger.setItems(null);
        tablebuspassenger.setItems(data);
   }
 
    private void searchinfo() {
        searching.setOnKeyReleased(e->{
        if(searching.getText().equals("")){
            refreshtable();
        }else{
            data.clear();
            try {
                pst = conn.prepareStatement("select * from busInfo where name like '%"+searching.getText()+"%'");
                rs = pst.executeQuery();
                while(rs.next()){
                    data.add(new Bus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                }
                tablebuspassenger.setItems(data);
            } catch (SQLException ex) {
                Logger.getLogger(BusPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }        
    });
}
   
    private void setvaluetosearchbox(){
        tablebuspassenger.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Bus b = tablebuspassenger.getItems().get(tablebuspassenger.getSelectionModel().getSelectedIndex());
                searching.setText(b.getBuspassname());
                txt_id.setText(b.getBuspassid());
            }
            
        });
        
    }
    
    
    @FXML
    private void deletefromdatabase(ActionEvent event) {
        try {
            pst = conn.prepareStatement("delete from busInfo where id = ?");
            pst.setString(1, txt_id.getText());
            pst.executeUpdate();
            pst.close();
            txt_id.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(BusPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       refreshtable();
    }
   
}
  

