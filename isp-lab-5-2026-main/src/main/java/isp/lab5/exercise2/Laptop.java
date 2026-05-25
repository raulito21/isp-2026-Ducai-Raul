package isp.lab5.exercise2;

public class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop() {
        this.batteryLevel = 0;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int duration) {

        int chargeAmount = duration * 1;
        this.batteryLevel += chargeAmount;

        if (this.batteryLevel > 100) {
            this.batteryLevel = 100;
        }
    }
}