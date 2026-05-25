package isp.lab3.example;

import java.time.LocalDateTime;

public class Airplane {

    private String model;
    private int maxCapacity;
    private int cruisingSpeed;
    private int maxRange;
    private LocalDateTime departureTime;
    private int currentPassengers;

    public Airplane(String model, int maxCapacity, int cruisingSpeed, int maxRange, LocalDateTime departureTime) {
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.cruisingSpeed = cruisingSpeed;
        this.maxRange = maxRange;
        this.departureTime = departureTime;
        this.currentPassengers = 0; }

    public boolean isLate() {
        return departureTime.isBefore(LocalDateTime.now());
    }



    public void loadPassengers(int passengersToLoad) {
        if (this.currentPassengers + passengersToLoad <= this.maxCapacity) {
            this.currentPassengers += passengersToLoad;
        }
   }


    public int getPassengers() {
        return this.currentPassengers;
    }
}