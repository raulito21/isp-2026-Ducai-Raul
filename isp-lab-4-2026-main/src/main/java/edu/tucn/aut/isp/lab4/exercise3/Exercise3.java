package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFood");
        feeder.fillUp();

        LocalTime initialTime = LocalTime.of(8, 0);
        LocalTime feedingTime = LocalTime.of(12, 0);

        AquariumController controller = new AquariumController("AquaTech", "SmartReef", initialTime, feedingTime, feeder);

        System.out.println("\n=== Starea inițială ===");
        System.out.println(controller.toString());

        System.out.println("\n=== Schimbăm ora la 10:00 ===");
        controller.setCurrentTime(LocalTime.of(10, 0));

        System.out.println("\n=== Schimbăm ora la 12:00 (Ora de masă) ===");
        controller.setCurrentTime(LocalTime.of(12, 0));

        System.out.println("\n=== Starea finală ===");
        System.out.println(controller.toString());
    }
}