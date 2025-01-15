package ru.job4j.ood.srp;

import java.nio.file.Path;

public class Store {
    /*
                Создание объекта при инициализации вместо получения в конструкторе
     */
    private DiskStorage diskStorage = new DiskStorage(Path.of("Path to ditrctory"));

    public void add(String item) {
    }

    public void remove(String item) {

    }

    /*
    получение данных от элемента в хранилище, вместо получения элемента и работы с ним в другом классе
     */

    public int getPrice(String item) {
        return 0;
    }
}
