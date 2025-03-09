package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public int employeeLimit = 50;

    private final List<Employee> employees=new ArrayList<>(List.of(
            new Employee("Kadr","Oboev",20000,1),
            new Employee("Ruslan", "Isaev",20000, 2)));


    @Override
    public Employee addEmployee(String name, String surname)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, surname);
        if (employees.size() >= employeeLimit) {
            throw new EmployeeStorageIsFullException("EmployeeStorageIsFull");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("d");
        }
            employees.remove(employee);
            return null;
        }


    @Override
    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("d");
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;

    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
        return List.of();
    }

    @Override
    public List<Employee> getAllEmployeesByDepartmentId(Integer departmentId) {
        return List.of();
    }

}