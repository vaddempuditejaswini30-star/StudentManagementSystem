# Student Management System

A console-based Student Management System developed in Java. The project started as a basic CRUD application and was progressively improved using Object-Oriented Programming, input validation, exception handling, project structure improvements, and file persistence.

## Features

* Add a student
* View all students
* Search for a student using roll number
* Update student details
* Delete a student
* Prevent duplicate roll numbers
* Validate user inputs
* Handle invalid numeric input
* Persist student data using file serialization
* Load previously saved students when the application starts

## Student Information

Each student contains:

* Roll Number
* Name
* Department
* Branch
* Section
* Email
* Phone Number

## Technologies Used

* Java
* ArrayList
* Java OOP
* Exception Handling
* Regular Expressions
* Java Serialization
* File Handling
* Git & GitHub

## Project Structure

```text
StudentManagementSystem/
│
├── Main.java
├── Student.java
├── StudentService.java
└── students.dat
```

### Main.java

Responsible for running the application and displaying the menu to the user.

### Student.java

Contains the student information and demonstrates encapsulation through:

* Private fields
* Constructor
* Getters
* Setters
* `displayStudent()` method
* `Serializable` implementation

### StudentService.java

Responsible for student-related operations:

* Add
* View
* Search
* Update
* Delete
* Find student
* Input validation
* Exception handling
* Saving students
* Loading students

### students.dat

Stores the serialized `ArrayList<Student>` so that student data remains available after the application is closed.

## OOP Concepts Used

### Encapsulation

Student fields are private and accessed through getters and setters.

```java
private String name;
```

```java
public String getname() {
    return name;
}
```

### Separation of Responsibilities

The project was improved from keeping all operations in `Main.java` to separating responsibilities:

```text
Main
 ↓
StudentService
 ↓
Student
```

`Main` handles application flow, `StudentService` handles student operations, and `Student` represents student data.

## Validation

The application validates:

* Name
* Department
* Branch
* Section
* Email
* Phone Number

Regular expressions are used for string validation, while invalid numeric input is handled using `InputMismatchException`.

For example, phone numbers must contain exactly 10 digits.

## Exception Handling

The application handles invalid input using `try-catch`.

For example, when a user enters a non-numeric value for Section, the application does not crash. It displays an appropriate message and asks for valid input.

File operations also handle `IOException` and `ClassNotFoundException`.

## File Persistence

The project uses Java Serialization to store student data.

`Student` implements `Serializable`:

```java
public class Student implements Serializable
```

### Saving

```text
ArrayList<Student>
       ↓
ObjectOutputStream
       ↓
students.dat
```

### Loading

```text
students.dat
       ↓
ObjectInputStream
       ↓
ArrayList<Student>
```

Student data is saved after add, update, and delete operations and loaded when `StudentService` is created.

## Git Versioning

The project is maintained using Git and version tags to mark important stages of development.

Current milestones include:

```text
v1.0-crud
v1.2-exception-handling
v2.0-file-handling
v2.2-exception-handling
```

## Current Status

The application currently supports:

```text
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
File Persistence
```

## Future Improvements

Planned improvements include:

* JDBC integration
* MySQL database
* Database-based CRUD operations
* Replacing file persistence with database persistence
* Improved project architecture
* Additional validation and error handling

## How to Run

Compile all Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

The application starts from `Main.java`.
