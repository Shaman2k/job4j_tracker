package ru.job4j.exis.io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal("Murka", 3);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Murka cat", 4);
        Animal cat3 = new Cat();
        Animal cat4 = new Cat("Murka cat animal", 5);
        animal1.printInfo();
        animal2.printInfo();
        cat1.printInfo();
        cat2.printInfo();
        cat3.printInfo();
        cat4.printInfo();
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

    }
}
