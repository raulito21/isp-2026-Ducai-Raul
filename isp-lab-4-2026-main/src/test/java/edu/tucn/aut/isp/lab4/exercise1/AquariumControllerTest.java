package edu.tucn.aut.isp.lab4.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

class AquariumControllerTest {

    @Test
    void testSetCurrentTimeReflectedInToString() {
        AquariumController controller = new AquariumController("AquaTech", "SmartReef", LocalTime.of(9, 0));

        LocalTime newTime = LocalTime.of(18, 15);

        controller.setCurrentTime(newTime);

        String result = controller.toString();

        Assertions.assertTrue(result.contains(newTime.toString()),
                "Metoda toString() ar trebui să reflecte noul timp setat!");
    }

    @Test
    void dummyTestNPE() {
        Assertions.assertThrows(
                NullPointerException.class, () -> {Integer nullInt = null; nullInt.toString();});
    }
}