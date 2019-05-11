/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPanel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author root
 */
public class Plane {
     private final StringProperty planepassfrom;
    private final StringProperty planepassto;
    private final StringProperty planepassname;
    private final StringProperty planepassdate;
    private final StringProperty planepassmobile;
    private final StringProperty planepasspayment;
    private final StringProperty planepassemail;

    public Plane(String planepassfrom, String planepassto, String planepassname, String planepassdate, String planepassmobile, String planepasspayment, String planepassemail) {
        this.planepassfrom = new SimpleStringProperty(planepassfrom);
        this.planepassto = new SimpleStringProperty(planepassto);
        this.planepassname = new SimpleStringProperty(planepassname);
        this.planepassdate = new SimpleStringProperty(planepassdate);
        this.planepassmobile = new SimpleStringProperty(planepassmobile);
        this.planepasspayment = new SimpleStringProperty(planepasspayment);
        this.planepassemail = new SimpleStringProperty(planepassemail);
    }

    public String getPlanepassfrom() {
        return planepassfrom.get();
    }

    public void setPlanepassfrom(String value) {
        planepassfrom.set(value);
    }

    public String getPlanepassTo() {
        return planepassto.get();
    }

    public void setPlanepassto(String value) {
        planepassto.set(value);
    }

    public String getPlanepassname() {
        return planepassname.get();
    }

    public void setPlanepassname(String value) {
        planepassname.set(value);
    }

    public String getPlanepassdate() {
        return planepassdate.get();
    }

    public void setPlanepassdate(String value) {
        planepassdate.set(value);
    }

    public String getPlanepassmobile() {
        return planepassmobile.get();
    }

    public void setPlanepassmobile(String value) {
        planepassmobile.set(value);
    }

    public String getPlanepasspayment() {
        return planepasspayment.get();
    }

    public void setPlanepasspayment(String value) {
        planepasspayment.set(value);
    }

    public String getPlanepassemail() {
        return planepassemail.get();
    }

    public void setPlanepassemail(String value) {
        planepassemail.set(value);
    }

    public StringProperty planepassfromProperty() {
        return planepassfrom;
    }

    public StringProperty planepasstoProperty() {
        return planepassto;
    }
                    
    public StringProperty planepassnameProperty() {
        return planepassname;
    }

    public StringProperty planepassdateProperty() {
        return planepassdate;
    }

    public StringProperty planepassmobileProperty() {
        return planepassmobile;
    }

    public StringProperty planepasspaymentProperty() {
        return planepasspayment;
    }

    public StringProperty planepassemailProperty() {
        return planepassemail;
    }
}
