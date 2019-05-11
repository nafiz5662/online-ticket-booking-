/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class buslist {
    private final StringProperty busid;
    private final StringProperty name;
    private final StringProperty from;
    private final StringProperty to;
    private final StringProperty time;
    private final StringProperty price;
     
    public buslist(String busid,String name,String from,
            String to,String time,String price){
       this.busid= new SimpleStringProperty(busid);
       this.name= new SimpleStringProperty(name);
       this.from= new SimpleStringProperty(from);
       this.to= new SimpleStringProperty(to);
       this.time= new SimpleStringProperty(time);
       this.price= new SimpleStringProperty(price);
    }
    
    public String getbusid(){
    return busid.get();
}
     public String getname(){
    return name.get();
}
      public String getfrom(){
    return from.get();
}
       public String getto(){
    return to.get();
}
      public String gettime(){
    return time.get();
}
       public String getprice(){
    return price.get();
}
       public void setbusid(String value){
           busid.set(value);
       }
        public void setname(String value){
           name.set(value);
       }
         public void setfrom(String value){
           from.set(value);
       }
          public void setto(String value){
           to.set(value);
       }
           public void settime(String value){
           time.set(value);
       }
            public void setprice(String value){
           price.set(value);
       }
            public StringProperty busidProperty(){return busid;}
            public StringProperty nameProperty(){return name;}
            public StringProperty fromProperty(){return from;}
            public StringProperty toProperty(){return to;}
            public StringProperty timeProperty(){return time;}
            public StringProperty priceProperty(){return price;}
}
