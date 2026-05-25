package isp.lab6.exercise1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise1 {

    @Test
    public void testAddStudent() {
        GradeManagementSystem system = new GradeManagementSystem();
        Student s = new Student("S1", "Test Name");

        system.addStudent(s);

        assertEquals(1, system.getStudents().size(), "Lista ar trebui să conțină exact un student.");
        assertEquals("Test Name", system.getStudents().get(0).getName(), "Numele studentului trebuie să se potrivească.");
    }

    @Test
    public void testAddStudentGrades() {
        GradeManagementSystem system = new GradeManagementSystem();
        Student s = new Student("S1", "Test Name");
        system.addStudent(s);

        system.addGrade("S1", "Programming", 10);

        assertEquals(10, s.getGrades().get("Programming"), "Nota adăugată trebuie să fie 10 pentru Programming.");
    }

    @Test
    public void testRemoveStudent() {
        GradeManagementSystem system = new GradeManagementSystem();
        Student s = new Student("S1", "Test Name");
        system.addStudent(s);

        system.removeStudent("S1");

        assertEquals(0, system.getStudents().size(), "Lista ar trebui să fie goală după ștergere.");
    }

    @Test
    public void testUpdateStudent() {
        GradeManagementSystem system = new GradeManagementSystem();
        Student s = new Student("S1", "Old Name");
        system.addStudent(s);

        system.updateStudent("S1", "New Name");

        assertEquals("New Name", system.getStudents().get(0).getName(), "Numele studentului ar trebui să fie actualizat.");
    }
}