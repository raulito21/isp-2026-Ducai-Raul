package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {

    public static void main(String[] args) {
        //create an object
        AquariumController aquariumController = new AquariumController("Bosch", "B1");
        System.out.println(aquariumController);

        aquariumController.setCurrentTime(LocalTime.of(2,3,5));
        System.out.println(aquariumController);
    }
}
