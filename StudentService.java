//manages students
import java.util.*;
import java.io.*;
public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner s = new Scanner(System.in);
    public StudentService() {
        loadStudents();
    }
    // 1. Find student
    public Student findStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getrollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    // 2. Validation methods

    private String readName() {
        while (true) {
            System.out.print("Enter Name: ");
            String name = s.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }

            System.out.println("Invalid Name. Please enter only alphabets.");
        }
    }

    private String readDepartment() {
        while (true) {
            System.out.print("Enter Department: ");
            String department = s.nextLine();

            if (department.matches("[a-zA-Z ]+")) {
                return department;
            }

            System.out.println("Invalid Department. Please enter only alphabets.");
        }
    }

    private String readBranch() {
        while (true) {
            System.out.print("Enter Branch: ");
            String branch = s.nextLine();

            if (branch.matches("[a-zA-Z ]+")) {
                return branch;
            }

            System.out.println("Invalid Branch. Please enter only alphabets.");
        }
    }

    private int readSection() {
        while (true) {
            try {
                System.out.print("Enter Section: ");
                int section = s.nextInt();
                s.nextLine();
                return section;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            }
        }
    }

    private String readEmail() {
        while (true) {
            System.out.print("Enter Email: ");
            String email = s.nextLine();

            if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                return email;
            }

            System.out.println("Invalid Email. Please enter a valid email.");
        }
    }

    private String readPhoneNumber() {
        while (true) {
            System.out.print("Enter Phone Number: ");
            String phoneNumber = s.nextLine();

            if (phoneNumber.matches("[0-9]{10}")) {
                return phoneNumber;
            }

            System.out.println("Invalid Phone Number. Please enter 10 digits.");
        }
    }

    // 3. Add student
    public void addStudent() {
        System.out.print("Enter Roll Number: ");
        String rollNumber = s.nextLine();

        Student existingStudent = findStudent(rollNumber);

        if (existingStudent != null) {
            System.out.println("Student already exists");
            return;
        }

        String name = readName();
        String department = readDepartment();
        String branch = readBranch();
        int section = readSection();
        String email = readEmail();
        String phoneNumber = readPhoneNumber();

        Student student = new Student(
            rollNumber,
            name,
            department,
            branch,
            section,
            email,
            phoneNumber
        );

        students.add(student);

        System.out.println("Student added successfully");
        saveStudents();
    }

    // 4. View
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students found");
            return;
        }

        System.out.println("List of Students:");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // 5. Search
    public void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        String rollNumber = s.nextLine();

        Student existingStudent = findStudent(rollNumber);

        if (existingStudent == null) {
            System.out.println("Student not found");
            return;
        }

        existingStudent.displayStudent();
    }

    // 6. Update menu
    public int updateMenu() {
        System.out.println("1. Update Name");
        System.out.println("2. Update Department");
        System.out.println("3. Update Branch");
        System.out.println("4. Update Section");
        System.out.println("5. Update Email");
        System.out.println("6. Update Phone Number");

        System.out.print("Enter your choice: ");

        int n = s.nextInt();
        s.nextLine();

        return n;
    }

    // 7. Update
    public void updateStudent() {
        System.out.print("Enter Roll Number to Update: ");
        String rollNumber = s.nextLine();

        Student existingStudent = findStudent(rollNumber);

        if (existingStudent == null) {
            System.out.println("Student not found");
            return;
        }

        switch (updateMenu()) {

            case 1:
                existingStudent.setname(readName());
                System.out.println("Name Updated Successfully.");
                break;

            case 2:
                existingStudent.setdepartment(readDepartment());
                System.out.println("Department Updated Successfully.");
                break;

            case 3:
                existingStudent.setbranch(readBranch());
                System.out.println("Branch Updated Successfully.");
                break;

            case 4:
                int section = readSection();
                existingStudent.setsection(section);
                System.out.println("Section Updated Successfully.");
                break;

            case 5:
                existingStudent.setemail(readEmail());
                System.out.println("Email Updated Successfully.");
                break;

            case 6:
                existingStudent.setphoneNumber(readPhoneNumber());
                System.out.println("Phone Number Updated Successfully.");
                break;

            default:
                System.out.println("Invalid Choice.");
        }
        saveStudents();
    }

    // 8. Delete
    public void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        String rollNumber = s.nextLine();

        Student existingStudent = findStudent(rollNumber);

        if (existingStudent == null) {
            System.out.println("Student not found");
            return;
        }

        students.remove(existingStudent);

        System.out.println("Student Deleted Successfully.");
        saveStudents();
    }
    private void loadStudents(){
        try{
            FileInputStream fis = new FileInputStream("students.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (FileNotFoundException e) {
        // First run — file doesn't exist yet
        System.out.println("No saved students found. Starting with an empty list.");
        }
        catch(IOException e){
            System.out.println("Error loading students:"+e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found:"+e.getMessage());
        }
    }
    private void saveStudents(){
        try{
            FileOutputStream fos = new FileOutputStream("students.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }
        catch(IOException e){
            System.out.println("Error saving students:"+e.getMessage());
        }
    }
}