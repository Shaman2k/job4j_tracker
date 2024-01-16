package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan");
        student.setGroup("some group");
        student.setDate(new Date());
        System.out.println("Name: " + student.getFullName() + ",  group: " + student.getGroup() + ", " + student.getDate());
    }
}
