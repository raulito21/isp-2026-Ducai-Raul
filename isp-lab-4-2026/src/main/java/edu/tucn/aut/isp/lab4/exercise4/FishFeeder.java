package edu.tucn.aut.isp.lab4.exercise4;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }

    public void fillUp(){
        this.meals=14;
        System.out.println("The feeder has been refilled to 14 meals");
    }
    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("Feeding the fish... Remaining meals: " + meals);
        } else {
            System.out.println("The feeder is empty.");
        }
    }
        @Override
        public String toString(){
            return "FishFeeder{" +
                    "manufacturer= " + manufacturer +
                    " model='" + model +
                    " meals=" + meals +
                    '}';
        }
}
