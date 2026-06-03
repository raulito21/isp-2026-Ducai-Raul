package edu.tucn.aut.isp.lab4.exercise6;

public class PHRegulator extends Actuator{
    public PHRegulator(String manufacturer, String model){
        super(manufacturer, model);
    }

    public void incrPH(){
        turnOn();
    }

    public void decrPH(){
        turnOn();
    }
}