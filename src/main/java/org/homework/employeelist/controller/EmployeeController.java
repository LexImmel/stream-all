package org.homework.employeelist.controller;

import org.apache.commons.lang3.StringUtils;
import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.service.api.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        if (!StringUtils.isAlpha(employee.getName()) || (!StringUtils.isAlpha(employee.getSurname()))) {
            throw new IllegalArgumentException("Employee name or Surname cannot be empty");
        }
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping
    public Employee removeEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeService.removeEmployee(employee);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) throws EmployeeNotFoundException {
        return employeeService.findEmployee(name, surname);
    }


    @GetMapping("/allEmployees")

    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();

    }
}

