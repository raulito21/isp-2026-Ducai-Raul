package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();

        Vehicle v1 = new Vehicle("VIN12345", "CJ-01-ABC", "Toyota", "Corolla", 2020);
        Vehicle v2 = new Vehicle("VIN98765", "B-99-XYZ", "Honda", "Civic", 2019);

        Vehicle v3 = new Vehicle("VIN12345", "TM-55-QWE", "Ford", "Focus", 2022);

        registry.addVehicle(v1);
        registry.addVehicle(v2);
        registry.addVehicle(v3);

        registry.displayVehicles();

        System.out.println("Există vehiculul cu VIN98765? " + registry.containsVehicle("VIN98765"));
        System.out.println("Există vehiculul cu VIN00000? " + registry.containsVehicle("VIN00000"));

        System.out.println();
        registry.removeVehicle("VIN12345");

        registry.displayVehicles();
    }
}