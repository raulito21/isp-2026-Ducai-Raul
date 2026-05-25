package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String id;
    private String name;
    private HashMap<String, Integer> grades;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public HashMap<String, Integer> getGrades() { return grades; }

    public void addGrade(String subject, Integer grade) {
        this.grades.put(subject, grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (Integer grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                ", average=" + String.format("%.2f", calculateAverage()) +
                '}';
    }
}