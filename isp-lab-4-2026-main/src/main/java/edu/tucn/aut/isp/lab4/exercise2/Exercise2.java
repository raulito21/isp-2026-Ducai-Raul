package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFood 300");

        System.out.println("=== Testare FishFeeder ===");

        System.out.println(feeder.toString());

        feeder.feed();

        feeder.fillUp();

        feeder.feed();
        feeder.feed();

            System.out.println("\nStare finală: ");
        System.out.println(feeder.toString());
    }
}