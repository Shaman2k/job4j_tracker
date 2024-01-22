package ru.job4j.format;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name) {
        System.out.println(String.format("Привет! Я %s", name));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Елена");
        System.out.println(String.format("Привет! Я %s, мой возраст: %s", "name", "33"));
        System.out.println(String.format("Привет! Я %s, мой возраст: %d", "name", 22));
        System.out.format("Строка1%nСтрока2");
        getGreetingAndTime("Николай");
        System.out.println(String.format("Задаем число 0.99 - %f", 0.99));
        System.out.println(String.format("Задаем число 0.99 - %.3f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));

    }
}
