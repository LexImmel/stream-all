package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class EmployeeServiceMapImpl implements EmployeeService {
    private final Integer employeeLimit = 10;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ivan Brajka", new Employee("Ivan", "Brajka", 200000,1),
            "Stepan Kurilov", new Employee("Stepan", "Kurilov",150000,2)));

    @Override
    public Employee addEmployee(String name, String surname)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, surname);
        if (employees.size() >= employeeLimit) {
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
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");

    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
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
