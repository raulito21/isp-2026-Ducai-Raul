package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder f1=new FishFeeder("Bosch", "B3");
        System.out.println(f1);
        f1.feed();
        f1.fillUp();
        f1.feed();

    }
}
