# Student Management System

A console-based Student Management System developed in Java. The project started as a basic CRUD application and was progressively improved using Object-Oriented Programming, input validation, exception handling, project structure improvements, file persistence, and finally JDBC with MySQL database persistence.

## Features

- Add a student
- View all students
- Search for a student using roll number
- Update student details
- Delete a student
- Prevent duplicate roll numbers
- Validate user inputs
- Handle invalid numeric input
- Persist student data using MySQL
- Perform database operations using JDBC
- Handle database-related exceptions

## Student Information

Each student contains:

- Roll Number
- Name
- Department
- Branch
- Section
- Email
- Phone Number

## Technologies Used

- Java
- ArrayList
- Java OOP
- Exception Handling
- Regular Expressions
- Java Serialization
- File Handling
- JDBC
- MySQL
- MySQL Connector/J
- Git & GitHub

## Project Structure

```text
StudentManagementSystem/
│
├── Main.java
├── Student.java
├── StudentService.java
├── README.md
├── .gitignore
│
└── lib/
    └── mysql-connector-j-26.7.0.jar
Main.java

Responsible for running the application and displaying the menu to the user.

Student.java

Contains the student information and demonstrates encapsulation through:

Private fields
Constructor
Getters
Setters
displayStudent() method
Serializable implementation
StudentService.java

Responsible for student-related operations:

Add
View
Search
Update
Delete
Find student
Input validation
Exception handling
Database connection
JDBC operations
SQL query execution
OOP Concepts Used
Encapsulation

Student fields are private and accessed through getters and setters.

private String name;
public String getname() {
    return name;
}
Separation of Responsibilities

The project was improved from keeping all operations in Main.java to separating responsibilities:

Main
 ↓
StudentService
 ↓
Student

Main handles application flow, StudentService handles student operations and database interaction, and Student represents student data.

Validation

The application validates:

Name
Department
Branch
Section
Email
Phone Number

Regular expressions are used for string validation, while invalid numeric input is handled using InputMismatchException.

For example, phone numbers must contain exactly 10 digits.

Exception Handling

The application handles invalid input using try-catch.

For example, when a user enters a non-numeric value for Section, the application does not crash. It displays an appropriate message and asks for valid input.

Earlier file operations handled IOException and ClassNotFoundException.

Current database operations handle SQLException.

Duplicate roll numbers are prevented using the primary key constraint in the MySQL database.

JDBC Integration

The project uses JDBC (Java Database Connectivity) to connect the Java application with MySQL.

The application uses:

Connection
DriverManager
PreparedStatement
ResultSet
SQLException
Database Flow
Java Application
       ↓
StudentService
       ↓
     JDBC
       ↓
MySQL Connector/J
       ↓
MySQL Database
Database

The application uses a MySQL database named:

student_management

The main table is:

students

The table contains:

rollNumber
name
department
branch
section
email
phoneNumber

rollNumber is used as the primary key to prevent duplicate student records.

CRUD Operations
Operation	SQL Command	JDBC Method
Add Student	INSERT	executeUpdate()
View Students	SELECT	executeQuery()
Search Student	SELECT ... WHERE	executeQuery()
Update Student	UPDATE	executeUpdate()
Delete Student	DELETE	executeUpdate()
PreparedStatement

Parameterized SQL queries are executed using PreparedStatement.

Example:

String sql = "DELETE FROM students WHERE rollNumber = ?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, rollNumber);

ps.executeUpdate();
ResultSet

ResultSet is used to retrieve records returned by SELECT queries.

ResultSet rs = ps.executeQuery();

while (rs.next()) {
    System.out.println(rs.getString("name"));
}
Try-with-resources

Database resources such as Connection, PreparedStatement, and ResultSet are automatically closed using try-with-resources.

File Persistence

Earlier versions of the project used Java Serialization to store student data.

Student implements Serializable:

public class Student implements Serializable
Earlier Saving Process
ArrayList<Student>
       ↓
ObjectOutputStream
       ↓
students.dat
Earlier Loading Process
students.dat
       ↓
ObjectInputStream
       ↓
ArrayList<Student>

File persistence was used in an earlier version of the project.

The current version uses MySQL for persistent storage instead of students.dat.

Git Versioning

The project is maintained using Git and version tags to mark important stages of development.

Current milestones include:

v1.0-crud
v1.2-exception-handling
v2.0-file-handling
v2.2-exception-handling
v3.0-jdbc-mysql
v3.0 - JDBC + MySQL

The latest version replaces file-based persistence with MySQL database persistence.

Java Application
       ↓
     JDBC
       ↓
     MySQL
Current Status

The application currently supports:

CRUD
   ↓
Encapsulation
   ↓
Project Structure
   ↓
Duplicate Roll Number Validation
   ↓
Exception Handling
   ↓
Input Validation
   ↓
File Persistence (Earlier Version)
   ↓
JDBC Integration
   ↓
MySQL Database Persistence

All major CRUD operations have been tested successfully with MySQL.

Future Improvements

Planned improvements include:

Improved project architecture
Additional validation and error handling
Secure database configuration using environment variables
Unit testing
Convert the console application into a web application
Add a frontend using HTML, CSS, and JavaScript
Introduce a backend framework such as Spring Boot
Add REST APIs
How to Run
1. Create the Database

Open MySQL and create the database:

CREATE DATABASE student_management;

Select the database:

USE student_management;

Create the students table:

CREATE TABLE students (
    rollNumber VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    branch VARCHAR(100),
    section INT,
    email VARCHAR(100),
    phoneNumber VARCHAR(10)
);
2. Configure Database Credentials

Open StudentService.java and configure your MySQL credentials:

private static final String URL =
        "jdbc:mysql://localhost:3306/student_management";

private static final String USERNAME = "root";

private static final String PASSWORD = "YOUR_PASSWORD";

Replace YOUR_PASSWORD with your MySQL password.

3. Compile

From the project directory:

javac -cp "lib\mysql-connector-j-26.7.0.jar" *.java
4. Run
java -cp ".;lib\mysql-connector-j-26.7.0.jar" Main

The application starts from Main.java.

Application Menu
========== Student Management System ==========

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Author

Tejaswini Vaddempudi


### After you replace the README

Run only:

```powershell
git commit -m "Update README for JDBC MySQL integration"
git push origin main
