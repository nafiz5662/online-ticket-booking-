package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection bookingDatabaseConnection() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/bookingDatabase";
            String username = "root";
            String password = "";
        
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return conn;
    }
}
