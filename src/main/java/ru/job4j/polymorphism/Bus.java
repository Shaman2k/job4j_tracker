package ru.job4j.polymorphism;

public class Bus implements Transport {
    private int passengers;
    private int fuelPrice = 60;

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int amount) {
        this.passengers = amount;
    }

    @Override
    public int fill(int amount) {
        return amount * fuelPrice;
    }
}
