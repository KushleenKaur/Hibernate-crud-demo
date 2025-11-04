package com.example.app;

import java.util.List;

import com.example.dao.StudentDAO;
import com.example.entity.Student;
import com.example.util.HibernateUtil;

public class StudentCRUDDemo {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        
        System.out.println("Hibernate CRUD Operations Demo");
        System.out.println("==============================");
        
        // Create operation - Add new students
        System.out.println("\n1. Creating new students...");
        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");
        Student student3 = new Student("Mike", "Johnson", "mike.johnson@example.com");
        
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        studentDAO.saveStudent(student3);
        System.out.println("Students created successfully!");
        
        // Read operation - Get all students
        System.out.println("\n2. Reading all students...");
        List<Student> students = studentDAO.getAllStudents();
        displayStudents(students);
        
        // Assuming the first student has ID 1 (adjust if your DB has different IDs)
        int studentId = students.get(0).getId();
        
        // Read operation - Get student by ID
        System.out.println("\n3. Reading student with ID: " + studentId);
        Student retrievedStudent = studentDAO.getStudent(studentId);
        System.out.println(retrievedStudent);
        
        // Update operation
        System.out.println("\n4. Updating student with ID: " + studentId);
        retrievedStudent.setFirstName("John Updated");
        retrievedStudent.setEmail("john.updated@example.com");
        studentDAO.updateStudent(retrievedStudent);
        
        // Verify the update
        System.out.println("After update:");
        retrievedStudent = studentDAO.getStudent(studentId);
        System.out.println(retrievedStudent);
        
        // Delete operation
        System.out.println("\n5. Deleting student with ID: " + studentId);
        studentDAO.deleteStudent(studentId);
        
        // Verify the deletion
        System.out.println("After deletion:");
        students = studentDAO.getAllStudents();
        displayStudents(students);
        
        // Close Hibernate SessionFactory
        System.out.println("\nClosing Hibernate SessionFactory...");
        HibernateUtil.shutdown();
        System.out.println("Done!");
    }
    
    private static void displayStudents(List<Student> students) {
        if (students != null && !students.isEmpty()) {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students found.");
        }
    }
}