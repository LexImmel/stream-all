package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {

    Employee addEmployee(String name, String surname) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee removeEmployee(String name, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String name, String lastName) throws EmployeeNotFoundException;

    List<Employee> getAllEmployees();


       List<Employee> getEmployeesByDepartmentId(int departmentId);

    List<Employee> getEmployeesByDepartmentId(Integer departmentId);

   List<Employee> getAllEmployeesByDepartmentId(Integer departmentId);
}

