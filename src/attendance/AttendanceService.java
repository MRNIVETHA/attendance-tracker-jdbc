package attendance;
import java.sql.*;
import java.time.*;

public class AttendanceService {
    public static void checkIn(int empId) throws Exception {
        Connection con = DBConnection.getConnection();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        boolean isLate = now.isAfter(LocalTime.of(9, 30));

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO attendance (emp_id, date, checkin_time, is_late) VALUES (?, ?, ?, ?)");
        ps.setInt(1, empId);
        ps.setDate(2, Date.valueOf(today));
        ps.setTime(3, Time.valueOf(now));
        ps.setBoolean(4, isLate);
        ps.executeUpdate();

        System.out.println("✅ Checked in at " + now + (isLate ? " (Late)" : ""));
        con.close();
    }

    public static void checkOut(int empId) throws Exception {
        Connection con = DBConnection.getConnection();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE attendance SET checkout_time=? WHERE emp_id=? AND date=?");
        ps.setTime(1, Time.valueOf(now));
        ps.setInt(2, empId);
        ps.setDate(3, Date.valueOf(today));
        int updated = ps.executeUpdate();

        if (updated > 0)
            System.out.println("✅ Checked out at " + now);
        else
            System.out.println("❌ No check-in found for today.");
        con.close();
    }
    public static void viewTodayAttendance() throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT e.name, e.department, a.date, a.checkin_time, a.checkout_time, a.is_late " +
            "FROM employees e JOIN attendance a ON e.emp_id = a.emp_id WHERE a.date = ?");
        ps.setDate(1, Date.valueOf(java.time.LocalDate.now()));

        ResultSet rs = ps.executeQuery();
        System.out.println("\n--- 📋 Today's Attendance ---");
        while (rs.next()) {
            System.out.println(
                "Name: " + rs.getString("name") +
                " | Dept: " + rs.getString("department") +
                " | Date: " + rs.getDate("date") +
                " | In: " + rs.getTime("checkin_time") +
                " | Out: " + rs.getTime("checkout_time") +
                " | Late: " + (rs.getBoolean("is_late") ? "Yes" : "No")
            );
        }

        con.close();
    }

}
