package edu.tucn.aut.isp.lab4.exercise4;

import edu.tucn.aut.isp.lab4.exercise4.FishFeeder;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder fishFeeder;
    private Lights lights;
    private LocalTime lightOnTime;
    private LocalTime lightOffTime;

    public AquariumController(String manufacturer, String model, FishFeeder fishFeeder, LocalTime feedingTime, Lights lights,
                              LocalTime lightOnTime, LocalTime lightOffTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fishFeeder = fishFeeder;
        this.feedingTime = feedingTime;
        this.currentTime = LocalTime.now();
        this.lights = lights;
        this.lightOnTime = lightOnTime;
        this.lightOffTime = lightOffTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime.equals(feedingTime)) {
            fishFeeder.feed();
        }
        if ((currentTime.isAfter(lightOnTime) || currentTime.equals(lightOnTime))
                && currentTime.isBefore(lightOffTime)) {

            if (!lights.getIsOn()) {
                lights.turnOn();
            }
        } else {
            if (lights.getIsOn()) {
                lights.turnOff();
            }
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" + "manufacturer=" + manufacturer + ", model=" + model +
                ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + '}';
    }
}