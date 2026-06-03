package edu.tucn.aut.isp.lab4.exercise4;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LightsTest {
    @Test
    public void testLightsWithAssertEquals() {
        Lights lights = new Lights();
        AquariumController c = new AquariumController(
                "Bosch", "22", null, null, lights,
                LocalTime.of(8, 0), LocalTime.of(16, 0));

        //verificam daca e stinsa
        assertEquals(false, lights.getIsOn(), "Lumina ar trebui să fie OFF inițial.");
        c.setCurrentTime(LocalTime.of(10, 0));
        assertEquals(true, lights.getIsOn(), "Lumina ar trebui să fie ON la ora 10:00.");
        //verificam ora in afara intervalului
        c.setCurrentTime(LocalTime.of(20, 0));
        assertEquals(false, lights.getIsOn(), "Lumina ar trebui să fie OFF la ora 20:00.");
    }
}
