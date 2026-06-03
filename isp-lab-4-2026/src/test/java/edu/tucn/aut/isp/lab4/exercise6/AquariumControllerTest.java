package edu.tucn.aut.isp.lab4.exercise6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AquariumControllerTest {

    @Test
    void testTestTemperatureBelow(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPresetTemperature(25);

        ts.setValue(20);
        aquariumController.checkTemperature();

        assertTrue(h.isOn());
    }

    @Test
    void testTestTemperatureEquals(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPresetTemperature(25);

        ts.setValue(25);
        aquariumController.checkTemperature();

        assertFalse(h.isOn());
    }

    @Test
    void testTestLevelBelow(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPresetLevel(50);

        ls.setValue(30);
        aquariumController.checkLevel();

        assertTrue(al.isOn());
    }

    @Test
    void testTestLevelAbove(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPresetLevel(50);

        ls.setValue(60);
        aquariumController.checkLevel();

        assertFalse(al.isOn());
    }

    @Test
    void testTestPHBelow(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");
        PHSensor phSensor = new PHSensor("Bosch", "PH200");
        PHRegulator phRegulator = new PHRegulator("Philips", "PHR2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPhSensor(phSensor);
        aquariumController.setPhRegulator(phRegulator);
        aquariumController.setMinPH(6.5);
        aquariumController.setMaxPH(7.5);

        phSensor.setValue(6);
        aquariumController.checkPH();

        assertTrue(phRegulator.isOn());
    }
    @Test
    void testTestPHExtreme(){
        TemperatureSensor ts = new TemperatureSensor("Bosch", "T200");
        LevelSensor ls = new LevelSensor("Bosch", "L200");
        Heater h = new Heater("Philips", "H2");
        Alarm al = new Alarm("Philips", "AL2");
        PHSensor phSensor = new PHSensor("Bosch", "PH200");
        PHRegulator phRegulator = new PHRegulator("Philips", "PHR2");

        AquariumController aquariumController = new AquariumController("ACME", "X22", ts, ls, h, al);
        aquariumController.setPhSensor(phSensor);
        aquariumController.setPhRegulator(phRegulator);
        aquariumController.setMinPH(6.5);
        aquariumController.setMaxPH(7.5);

        phSensor.setValue(10);
        aquariumController.checkPH();

        assertTrue(al.isOn());
    }
}
