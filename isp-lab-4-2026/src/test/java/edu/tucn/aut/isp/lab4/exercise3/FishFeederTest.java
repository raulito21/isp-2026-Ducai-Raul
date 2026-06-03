package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class FishFeederTest {

    @Test
    public void testFeeding() {
        FishFeeder f1 = new FishFeeder("Bosch", "DB");
        f1.fillUp();
        LocalTime programare = LocalTime.of(14, 0);
        AquariumController c1 = new AquariumController("Emerson", "11", f1, programare);
        c1.setCurrentTime(LocalTime.of(10, 0));
        assertTrue(f1.toString().contains("meals=14"), "Mesele nu scad la ora 10");

        c1.setCurrentTime(LocalTime.of(14, 0));

        String status = f1.toString();
        assertTrue(status.contains("meals=13"),
                "Mesele ar fi trebufit să scada la 13");
    }
}