package edu.tucn.aut.isp.lab4.exercise6;

public class Actuator {
    private String manufacturer;
    private String model;
    protected boolean on;

    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn(){
        on = true;
    }

    public void turnOff(){
        on = false;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", isOn=" + on +
                '}';
    }
}