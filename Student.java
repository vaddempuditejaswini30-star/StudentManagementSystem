//contains student info
public class Student{
    private String rollNumber;
    private String name;
    private String department;
    private String branch;
    private int section;
    private String email;
    private String phoneNumber;
    public Student(String rollNumber,String name,String department,String branch,int section,String email,String phoneNumber){
        this.rollNumber=rollNumber;
        this.name=name;
        this.department=department;
        this.branch=branch;
        this.section=section;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    public String getrollNumber(){
    return rollNumber;
}
public String getname(){
    return name;
}
public String getdepartment(){
    return department;
}
public String getbranch(){
    return branch;
}
public int getsection(){
    return section;
}
public String getemail(){
    return email;
}
public String getphoneNumber(){
    return phoneNumber;
}
public void setname(String name){
    this.name=name;
}
public void setdepartment(String department){
    this.department=department;
}
public void setbranch(String branch){
    this.branch=branch;
}
public void setsection(int section){
    this.section=section;
}
public void setemail(String email){
    this.email=email;
}
public void setphoneNumber(String phoneNumber){
    this.phoneNumber=phoneNumber;
}
public void displayStudent() {
    System.out.println("Roll Number: " +getrollNumber());
    System.out.println("Name: " + getname());
    System.out.println("Department: " + getdepartment());
    System.out.println("Branch: " + getbranch());
    System.out.println("Section: " + getsection());
    System.out.println("Email: " + getemail());
    System.out.println("Phone Number: " + getphoneNumber());
    System.out.println("================================================");
}
}
