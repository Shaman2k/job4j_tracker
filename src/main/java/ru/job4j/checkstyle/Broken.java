package ru.job4j.checkstyle;

public class Broken {
    public static final String NEW_VALUE = "";
    private String surname;
    private String name;
    private int sizeOfEmpty = 10;

    void echo() { }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a, int b) { }

    Broken() { }
}
