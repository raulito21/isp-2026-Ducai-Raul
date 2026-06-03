package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {
        Lights l1 = new Lights();
        AquariumController c1 = new AquariumController("Bosch", "22", null, LocalTime.of(12, 0), l1,
                LocalTime.of(8,0), LocalTime.of(16,0));
        System.out.println("test ora 10");
        c1.setCurrentTime(LocalTime.of(10, 0));
        System.out.println("test ora 23");
        c1.setCurrentTime(LocalTime.of(23, 0));
    }
}
