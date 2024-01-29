package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int amount);

    int fill(int amount);
}
