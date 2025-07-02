package attendance;
import java.sql.*;
import java.util.Scanner;

public class EmployeeService {
    public static void addEmployee() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Department: ");
        String dept = sc.next();

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO employees VALUES (?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, dept);
        ps.executeUpdate();
        System.out.println("✅ Employee added.");
        con.close();
    }
}
