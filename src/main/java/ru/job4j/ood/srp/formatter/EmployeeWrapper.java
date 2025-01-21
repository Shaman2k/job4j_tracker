package ru.job4j.ood.srp.formatter;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.job4j.ood.srp.model.Employee;

import java.util.List;

@XmlRootElement(name = "employees")
public class EmployeeWrapper {
    private List<Employee> employees;

    public EmployeeWrapper() {
    }

    public EmployeeWrapper(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
