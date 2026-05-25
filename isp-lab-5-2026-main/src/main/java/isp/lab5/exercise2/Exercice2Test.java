package isp.lab5.exercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise2Test {

    @Test
    public void testChargeLimit100() {
        Chargeable phone = new SmartPhone();


        phone.charge(30);

        assertEquals(100, phone.getBatteryLevel(), "Bateria nu ar trebui să depășească 100%!");
    }

    @Test
    public void testSmartWatchChargingSpeed() {
        Chargeable watch = new SmartWatch();

        /
        watch.charge(10);

        assertEquals(20, watch.getBatteryLevel(), "SmartWatch-ul trebuie să ajungă la 20% în 10 minute.");
    }
}