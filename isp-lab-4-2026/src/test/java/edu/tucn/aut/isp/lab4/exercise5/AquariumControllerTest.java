package edu.tucn.aut.isp.lab4.exercise5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumControllerTest {

    @Test
    void verifTemperature() {
        TemperatureSensor t1 = new TemperatureSensor("Bosch", "T1");
        LevelSensor l1 = new LevelSensor("Bosch", "L3");
        Heater h1 = new Heater("Philips", "H1");
        Alarm a1 = new Alarm("Philips", "A3");
        FishFeeder f1 = new FishFeeder("Samsung", "Aqua 1000");
        AquariumController aquariumController = new AquariumController("ACME", "X1", f1, t1, l1, h1, a1);
        t1.setValue(21);
        aquariumController.checkTemperature();
        assertTrue(h1.isOn());

        t1.setValue(26);
        aquariumController.checkTemperature();
        assertFalse(h1.isOn());

    }

    @Test
    void checkLevel() {
        TemperatureSensor t1 = new TemperatureSensor("Bosch", "21");
        LevelSensor l1 = new LevelSensor("Bosch", "23");
        Heater h1 = new Heater("Acer", "V15");
        Alarm a1 = new Alarm("Lenovo", "Legion");
        FishFeeder f1 = new FishFeeder("Marius", "Apaclear");
        AquariumController aquariumController = new AquariumController("ACME", "X1", f1, t1, l1, h1, a1);

        l1.setValue(29);
        aquariumController.checkLevel();
        assertTrue(a1.isOn());

        l1.setValue(31);
        aquariumController.checkLevel();
        assertFalse(a1.isOn());
    }
}