package edu.tucn.aut.isp.lab4.exercise6;

public class PHSensor extends Sensor {
    private float value;

    public PHSensor(String manufacturer, String model){
        super(manufacturer, model);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}