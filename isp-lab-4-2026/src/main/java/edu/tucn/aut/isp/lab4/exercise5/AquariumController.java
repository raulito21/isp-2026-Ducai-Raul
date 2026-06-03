package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder f;

    private TemperatureSensor ts;
    private LevelSensor ls;
    private Heater h;
    private Alarm al;

    private int presetTemperature=26;
    private float presetLevel=30;

    public AquariumController(String manufacturer, String model, FishFeeder f, TemperatureSensor ts, LevelSensor ls, Heater h, Alarm al) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.f = f;
        this.ts = ts;
        this.ls = ls;
        this.h = h;
        this.al = al;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime.equals(feedingTime)) {
            f.feed();
        }
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void checkTemperature(){
        float temp=ts.getValue();
        if (temp<presetTemperature){
            h.turnOn();
        }else if (temp==presetTemperature){
            h.turnOff();
        }
    }

    public void checkLevel(){
        float level=ls.getValue();
        if (level<presetLevel) {
            al.turnOn();
        }else{
            al.turnOff();
        }
    }
}