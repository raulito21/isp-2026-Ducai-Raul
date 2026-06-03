package edu.tucn.aut.isp.lab4.exercise6;

public class Exercise6 {
    public static void main(String[] args) {
        TemperatureSensor t1 = new TemperatureSensor("Bosch", "25");
        LevelSensor l1 = new LevelSensor("Bosch", "22");
        PHSensor phS1 = new PHSensor("Bosch", "21");

        Heater h1 = new Heater("Herculane", "55");
        Alarm a1 = new Alarm("Danubis", "MRC");
        PHRegulator ph1 = new PHRegulator("Marius", "S22");

        AquariumController aquariumController = new AquariumController("Sony", "2", t1, l1, h1, a1);
        aquariumController.setPhSensor(phS1);
        aquariumController.setPhRegulator(ph1);
        aquariumController.setPresetTemperature(25);
        aquariumController.setPresetLevel(50);
        aquariumController.setMinPH(6.5);
        aquariumController.setMaxPH(7.5);

        t1.setValue(20);
        aquariumController.checkTemperature();
        System.out.println("Heater ON: " + h1.isOn());

        l1.setValue(60);
        aquariumController.checkLevel();
        System.out.println("Alarm ON: " + a1.isOn());

        phS1.setValue(5);
        aquariumController.checkPH();
        System.out.println("PH Regulator ON: " + ph1.isOn());
        System.out.println("Alarm ON: " + a1.isOn());

        phS1.setValue(7);
        aquariumController.checkPH();
        System.out.println("PH Regulator ON: " + ph1.isOn());
        System.out.println("Alarm ON: " + a1.isOn());

        phS1.setValue(9);
        aquariumController.checkPH();
        System.out.println("PH Regulator ON: " + ph1.isOn());
        System.out.println("Alarm ON: " + a1.isOn());

        phS1.setValue(10);
        aquariumController.checkPH();
        System.out.println("PH Regulator ON: " + ph1.isOn());
        System.out.println("Alarm ON: " + a1.isOn());
    }
}
