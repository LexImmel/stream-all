//package org.homework.employeelist.service;
//
//import org.homework.employeelist.Employee;
//import org.homework.employeelist.exceptions.EmployeeNotFoundException;
//import org.homework.employeelist.exceptions.InvalidInputException;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//import static org.apache.commons.lang3.StringUtils.*;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//    public int employeeLimit = 50;
//    private List<Employee> employees = new ArrayList<>(List.of(
//            new Employee("John", "Doe", 20000, 1),
//            new Employee("Ruslan", "isaev", 20000, 2)));
//
//
//    @Override
//    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
//        validateInput(name, surname);
//
//        Employee employee = new Employee(name, surname);
//        if (employees.contains(employee)) {
//            return employee;
//        } else {
//            throw new EmployeeNotFoundException("Employee Not Found");
//        }
//    }
//
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employees;
//    }
//
////    @Override
////    public Employee addEmployee(Employee employee) {
////        if (employees.size() >= employeeLimit) {
////            throw new InvalidInputException("Employee Limit Exceeded");
////        }
////        if (employees.contains(employee)) {
////            throw new InvalidInputException("Employee Already Exists");
////        }
////        return employees.add(employee.getName() + employee.getSurname(), employee);
////    }
//
//    @Override
//    public Employee removeEmployee(Employee employee) {
//        return null;
//    }
//
//    @Override
//    public Employee addEmployee(String name, String surname) {
//        return null;
//    }
//
//    private void validateInput(String name, String surname) {
//        if (!(isAlpha(name) && isAlpha(surname))) ;
//        throw new InvalidInputException("Invalid Name or Surname");
//    }
//}