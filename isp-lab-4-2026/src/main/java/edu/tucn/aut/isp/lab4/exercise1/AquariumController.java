package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;

    //constructors


    public AquariumController(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer: " + this.manufacturer +
                " model: " + this.model +
                " current time: " + this.currentTime + "}";
    }
}
