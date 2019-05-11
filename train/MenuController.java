package train;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author root
 */
public class MenuController implements Initializable {
    @FXML
    private JFXHamburger hamburger;
   
    @FXML
    private JFXDrawer drawer;
     @FXML
    private AnchorPane subpane;
     
    @FXML
    private AnchorPane anchorpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            AnchorPane box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
            drawer.setSidePane(box);
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BookingForm.fxml"));
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("DetailsForm.fxml"));
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/login/FXMLDocument.fxml"));
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("/login/ChoosingForm.fxml"));
            AnchorPane pane5 = FXMLLoader.load(getClass().getResource("ListForm.fxml"));
            
            for(Node node : box.getChildren()){
                if(node.getAccessibleText()!=null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
                       switch (node.getAccessibleText()){
                           case "booking": subpane.getChildren().setAll(pane);
                           break;
                           case "details": subpane.getChildren().setAll(pane2);
                           break;
                           case "logout": anchorpane.getChildren().setAll(pane3);
                           break;
                           case "list": subpane.getChildren().setAll(pane5);
                           break;
                           case "exit": System.exit(0);
                           break;
                       } 
                    });
                }
            }
            
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
            transition.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
                transition.setRate(transition.getRate()*-1);
                transition.play();
                if(drawer.isShown()){
                    drawer.close();
                    anchorpane.getChildren().setAll(pane4);
                }else{
                    drawer.open();
                }
                
            }); } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
