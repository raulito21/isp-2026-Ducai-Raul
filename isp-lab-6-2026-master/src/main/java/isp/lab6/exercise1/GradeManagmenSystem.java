package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class GradeManagementSystem {
    private List<Student> students;

    public GradeManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addGrade(String studentId, String subject, Integer grade) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                s.addGrade(subject, grade);
                return;
            }
        }
        System.out.println("Studentul cu ID-ul " + studentId + " nu a fost găsit!");
    }


    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getId().equals(studentId));
    }

    public void updateStudent(String studentId, String newName) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                s.setName(newName);
                return;
            }
        }
        System.out.println("Studentul cu ID-ul " + studentId + " nu a fost găsit!");
    }

    public double calculateAverage(String studentId) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                return s.calculateAverage();
            }
        }
        return 0.0;
    }


    public void displayStudents() {
        System.out.println("=== Lista Studenți ===");
        if (students.isEmpty()) {
            System.out.println("Lista este goală.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
        System.out.println("======================");
    }

    public List<Student> getStudents() {
        return students;
    }
}