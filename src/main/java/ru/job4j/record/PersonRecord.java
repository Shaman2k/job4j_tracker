package ru.job4j.record;

public record PersonRecord(String name, int age) {
    public static int maxAge = 100;

    public PersonRecord {
        if (age > maxAge) {
            throw new IllegalArgumentException("Возраст должен быть менее 101");
        }
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public void info() {
        System.out.println("Напечатать информацию");
    }
}
