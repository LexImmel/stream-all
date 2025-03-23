package org.homework.employeelist.service.api;

import org.homework.employeelist.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee removeEmployee(Employee employee);
    Employee findEmployee(String name, String lastName);

    List<Employee> getAllEmployees();






}

