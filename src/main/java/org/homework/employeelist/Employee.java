package org.homework.employeelist;

import lombok.Data;

import static org.apache.commons.lang3.StringUtils.*;

@Data
public class Employee {
    private final String name;
    private final String surname;
    private Double salary;
    private Integer departmentId;

    public Employee(String name, String surname) {
        this.name = capitalize(name.toLowerCase());
        this.surname = capitalize(surname.toLowerCase());
    }

    public Employee(String name, String surname, double salary, Integer departmentId) {
        this.name = capitalize(name.toLowerCase());
        this.surname = capitalize(surname.toLowerCase());
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFullName(){
        return name + " " + surname;
    }
}
