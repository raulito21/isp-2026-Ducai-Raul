package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private Set<Vehicle> vehicles;

    public VehicleRegistry() {
        this.vehicles = new HashSet<>();
    }

    public void addVehicle(Vehicle vehicle) {
        boolean added = vehicles.add(vehicle);
        if (added) {
            System.out.println("Vehiculul a fost adăugat cu succes: " + vehicle.getVin());
        } else {
            System.out.println("Eroare: Un vehicul cu VIN-ul " + vehicle.getVin() + " există deja în registru!");
        }
    }

    public void removeVehicle(String vin) {
        // removeIf șterge elementul dacă respectă condiția dată
        boolean removed = vehicles.removeIf(v -> v.getVin().equals(vin));
        if (removed) {
            System.out.println("Vehiculul cu VIN-ul " + vin + " a fost șters.");
        } else {
            System.out.println("Vehiculul cu VIN-ul " + vin + " nu a fost găsit.");
        }
    }

    public boolean containsVehicle(String vin) {
        for (Vehicle v : vehicles) {
            if (v.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }

    public void displayVehicles() {
        System.out.println("\n=== Registru Vehicule ===");
        if (vehicles.isEmpty()) {
            System.out.println("Registrul este gol.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
        System.out.println("=========================\n");
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
}