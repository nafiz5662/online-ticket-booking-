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
public class Bus {

    private final StringProperty buspassfrom;
    private final StringProperty buspassto;
    private final StringProperty buspassname;
    private final StringProperty buspassdate;
    private final StringProperty buspassmobile;
    private final StringProperty buspasspayment;
    private final StringProperty buspassemail;
    private final StringProperty buspassid;

    public Bus(String buspassfrom, String buspassto, String buspassname, String buspassdate, String buspassmobile, String buspasspayment, String buspassemail, String buspassid) {
        this.buspassfrom = new SimpleStringProperty(buspassfrom);
        this.buspassto = new SimpleStringProperty(buspassto);
        this.buspassname = new SimpleStringProperty(buspassname);
        this.buspassdate = new SimpleStringProperty(buspassdate);
        this.buspassmobile = new SimpleStringProperty(buspassmobile);
        this.buspasspayment = new SimpleStringProperty(buspasspayment);
        this.buspassemail = new SimpleStringProperty(buspassemail);
        this.buspassid = new SimpleStringProperty(buspassid);
    }

    public String getBuspassfrom() {
        return buspassfrom.get();
    }

    public void setBuspassfrom(String value) {
        buspassfrom.set(value);
    }

    public String getBuspassTo() {
        return buspassto.get();
    }

    public void setBuspassto(String value) {
        buspassto.set(value);
    }

    public String getBuspassname() {
        return buspassname.get();
    }

    public void setBuspassname(String value) {
        buspassname.set(value);
    }

    public String getBuspassdate() {
        return buspassdate.get();
    }

    public void setBuspassdate(String value) {
        buspassdate.set(value);
    }

    public String getBuspassmobile() {
        return buspassmobile.get();
    }

    public void setBuspassmobile(String value) {
        buspassmobile.set(value);
    }

    public String getBuspasspayment() {
        return buspasspayment.get();
    }

    public void setBuspasspayment(String value) {
        buspasspayment.set(value);
    }

    public String getBuspassemail() {
        return buspassemail.get();
    }

    public void setBuspassemail(String value) {
        buspassemail.set(value);
    }
    public String getBuspassid() {
        return buspassid.get();
    }

    public void setBuspassid(String value) {
        buspassid.set(value);
    }

    public StringProperty buspassfromProperty() {
        return buspassfrom;
    }

    public StringProperty buspasstoProperty() {
        return buspassto;
    }

    public StringProperty buspassnameProperty() {
        return buspassname;
    }

    public StringProperty buspassdateProperty() {
        return buspassdate;
    }

    public StringProperty buspassmobileProperty() {
        return buspassmobile;
    }

    public StringProperty buspasspaymentProperty() {
        return buspasspayment;
    }

    public StringProperty buspassemailProperty() {
        return buspassemail;
    }
    public StringProperty buspasseidProperty() {
        return buspassid;
    }

}
