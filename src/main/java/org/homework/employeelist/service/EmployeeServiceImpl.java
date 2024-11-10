package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public int employeeLimit = 5;

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {this.employees = new HashMap<>();

    }


    @Override
    public Employee addEmployee(String name, String surname) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, surname);


        if (employees.size() == employeeLimit) {
            throw new EmployeeStorageIsFullException("EmployeeStorageIsFull");
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }

        employees.put(employee.getFullName(), employee);
        return employee;

    }


    @Override

    public Employee removeEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(employee.getFullName());

    }

    @Override
    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);

        if (employees.containsKey(employee.getFullName())) {
                return employees.get(employee.getFullName());
            } throw new EmployeeNotFoundException();

    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) Collections.unmodifiableCollection(employees.values());

    }
}