package edu.tucn.aut.isp.lab4.exercise6;

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

    private int presetTemperature;
    private float presetLevel;

    private PHSensor phSensor;
    private PHRegulator phRegulator;

    private double minPH;
    private double maxPH;

    public AquariumController(String manufacturer, String model, TemperatureSensor ts, LevelSensor ls, Heater h, Alarm al) {
        this.manufacturer = manufacturer;
        this.model = model;
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

    public void checkPH(){
        float value = phSensor.getValue();

        if (value<minPH){
            phRegulator.incrPH();
        } else if (value>maxPH){
            phRegulator.decrPH();
        } else{
            phRegulator.turnOff();
        }

        if (value<5.0 || value>9.0){
            al.turnOn();
        }
    }

    public void setPhSensor(PHSensor phSensor) {
        this.phSensor = phSensor;
    }

    public void setPhRegulator(PHRegulator phRegulator) {
        this.phRegulator = phRegulator;
    }

    public void setMinPH(double minPH) {
        this.minPH = minPH;
    }

    public void setMaxPH(double maxPH) {
        this.maxPH = maxPH;
    }

    public void setPresetTemperature(int presetTemperature) {
        this.presetTemperature = presetTemperature;
    }

    public void setPresetLevel(float presetLevel) {
        this.presetLevel = presetLevel;
    }
}