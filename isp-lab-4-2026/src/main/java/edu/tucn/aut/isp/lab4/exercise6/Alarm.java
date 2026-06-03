package edu.tucn.aut.isp.lab4.exercise6;

public class Alarm extends Actuator {
    public Alarm(String manufacturer, String model){
        super(manufacturer, model);
    }

    @Override
    public void turnOn(){
        super.turnOn();
        System.out.println("Alarma pornita");
    }

    public void turnOff(){
        super.turnOff();
        System.out.println("Alarma oprita");
    }
}