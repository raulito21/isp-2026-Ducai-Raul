package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();

        Student s1 = new Student("ID01", "Alexandru Popescu");
        Student s2 = new Student("ID02", "Maria Ionescu");
        system.addStudent(s1);
        system.addStudent(s2);

        system.addGrade("ID01", "Math", 10);
        system.addGrade("ID01", "Physics", 8);
        system.addGrade("ID02", "Math", 9);
        system.addGrade("ID02", "English", 10);

        System.out.println("Dupa adaugarea notelor:");
        system.displayStudents();

        system.updateStudent("ID02", "Maria Popa");
        System.out.println("\nDupa actualizarea numelui pentru Maria:");
        system.displayStudents();

        System.out.println("\nMedia studentului Alex (ID01) calculata din sistem: " + system.calculateAverage("ID01"));

        system.removeStudent("ID01");
        System.out.println("\nDupa stergerea lui Alex:");
        system.displayStudents();
    }
}