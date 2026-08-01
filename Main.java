//Responsibility is to run the application
import java.util.*;
public class Main{
static ArrayList<Student> students=new ArrayList<>();
static Scanner s = new Scanner(System.in);
   public static void addStudent(){
    System.out.print("Enter RollNumber: ");
    String rollNumber=s.nextLine();
    System.out.print("Enter Name: ");
    String name=s.nextLine();
    System.out.print("Enter Department: ");
    String department=s.nextLine();
    System.out.print("Enter Branch: ");
    String branch=s.nextLine();
    System.out.print("Enter Section: ");
    int section=s.nextInt();
    s.nextLine();
    System.out.print("Enter Email: ");
    String email=s.nextLine();
    System.out.print("Enter PhoneNumber: ");
    String phoneNumber=s.nextLine();
    Student student=new Student(rollNumber,name,department,branch,section,email,phoneNumber);
   students.add(student);
   System.out.println("Student added successfully");
   System.out.println();
}    
public static void viewStudents(){
    if(students.isEmpty()){
        System.out.println("No Students found");
    }
    else{
        System.out.println("List of Students:");
        for(Student student:students){
            System.out.println("Roll Number: "+student.rollNumber);
            System.out.println("Name: "+student.name);
            System.out.println("Department: "+student.department);
            System.out.println("Branch: "+student.branch);
            System.out.println("Section: "+student.section);
            System.out.println("Email: "+student.email);
            System.out.println("Phone Number: "+student.phoneNumber);
            System.out.println("======================================================================================================================");
            System.out.println();
        }
    }
}
public static void searchStudent(){
    System.out.print("Enter Roll Number to search: ");
    String rollNumber=s.nextLine();
    boolean found=false;
    for(Student student:students){
        if(student.rollNumber.equals(rollNumber)){
            System.out.println("Student found:");
             System.out.println("Roll Number: "+student.rollNumber);
            System.out.println("Name: "+student.name);
            System.out.println("Department: "+student.department);
            System.out.println("Branch: "+student.branch);
            System.out.println("Section: "+student.section);
            System.out.println("Email: "+student.email);
            System.out.println("Phone Number: "+student.phoneNumber);
            found=true;
            break;
        }
    }
    if(!found){
        System.out.println("Student not found");
    }
}
public static int updateMenu(){
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
public static void updateStudent(){
    System.out.print("Enter Roll Number to Update: ");
    String rollNumber=s.nextLine();
    boolean found=false;
    for(Student student:students){
        if(student.rollNumber.equals(rollNumber)){
            found=true;
           switch(updateMenu()){
            case 1:
                System.out.print("Enter new Name: ");
                student.name=s.nextLine();
                System.out.println("Name Updated Successfully.");
                break;
            case 2:
                System.out.print("Enter new Department: ");
                student.department=s.nextLine();
                System.out.println("Department Updated successfully.");
                break;
            case 3:
                System.out.print("Enter new Branch: ");
                student.branch=s.nextLine();
                System.out.println("Branch Updated Successfully.");
                break;
            case 4:
                System.out.print("Enter new Section: ");
                student.section=s.nextInt();
                s.nextLine();
                System.out.println("Section Updated Successfully.");
                break;
            case 5:
                System.out.print("Enter new mail: ");
                student.email=s.nextLine();
                System.out.println("Email Updated Successfully.");
                break;
            case 6:
                System.out.println("Enter new Mobile Number: ");
                student.phoneNumber=s.nextLine();
                System.out.println("Mobile Number Updated Successfully.");
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
           }
           break;
        }
    }
    if(!found){
        System.out.println("Student not found");
    }
}
public static void deleteStudent(){
    System.out.print("Enter Roll Number to Delete: ");
    String rollNumber=s.nextLine();
    boolean found=false;
    for(int i=0;i<students.size();i++){
        Student student=students.get(i);
        if(student.rollNumber.equals(rollNumber)){
            students.remove(student);
            System.out.println("Student Deleted Successfully.");
            found=true;
            break;
        }
    }
    if(!found){
        System.out.println("Student not found");
    }
}
public static void main(String[] args){
    int choice;
    do{
        System.out.println("========== Student Management System ==========");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice:");
        choice=s.nextInt();
        s.nextLine();
        switch(choice){
        case 1:
            addStudent();
            break;
        case 2:
            viewStudents();
            break;
        case 3:
            searchStudent();
            break;
        case 4:
            updateStudent();
            break;
        case 5:
            deleteStudent();
            break;
        case 6:
            System.out.println("Exit application");
            break;
        default:
            System.out.println("Invalid choice");
            break;
        }
    }
    while(choice!=6);
    }
}