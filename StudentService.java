import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "YOUR_NEW_PASSWORD";

    private Scanner s = new Scanner(System.in);

    // Create database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // ADD STUDENT
    public void addStudent() {

        System.out.print("Enter Roll Number: ");
        String rollNumber = s.nextLine();

        System.out.print("Enter Name: ");
        String name = s.nextLine();

        System.out.print("Enter Department: ");
        String department = s.nextLine();

        System.out.print("Enter Branch: ");
        String branch = s.nextLine();

        System.out.print("Enter Section: ");
        int section = Integer.parseInt(s.nextLine());

        System.out.print("Enter Email: ");
        String email = s.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = s.nextLine();

        String sql = "INSERT INTO students " +
                "(rollNumber, name, department, branch, section, email, phoneNumber) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, rollNumber);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setString(4, branch);
            ps.setInt(5, section);
            ps.setString(6, email);
            ps.setString(7, phoneNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("Roll number already exists!");
            } else {
                System.out.println("Error while adding student.");
                e.printStackTrace();
            }
        }
    }


    // VIEW ALL STUDENTS
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("----------------------------");
                System.out.println("Roll Number: " +
                        rs.getString("rollNumber"));

                System.out.println("Name: " +
                        rs.getString("name"));

                System.out.println("Department: " +
                        rs.getString("department"));

                System.out.println("Branch: " +
                        rs.getString("branch"));

                System.out.println("Section: " +
                        rs.getInt("section"));

                System.out.println("Email: " +
                        rs.getString("email"));

                System.out.println("Phone Number: " +
                        rs.getString("phoneNumber"));
            }

            if (!found) {
                System.out.println("No students found.");
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving students.");
            e.printStackTrace();
        }
    }


    // SEARCH STUDENT
    public void searchStudent() {

        System.out.print("Enter Roll Number to search: ");
        String rollNumber = s.nextLine();

        String sql = "SELECT * FROM students WHERE rollNumber = ?";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, rollNumber);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("----------------------------");
                    System.out.println("Roll Number: " +
                            rs.getString("rollNumber"));

                    System.out.println("Name: " +
                            rs.getString("name"));

                    System.out.println("Department: " +
                            rs.getString("department"));

                    System.out.println("Branch: " +
                            rs.getString("branch"));

                    System.out.println("Section: " +
                            rs.getInt("section"));

                    System.out.println("Email: " +
                            rs.getString("email"));

                    System.out.println("Phone Number: " +
                            rs.getString("phoneNumber"));

                } else {
                    System.out.println("Student not found!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error while searching student.");
            e.printStackTrace();
        }
    }


    // UPDATE STUDENT
    public void updateStudent() {

        System.out.print("Enter Roll Number to update: ");
        String rollNumber = s.nextLine();

        System.out.print("Enter new Name: ");
        String name = s.nextLine();

        System.out.print("Enter new Department: ");
        String department = s.nextLine();

        System.out.print("Enter new Branch: ");
        String branch = s.nextLine();

        System.out.print("Enter new Section: ");
        int section = Integer.parseInt(s.nextLine());

        System.out.print("Enter new Email: ");
        String email = s.nextLine();

        System.out.print("Enter new Phone Number: ");
        String phoneNumber = s.nextLine();

        String sql = "UPDATE students SET " +
                "name = ?, " +
                "department = ?, " +
                "branch = ?, " +
                "section = ?, " +
                "email = ?, " +
                "phoneNumber = ? " +
                "WHERE rollNumber = ?";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, branch);
            ps.setInt(4, section);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            ps.setString(7, rollNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error while updating student.");
            e.printStackTrace();
        }
    }


    // DELETE STUDENT
    public void deleteStudent() {

        System.out.print("Enter Roll Number to delete: ");
        String rollNumber = s.nextLine();

        String sql = "DELETE FROM students WHERE rollNumber = ?";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, rollNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error while deleting student.");
            e.printStackTrace();
        }
    }
}