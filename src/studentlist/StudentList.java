package studentlist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentList {

    ArrayList<Student> studentList = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);
    void addStudent(Student student) {
        studentList.add(student);
    }

    public boolean updateStudentByID(String id) {
        Student student = findStudentById(id);
        if (student != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Enter new name: ");
            String fullName = keyboard.nextLine();
            student.setFullName(fullName);

            System.out.print("Enter new dateOfBirth(dd/MM/yyyy): ");
            String dateOfBirthStr = keyboard.nextLine();
            try {
                Date dateOfBirth = sdf.parse(dateOfBirthStr);
                student.setDateOfBirth(dateOfBirth);
            } catch (Exception e) {
                System.out.println("Error (dd/MM/yyyy).");
            }

            System.out.print("Enter new GPA: ");
            float gpa = keyboard.nextFloat();
            student.setGPA(gpa);
            keyboard.nextLine();
            
            System.out.print("Enter new major: ");
            String major = keyboard.nextLine();
            student.setMajor(major);

            return true;
        } else {
            System.out.print("Not found id:  " + id);
            return false;
        }
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    void displayAllStudent() {
        for (Student student : studentList) {
            student.displayInfo();
        }
    }

    Student findTopStudent() {
        Student top = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGPA() > top.getGPA()) {
                top = student;
            }
        }
        return top;
    }

}
