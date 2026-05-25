package isp.lab3.exercise4;

public class MainOfExercise4 {
    public static void main(String[] args) {

        System.out.println("=== Testare MyPoint ===");

        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(3, 4, 5);

        System.out.println("Punctul 1: " + p1.toString());
        System.out.println("Punctul 2: " + p2.toString());

        double distanta = p1.distance(p2);
        System.out.println("Distanța dintre p1 și p2: " + distanta);

        p1.setXYZ(1, 1, 1);
        System.out.println("\nDupă modificarea lui p1 la coordonatele (1, 1, 1):");
        System.out.println("Noua distanță dintre p1 și p2: " + p1.distance(p2));

        System.out.println("Distanța de la p2 la originea (0, 0, 0): " + p2.distance(0, 0, 0));
    }
}