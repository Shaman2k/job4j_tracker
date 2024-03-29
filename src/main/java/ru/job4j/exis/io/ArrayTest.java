package ru.job4j.exis.io;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int k = 4;
        int[][] array = getArray(k);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static int[][] getArray(int k) {
        int size = 2 + k * 2;
        int[][] array = new int[size][size];
        for (int n = 0; n < k; n++) {
            for (int i = n; i < size / 2; i++) {
                for (int j = n; j < size / 2; j++) {
                    if (i == n || j == n) {
                        array[i][j] = k - n;
                        array[i][size - j - 1] = k - n;
                        array[size - i - 1][j] = k - n;
                        array[size - i - 1][size - j - 1] = k - n;
                    }
                }
            }
        }
        return array;
    }
}
