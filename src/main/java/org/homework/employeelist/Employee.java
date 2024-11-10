package org.homework.employeelist;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;


    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return surname + " " + name;
    }


    @Override
    public String toString() {
        return "Surname: " + surname + " Name: " + name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

}
