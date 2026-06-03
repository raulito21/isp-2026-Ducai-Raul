package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder fishFeeder;

    public AquariumController(String manufacturer, String model, FishFeeder fishFeeder, LocalTime feedingTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fishFeeder = fishFeeder;
        this.feedingTime = feedingTime;
        this.currentTime = LocalTime.now();
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime.equals(feedingTime)) {
            fishFeeder.feed();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" + "manufacturer=" + manufacturer + ", model=" + model +
                ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + '}';
    }
}