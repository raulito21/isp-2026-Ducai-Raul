package edu.tucn.aut.isp.lab4.exercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FishFeederTest {

    @Test
    public void testFillUp() {
        FishFeeder feeder = new FishFeeder("Bosch", "22");
        feeder.fillUp();
        assertTrue(feeder.toString().contains("meals=14"), "Mesele ar trebui sa fie 14 dupa fillUp.");
    }
    @Test
    public void testFeed() {
        FishFeeder feeder = new FishFeeder("Bosch", "22");
        feeder.fillUp();
        feeder.feed();
        assertTrue(feeder.toString().contains("meals=13"), "Mesele ar trebui sa fie 13 dupa feed");
    }
    @Test
    public void testFeedWhenEmpty() {
        FishFeeder feeder = new FishFeeder("Bosch", "22");
        feeder.feed();
        assertTrue(feeder.toString().contains("meals=0"), "Mesele se reseteaza");
    }
}