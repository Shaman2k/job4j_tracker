package ru.job4j.ood.ocp;

import java.sql.Connection;
import java.util.ArrayList;

public class ReportService {
    public class Logger {

        /*
        Нарушение принципа OCP
        Если понадобится не отправить лог на почту, а сохранить в файле.
        Выделить абстракцию Logger и передавать классу реализацию.
         */
        public void log(String message) {
            System.out.println("Лог отправлен на почту: " + message);
        }
    }

    /*
        Надо использовать абстракцию - List, вместо конкретной реализации.
     */
    private final ArrayList<String> data = new ArrayList<>();
    private Logger logger = new Logger();

    /*
        Сделать интерфейс, приватное поле с типом интерфейса и в конструкторе передавать реализацию.
     */
    public void send() {
        for (String string : data) {
            System.out.println("Save to disk");
        }
        logger.log("Report saved");
    }

}
