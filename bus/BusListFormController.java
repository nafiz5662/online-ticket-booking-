/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import login.DBConnection;
import login.RegisterController;

/**
 * FXML Controller class
 *
 * @author root
 */
public class BusListFormController implements Initializable {

    @FXML
    private TableColumn<buslist,String> busid;
    @FXML
    private TableColumn<buslist,String> name;
    @FXML
    private TableColumn<buslist,String> from;
    @FXML
    private TableColumn<buslist,String> to;
    @FXML
    private TableColumn<buslist,String> time;
    @FXML
    private TableColumn<buslist,String> price;
    @FXML
    private TableView<buslist> bustable;
    private ObservableList<buslist> data;
    
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
    private void handleload(ActionEvent event) {
        data=FXCollections.observableArrayList();
    try {
        rs=conn.createStatement().executeQuery("Select * From buslist");
        while(rs.next()){
            data.add(new buslist(rs.getString(1),rs.getString(2),rs.getString(3),
            rs.getString(4),rs.getString(5),rs.getString(6)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(BusListFormController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Error"+ex);
    }
    busid.setCellValueFactory(new PropertyValueFactory<>("busid"));
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    from.setCellValueFactory(new PropertyValueFactory<>("from"));
    to.setCellValueFactory(new PropertyValueFactory<>("to"));
    time.setCellValueFactory(new PropertyValueFactory<>("time"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    
    bustable.setItems(null);
    bustable.setItems(data);
    }
    
}
