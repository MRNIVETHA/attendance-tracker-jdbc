package attendance;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Attendance System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Check-In");
            System.out.println("3. Check-Out");
            System.out.println("4. View Today's Attendance");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> EmployeeService.addEmployee();
                case 2 -> {
                    System.out.print("Enter Employee ID: ");
                    AttendanceService.checkIn(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter Employee ID: ");
                    AttendanceService.checkOut(sc.nextInt());
                }
                case 4 -> AttendanceService.viewTodayAttendance();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("❌ Invalid");
            }
        } while (choice != 0);
    }
}
