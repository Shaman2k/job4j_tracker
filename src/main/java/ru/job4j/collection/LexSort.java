package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(getNumber(left), getNumber(right));
    }

    private int getNumber(String string) {
        return Integer.parseInt(string.split("\\.")[0]);
    }
}
