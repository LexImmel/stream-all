package org.homework.employeelist.controller;

import lombok.RequiredArgsConstructor;
import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.service.api.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{departmentId}/employees")
    public List<Employee> employees(@PathVariable Integer departmentId) {
        return departmentService.getByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/sum")
    public Double sumSalaryByDepartment(@PathVariable Integer departmentId) {
        return departmentService.sumSalaryByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/max")
    public Double maxSalaryByDepartment(@PathVariable Integer departmentId) throws EmployeeNotFoundException {

        return departmentService.maxSalaryByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/min")
    public Double minSalaryByDepartment(@PathVariable Integer departmentId) throws EmployeeNotFoundException {

        return departmentService.minSalaryByDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/all")
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return departmentService.getEmployeesByDepartment();
    }
}