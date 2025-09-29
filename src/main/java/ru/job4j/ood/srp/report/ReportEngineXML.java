package ru.job4j.ood.srp.report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.EmployeeWrapper;
import ru.job4j.ood.srp.formatter.XmlDateAdapter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineXML implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportEngineXML(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";

        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setAdapter(new XmlDateAdapter());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            EmployeeWrapper employees = new EmployeeWrapper(store.findBy(filter));
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}