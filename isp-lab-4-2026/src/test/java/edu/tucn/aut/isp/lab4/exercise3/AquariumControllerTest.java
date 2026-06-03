package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class AquariumControllerTest {

    @Test
    public void testFeedingCorrectTime() {
        FishFeeder feeder = new FishFeeder("Bosch", "DB");
        feeder.fillUp();
        LocalTime lunch = LocalTime.of(12, 0);
        AquariumController c1 = new AquariumController("Daimler", "21", feeder, lunch);
        c1.setCurrentTime(LocalTime.of(12, 0));
        String feederStatus = feeder.toString();
        assertTrue(feederStatus.contains("meals=13"),
                "Status actual: " + feederStatus);
    }
}