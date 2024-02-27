package ru.job4j.exis.io;

public class Task15 {
    public static void main(String[] args) {
        String source = "+!?";
        StringBuilder sb = new StringBuilder();
        sb.append(source.charAt(0));
        sb.append(source.charAt(0));
        sb.append(source.charAt(0));
        sb.append(System.lineSeparator());
        sb.append(source.charAt(1));
        sb.append(source.charAt(1));
        sb.append(source.charAt(1));
        sb.append(source.charAt(1));
        sb.append(System.lineSeparator());
        sb.append(source.charAt(2));
        sb.append(source.charAt(2));
        System.out.print(sb.toString());
        System.out.println();

        Animal animal = new Animal();
        Animal cat = new Cat();
        animal.instanceInvoke();
        cat.instanceInvoke();
        Animal.staticInvoke();
        Cat.staticInvoke();
        cat.staticInvoke();   //Вызов статического метода Animal
        Cat kitty = new Cat();
        kitty.staticInvoke();
    }

    public void foo(int value) {

    }

    public int foo(String value) {
        return 0;
    }
}
