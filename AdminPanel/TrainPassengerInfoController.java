package AdminPanel;

import com.jfoenix.controls.JFXTextField;
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
public class TrainPassengerInfoController implements Initializable {
    @FXML
    private TableView <Train> tabletrainpassenger;
    @FXML
    private TableColumn<Train,String> trainpassname;
    @FXML
    private TableColumn<Train,String> trainpassfrom;
    @FXML
    private TableColumn<Train,String> trainpassto;
    @FXML
    private TableColumn<Train,String> trainpassdate;
    @FXML
    private TableColumn<Train,String> trainpassemail;
    @FXML
    private TableColumn<Train,String> trainpassmobile;
    @FXML
    private TableColumn<Train,String> trainpasspayment;
    @FXML
    private TableColumn<Train,String> trainpassid;

    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs;
    private ObservableList <Train> data2;
    @FXML
    private JFXTextField txt_trainid;
    @FXML
    private TextField searchingtrain;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
            conn = DBConnection.bookingDatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TrainPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                data2 = FXCollections.observableArrayList();
                try {
            rs = conn.createStatement().executeQuery("select * from trainInfo");
            while(rs.next()){
                data2.add(new Train(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        trainpassfrom.setCellValueFactory(new PropertyValueFactory<>("trainpassfrom"));
        trainpassto.setCellValueFactory(new PropertyValueFactory<>("trainpassto"));
        trainpassname.setCellValueFactory(new PropertyValueFactory<>("trainpassname"));
        trainpassdate.setCellValueFactory(new PropertyValueFactory<>("trainpassdate"));
        trainpassmobile.setCellValueFactory(new PropertyValueFactory<>("trainpassmobile"));
        trainpasspayment.setCellValueFactory(new PropertyValueFactory<>("trainpasspayment"));
        trainpassemail.setCellValueFactory(new PropertyValueFactory<>("trainpassemail"));
        trainpassid.setCellValueFactory(new PropertyValueFactory<>("trainpassid"));

        tabletrainpassenger.setItems(null);
        tabletrainpassenger.setItems(data2);
        
        
        searchinfo();
        setvaluetosearchbox();

    } 
    
    
    private void refreshtable(){
        data2 = FXCollections.observableArrayList();
            try {
            rs = conn.createStatement().executeQuery("select * from trainInfo");
            while(rs.next()){
                data2.add(new Train(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        trainpassfrom.setCellValueFactory(new PropertyValueFactory<>("trainpassfrom"));
        trainpassto.setCellValueFactory(new PropertyValueFactory<>("trainpassto"));
        trainpassname.setCellValueFactory(new PropertyValueFactory<>("trainpassname"));
        trainpassdate.setCellValueFactory(new PropertyValueFactory<>("trainpassdate"));
        trainpassmobile.setCellValueFactory(new PropertyValueFactory<>("trainpassmobile"));
        trainpasspayment.setCellValueFactory(new PropertyValueFactory<>("trainpasspayment"));
        trainpassemail.setCellValueFactory(new PropertyValueFactory<>("trainpassemail"));
        trainpassid.setCellValueFactory(new PropertyValueFactory<>("trainpassid"));

        tabletrainpassenger.setItems(null);
        tabletrainpassenger.setItems(data2);
   }
    
        private void searchinfo() {
        searchingtrain.setOnKeyReleased(e->{
        if(searchingtrain.getText().equals("")){
            refreshtable();
        }else{
            data2.clear();
            try {
                pst = conn.prepareStatement("select * from trainInfo where name like '%"+searchingtrain.getText()+"%'");
                rs = pst.executeQuery();
                while(rs.next()){
                    data2.add(new Train(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                }
                tabletrainpassenger.setItems(data2);
            } catch (SQLException ex) {
                Logger.getLogger(TrainPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }        
    });
}
            private void setvaluetosearchbox(){
        tabletrainpassenger.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Train t = tabletrainpassenger.getItems().get(tabletrainpassenger.getSelectionModel().getSelectedIndex());
                searchingtrain.setText(t.getTrainpassname());
                txt_trainid.setText(t.getTrainpassid());
            }
            
        });
        
    }

    @FXML
    private void deletefromtraindatabase(ActionEvent event) {
        try {
            pst = conn.prepareStatement("delete from trainInfo where id = ?");
            pst.setString(1, txt_trainid.getText());
            pst.executeUpdate();
            pst.close();
            txt_trainid.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(TrainPassengerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       refreshtable();
    }
        
}
