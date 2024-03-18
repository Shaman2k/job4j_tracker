package ru.job4j.exis.io;

public class Cat extends Animal {
    public Cat() {

    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    protected void printInfo() {
        System.out.print("класс Cat :");
        super.printInfo();
    }

    @Override
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Cat");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Cat");
    }
}
