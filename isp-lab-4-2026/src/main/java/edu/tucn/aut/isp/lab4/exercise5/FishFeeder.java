package edu.tucn.aut.isp.lab4.exercise5;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    private static final int MAX_MEALS = 14;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }



    public void fillUp(){
        meals = MAX_MEALS;
        System.out.println("Fish feeder refilled to " + meals + " meals.");
    }

    public void feed(){
        if (meals>0){
            meals--;
            System.out.println("Fish has been fed. Meals left: " + meals);
        } else{
            System.out.println("No meals left. Please refill.");
        }
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';}
    public int getMeals() {
        return meals;
    }
}