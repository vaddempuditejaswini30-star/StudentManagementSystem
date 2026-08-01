import java.util.*;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner s = new Scanner(System.in);
    public Student findStudent(String rollNumber) {
    for (Student student : students) {
        if (student.getrollNumber().equals(rollNumber)) {
            return student;
        }
    }
    return null;
}
private int readSection() {
    while (true) {
        try {
            System.out.print("Enter Section: ");
            int section = s.nextInt();
            s.nextLine();
            return section;
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            s.nextLine();
        }
    }
}
    public void addStudent(){
    System.out.print("Enter Roll Number: ");
    String rollNumber = s.nextLine();
    Student existingstudent = findStudent(rollNumber);

if(existingstudent != null){
    System.out.println("Student already exists");
    return;
}
    System.out.print("Enter Name: ");
    String name=s.nextLine();
    System.out.print("Enter Department: ");
    String department=s.nextLine();
    System.out.print("Enter Branch: ");
    String branch=s.nextLine();
    int section=readSection();
    System.out.print("Enter Email: ");
    String email=s.nextLine();
    System.out.print("Enter PhoneNumber: ");
    String phoneNumber=s.nextLine();
    Student student=new Student(rollNumber,name,department,branch,section,email,phoneNumber);
   students.add(student);
   System.out.println("Student added successfully");
   System.out.println();
}   
public void viewStudents(){
    if(students.isEmpty()){
        System.out.println("No Students found");
        return;
    }
        System.out.println("List of Students:");
        for(Student student : students){
        student.displayStudent();
    }
}
public void searchStudent() {
    System.out.print("Enter Roll Number to search: ");
    String rollNumber = s.nextLine();
   Student existingstudent = findStudent(rollNumber);

if(existingstudent == null){
    System.out.println("Student not found");
    return;
}
    existingstudent.displayStudent();
}
public int updateMenu(){
        System.out.println("1.Update Name");
        System.out.println("2.Update department");
        System.out.println("3.Update Branch");
        System.out.println("4.Update Section");
        System.out.println("5.Update Email");
        System.out.println("6.Update Phone Number");
        System.out.print("Enter your choice: ");
        int n=s.nextInt();
        s.nextLine();
        return n;
    }
public void updateStudent(){
    System.out.print("Enter Roll Number to Update: ");
    String rollNumber=s.nextLine();
    Student existingstudent = findStudent(rollNumber);

    if(existingstudent == null){
        System.out.println("Student not found");
        return;
    }
        switch(updateMenu()){
            case 1:
                System.out.print("Enter new Name: ");
                existingstudent.setname(s.nextLine());
                System.out.println("Name Updated Successfully.");
                break;
            case 2:
                System.out.print("Enter new Department: ");
                existingstudent.setdepartment(s.nextLine());
                System.out.println("Department Updated successfully.");
                break;
            case 3:
                System.out.print("Enter new Branch: ");
                existingstudent.setbranch(s.nextLine());
                System.out.println("Branch Updated Successfully.");
                break;
            case 4:
                int section=readSection();
                existingstudent.setsection(section);
                System.out.println("Section Updated Successfully.");
                break;
            case 5:
                System.out.print("Enter new mail: ");
                existingstudent.setemail(s.nextLine());
                System.out.println("Email Updated Successfully.");
                break;
            case 6:
                System.out.println("Enter new Mobile Number: ");
                existingstudent.setphoneNumber(s.nextLine());
                System.out.println("Mobile Number Updated Successfully.");
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
           }
    }
}
public void deleteStudent(){
    System.out.print("Enter Roll Number to Delete: ");
    String rollNumber=s.nextLine();

    Student existingstudent = findStudent(rollNumber);

    if(existingstudent == null){
        System.out.println("Student not found");
        return;
    }
        students.remove(existingstudent);
        System.out.println("Student Deleted Successfully.");
    }


}