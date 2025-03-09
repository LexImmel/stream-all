package org.homework.employeelist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    private final String name;
    private final String surname;
    private double salary;
    private Integer departmentId;

    public String getFullName(){
        return name + " " + surname;
    }
}
