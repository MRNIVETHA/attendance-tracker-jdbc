package attendance;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/attendance_db";
        String user = "root";
        String pass = "Nivi@4578"; // change this
        return DriverManager.getConnection(url, user, pass);
    }
}
