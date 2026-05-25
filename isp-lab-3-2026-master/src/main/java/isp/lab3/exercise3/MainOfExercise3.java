package isp.lab3.exercise3;

public class MainOfExercise3 {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle v2 = new Vehicle("Renault", "Megane", 180, 'D');

        System.out.println("=== Testare Gettere și Settere ===");
        System.out.println("Modelul lui v1 înainte de modificare: " + v1.getModel());
        v1.setModel("Dacia Nova"); // test setter
        System.out.println("Modelul lui v1 după modificare: " + v1.getModel());
        v1.setModel("Dacia");

        System.out.println("\n=== Testare metoda equals ===");
        System.out.println("Sunt v1 și v2 identice? " + v1.equals(v2)); // Va returna false

        Vehicle v3 = new Vehicle("Dacia", "Logan", 150, 'B');
        System.out.println("Sunt v1 și v3 identice? " + v1.equals(v3)); // Va returna true

        System.out.println("\n=== Testare contor static ===");
        Vehicle.displayVehicleCount();

        System.out.println("\n=== Testare metoda toString ===");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }
}