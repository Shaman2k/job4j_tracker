package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.EmployeeAdapter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReportEngineJson implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportEngineJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeAdapter())
                .setPrettyPrinting()
                .create();
        return gson.toJson(store.findBy(filter));
    }
}