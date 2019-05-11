package AdminPanel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author root
 */
public class Train {
    private final StringProperty trainpassfrom;
    private final StringProperty trainpassto;
    private final StringProperty trainpassname;
    private final StringProperty trainpassdate;
    private final StringProperty trainpassmobile;
    private final StringProperty trainpasspayment;
    private final StringProperty trainpassemail;
    private final StringProperty trainpassid;

    public Train(String trainpassfrom, String trainpassto, String trainpassname, String trainpassdate, String trainpassmobile, String trainpasspayment, String trainpassemail,String trainpassid) {
        this.trainpassfrom = new SimpleStringProperty(trainpassfrom);
        this.trainpassto = new SimpleStringProperty(trainpassto);
        this.trainpassname = new SimpleStringProperty(trainpassname);
        this.trainpassdate = new SimpleStringProperty(trainpassdate);
        this.trainpassmobile = new SimpleStringProperty(trainpassmobile);
        this.trainpasspayment = new SimpleStringProperty(trainpasspayment);
        this.trainpassemail = new SimpleStringProperty(trainpassemail);
        this.trainpassid = new SimpleStringProperty(trainpassid);
    }

    public String getTrainpassfrom() {
        return trainpassfrom.get();
    }

    public void setTrainpassfrom(String value) {
        trainpassfrom.set(value);
    }

    public String getTrainpassTo() {
        return trainpassto.get();
    }

    public void setTrainpassto(String value) {
        trainpassto.set(value);
    }

    public String getTrainpassname() {
        return trainpassname.get();
    }

    public void setTrainpassname(String value) {
        trainpassname.set(value);
    }

    public String getTrainpassdate() {
        return trainpassdate.get();
    }

    public void setTrainpassdate(String value) {
        trainpassdate.set(value);
    }

    public String getTrainpassmobile() {
        return trainpassmobile.get();
    }

    public void setTrainpassmobile(String value) {
        trainpassmobile.set(value);
    }

    public String getTrainpasspayment() {
        return trainpasspayment.get();
    }

    public void setTrainpasspayment(String value) {
        trainpasspayment.set(value);
    }

    public String getTrainpassemail() {
        return trainpassemail.get();
    }

    public void setTrainpassemail(String value) {
        trainpassemail.set(value);
    }
    
    public String getTrainpassid() {
        return trainpassid.get();
    }

    public void setTrainpassid(String value) {
        trainpassid.set(value);
    }

    public StringProperty trainpassfromProperty() {
        return trainpassfrom;
    }

    public StringProperty trainpasstoProperty() {
        return trainpassto;
    }

    public StringProperty trainpassnameProperty() {
        return trainpassname;
    }

    public StringProperty trainpassdateProperty() {
        return trainpassdate;
    }

    public StringProperty trainpassmobileProperty() {
        return trainpassmobile;
    }

    public StringProperty trainpasspaymentProperty() {
        return trainpasspayment;
    }

    public StringProperty trainpassemailProperty() {
        return trainpassemail;
    }
    public StringProperty trainpassidProperty() {
        return trainpassid;
    }

    
}
