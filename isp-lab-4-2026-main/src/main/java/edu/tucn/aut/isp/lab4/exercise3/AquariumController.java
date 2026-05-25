package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;

    private FishFeeder feeder;

    public AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        System.out.println("Timpul curent a fost setat la: " + this.currentTime);

        if (this.currentTime.equals(this.feedingTime)) {
            System.out.println("E timpul pentru masă!");
            if (this.feeder != null) {
                this.feeder.feed(); // Declanșăm hrănirea
            }
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", feeder=" + feeder +
                '}';
    }
}