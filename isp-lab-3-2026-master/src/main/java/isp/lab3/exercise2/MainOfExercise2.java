package isp.lab3.exercise2;

public class MainOfExercise2 {

    public static void main(String[] args) {

        System.out.println("=== Testare Dreptunghi Custom ===");
        Rectangle customRect = new Rectangle(5, 3, "blue");

        System.out.println("Lungime: " + customRect.getLength());
        System.out.println("Lățime: " + customRect.getWidth());
        System.out.println("Culoare: " + customRect.getColor());
        System.out.println("Perimetru: " + customRect.getPerimeter());
        System.out.println("Arie: " + customRect.getArea());

        System.out.println("\n=== Testare Dreptunghi Default ===");
        Rectangle defaultRect = new Rectangle();

        System.out.println("Lungime default: " + defaultRect.getLength());
        System.out.println("Lățime default: " + defaultRect.getWidth());
        System.out.println("Culoare default: " + defaultRect.getColor());
        System.out.println("Perimetru: " + defaultRect.getPerimeter());
        System.out.println("Arie: " + defaultRect.getArea());
    }
}