package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {

        Chargeable laptop = new Laptop();
        Chargeable phone = new SmartPhone();
        Chargeable watch = new SmartWatch();

        int chargeTime = 15; // minute
        System.out.println("Punem dispozitivele la încărcat pentru " + chargeTime + " minute...\n");

        laptop.charge(chargeTime);
        phone.charge(chargeTime);
        watch.charge(chargeTime);

        System.out.println("Nivel baterie Laptop (1%/min): " + laptop.getBatteryLevel() + "%");
        System.out.println("Nivel baterie SmartPhone (5%/min): " + phone.getBatteryLevel() + "%");
        System.out.println("Nivel baterie SmartWatch (2%/min): " + watch.getBatteryLevel() + "%");

        System.out.println("\nLăsăm telefonul încă 20 de minute (ar trebui să se plafoneze la 100%)...");
        phone.charge(20);
        System.out.println("Nivel baterie SmartPhone după extra încărcare: " + phone.getBatteryLevel() + "%");
    }
}