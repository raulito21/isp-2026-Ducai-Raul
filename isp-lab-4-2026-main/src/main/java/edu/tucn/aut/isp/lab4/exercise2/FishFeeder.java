package edu.tucn.aut.isp.lab4.exercise2;

public class FishFeeder {

    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }

    public void fillUp() {
        this.meals = 14;
        System.out.println("Hrănitorul a fost umplut. Porții disponibile: " + this.meals);
    }


    public void feed() {
        if (this.meals > 0) {
            this.meals--;
            System.out.println("Peștii au fost hrăniți! Porții rămase: " + this.meals);
        } else {
            System.out.println("Atenție: Hrănitorul este gol! Vă rugăm să folosiți funcția fillUp().");
        }
    }


    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}