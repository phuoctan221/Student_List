package studentlist;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------- MENU --------------");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    Student student = new Student();
                    student.addStudent();
                    studentList.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter id update: ");
                    String id = scanner.nextLine();
                    studentList.updateStudentByID(id);
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String delId = scanner.nextLine();
                    studentList.deleteStudentById(delId);
                    break;
                case 4:
                    studentList.displayAllStudent();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default: 
                    System.out.println("Invalid choice.");
            }
        }
    }
}
