//Responsibility is to run the application
import java.util.*;
public class Main{
static ArrayList<Student> students=new ArrayList<>();
  StudentService service = new StudentService();
static Scanner s = new Scanner(System.in);

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
            service.addStudent();
            break;
        case 2:
            service.viewStudents();
            break;
        case 3:
            service.searchStudent();
            break;
        case 4:
            service.updateStudent();
            break;
        case 5:
            service.deleteStudent();
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