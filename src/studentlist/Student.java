package studentlist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {

    private float GPA;
    private String major;

    
    public Student(float GPA, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    public Student(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }

    Student() {
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    void addStudent() {
        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat day = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter id: ");
        String id = keyboard.nextLine();
        setId(id);
        System.out.print("Enter Fullname: ");
        String fullName = keyboard.nextLine();
        setFullName(fullName);
        
        System.out.print("Enter DateofBirth(dd/MM/yyyy)): ");
        String dateOfBirth = keyboard.nextLine();
        try {
            Date date = day.parse(dateOfBirth);
            setDateOfBirth(date);
        } catch (Exception e) {
            System.err.println("Error! (dd/MM/yyyy)");
        }
        System.out.print("Enter GPA: ");
        float GPA = keyboard.nextFloat();
        setGPA(GPA);
        keyboard.nextLine();
        System.out.print("Enter Major: ");
        String major = keyboard.nextLine();
        setMajor(major);
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Id: " + getId());
        System.out.println("Fullname: " + getFullName());
        System.out.println("GPA: " + getGPA());
        System.out.println("Major: " + getMajor());
        
        if (getDateOfBirth() != null) {
            System.out.println("Date of Birth: " + date.format(getDateOfBirth()));
        } else {
            System.out.println("Date of Birth: N/A");
        }
    }
}
