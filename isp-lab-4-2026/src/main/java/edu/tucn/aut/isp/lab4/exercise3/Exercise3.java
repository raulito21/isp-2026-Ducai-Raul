package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Bosch", "DB");
        feeder.fillUp();
        LocalTime lunch = LocalTime.of(12, 0);
        AquariumController c1 = new AquariumController("ControlMaster", "v2", feeder, lunch);
        System.out.println("Stare initiala: " + feeder);
        System.out.println("Setam ora la 11:00");
        c1.setCurrentTime(LocalTime.of(11, 0));
        System.out.println("Setam ora la 12:00");
        c1.setCurrentTime(LocalTime.of(12, 0));
        System.out.println("Stare finala: " + feeder);
    }
}
