package edu.tucn.aut.isp.lab4.exercise5;

public class Exercise5 {
    public static void main(String[] args) {
        TemperatureSensor t1 = new TemperatureSensor("Bosch", "21");
        LevelSensor l1 = new LevelSensor("Bosch", "23");
        Heater h1 = new Heater("Makita", "21");
        Alarm a1 = new Alarm("Dacia", "L1");
        FishFeeder fishFeeder = new FishFeeder("Marcel", "Micro1");
        AquariumController aquariumController = new AquariumController("Sony", "22", fishFeeder, t1, l1, h1, a1);
        t1.setValue(21);
        aquariumController.checkTemperature();

        t1.setValue(27);
        aquariumController.checkTemperature();

        l1.setValue(28);
        aquariumController.checkLevel();

        l1.setValue(30);
        aquariumController.checkLevel();

    }
}