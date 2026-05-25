package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {

    public static void main(String[] args) {
        // 1. Create an object
        AquariumController controller = new AquariumController("AquaTech", "SmartReef", LocalTime.of(10, 0));

        // 2. Afișăm starea inițială
        System.out.println("Starea inițială:");
        System.out.println(controller.toString());

        // 3. Modificăm timpul curent
        System.out.println("\nModificăm timpul...");
        controller.setCurrentTime(LocalTime.of(14, 30));

        // 4. Afișăm starea după modificare pentru a testa că `setCurrentTime` a funcționat
        System.out.println("Starea după actualizare:");
        System.out.println(controller.toString());
    }
}