package org.homework.employeelist.controller;
import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.homework.employeelist.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam ("name") String name,
            @RequestParam ("surname") String surname

    ) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        return   employeeService.addEmployee(name,surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam ("name") String name,
            @RequestParam ("surname") String surname
    ) throws EmployeeNotFoundException {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam ("name") String name,
            @RequestParam ("surname") String surname
    ) throws EmployeeNotFoundException {
        return employeeService.findEmployee(name, surname);
    }



    @GetMapping("/allEmployees")

    public List <Employee>  getAllEmployees() {

        return employeeService.getAllEmployees();

    }
}

