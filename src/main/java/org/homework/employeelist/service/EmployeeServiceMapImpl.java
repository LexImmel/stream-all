package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.InvalidInputException;
import org.homework.employeelist.service.api.EmployeeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class EmployeeServiceMapImpl implements EmployeeService {

    private static final String REGEX_NAME = "[a-zA-Zа-яА-Я]+";
    private static final Integer employeeLimit = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.size() >= employeeLimit) {
            throw new InvalidInputException("Employee Limit Exceeded");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new InvalidInputException("Employee Already Exists");
        }
        validateName(employee.getName());
        validateName(employee.getSurname());
        return employees.put(employee.getFullName(), employee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Employee not found");

        }
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
private void validateName(String name) {
        if (!name.matches(REGEX_NAME)) {
            throw new InvalidInputException("Name is invalid");
        }
}





}
