package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;
    public Lights(){
        this.isOn=false;
    }
    public void turnOn(){
        isOn=true;
        System.out.println("Light is on");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("Light is off");
    }

    public boolean getIsOn() {
        return isOn;
    }
}
